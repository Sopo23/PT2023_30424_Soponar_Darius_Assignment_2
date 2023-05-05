package businessModel;

import Model.Server;
import Model.Task;
import View.SimulationGUI;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class SimulationManager implements Runnable{
    public int timeLimit;
    public int maxProcessingTime;
    public int minProcessingTime;
    public int minArrival;
    public int maxArrival;
    public int numberOfServers;
    public int numberOfTasks;
    public int maxTasksPerServers;
    public static SelectionPolicy SelectionPolicy;
    public int logged;
    private Scheduler scheduler;
    //private GUI gui;
    private List<Task> generatedTasks = Collections.synchronizedList(new ArrayList<Task>());;
    private List<Thread> threadList = Collections.synchronizedList(new ArrayList<Thread>());
    private JTextArea jTextArea;
    public SimulationManager(){}

    public int getSignal()
    {
        return logged;
    }
    public SimulationManager(int timeLimit, int maxProcessingTime, int minProcessingTime, int numberOfServers, int numberOfTasks,
                             SelectionPolicy SelectionPolicy, int minArrival, int maxArrival, JTextArea jTextArea, int logged) {
        this.timeLimit = timeLimit;
        this.jTextArea = jTextArea;
        this.maxProcessingTime = maxProcessingTime;
        this.minProcessingTime = minProcessingTime;
        this.numberOfServers = numberOfServers;
        this.minArrival = minArrival;
        this.maxArrival = maxArrival;
        this.logged = logged;
        this.numberOfTasks = numberOfTasks;
        this.SelectionPolicy = SelectionPolicy;

        scheduler = new Scheduler(numberOfServers, jTextArea);
        generateNRandomTasks();
        for(int i = 0; i < numberOfServers; i++)
        {
            threadList.add(new Thread(scheduler.getServers().get(i)));
        }
    }
    private void generateNRandomTasks(){
        for(int i = 0; i < numberOfTasks; i++)
        {
            int arrival, service;
            Random rand = new Random();
            arrival = rand.nextInt(maxArrival - minArrival) + minArrival;
            service = rand.nextInt(maxProcessingTime - minProcessingTime) + minProcessingTime;
            Task c = new Task(i, arrival, service);
            generatedTasks.add(c);
        }
        generatedTasks.sort(Comparator.comparing(Task::getArrivalTime));
        for(int i = 0; i < numberOfTasks; i++)
        {
            System.out.println(generatedTasks.get(i).toString());
        }
    }
    int peakHour = 0, averageWaitingTime = 0, averageServiceTime = 0, max = 0, dispatchedTasks = 0, qWaitTimePerStep = 0;
    @Override
    public  void run()
    {
        beginServsers();
        int currentTime = 0;
        while(currentTime < timeLimit && !emptyServers())
        {
            jTextArea.append(("Moment" + currentTime + ": \n"));
            System.out.println("Moment" + currentTime + ": ");

            Iterator i = generatedTasks.iterator();
            while(i.hasNext())
            {
                Task c = (Task) i.next();
                if(currentTime == c.getArrivalTime())
                {
                    averageServiceTime += c.getServiceTime();
                    scheduler.dispatchTask(c);
                    dispatchedTasks++;
                    i.remove();
                }
            }

            notify1();
            try {
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int counter = 0, waitingQueues = 0;
            for (int j = 0; j < scheduler.getServers().size(); j++) {
                waitingQueues += scheduler.getServers().get(j).getWaitingPeriod().get();
                counter += scheduler.getServers().get(j).getTasks().size();
                if(counter>max)
                {
                    max = counter;
                    peakHour =  currentTime;
                }
            }
            waitingQueues /= numberOfServers;
            qWaitTimePerStep += waitingQueues;
            currentTime++;
        }

            for (int j = 0; j < threadList.size(); j++)
                threadList.get(j).interrupt();
            try {
                FileWriter fw = new FileWriter("logFile" + logged + ".txt");
                fw.write(jTextArea.getText());
                fw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            System.out.println(averageServiceTime + " " + dispatchedTasks);
            qWaitTimePerStep /= timeLimit;
            averageWaitingTime = qWaitTimePerStep;
            averageServiceTime /= dispatchedTasks;

            SimulationGUI gstats = new SimulationGUI(peakHour, averageWaitingTime, averageServiceTime);
            gstats.getFrame().setVisible(true);

    }
    public boolean emptyServers() {
        for (Server server : scheduler.getServers()) {
            if (!server.getTasks().isEmpty()) {
                return false;
            }
        }
        return generatedTasks.isEmpty();
    }

    private void notify1() {
        for(Server server : scheduler.getServers()){
            synchronized (server) {
                server.notify();
            }
        }
    }

    private void beginServsers() {
        for(int i = 0; i < scheduler.getServers().size(); i++)
        {
            threadList.get(i).setName("Server " + i);
            threadList.get(i).start();
        }
    }
}
