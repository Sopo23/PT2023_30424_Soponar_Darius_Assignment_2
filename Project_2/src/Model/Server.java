package Model;

import javax.swing.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Server implements Runnable {
    private BlockingQueue<Task> tasks;
    private AtomicInteger waitingPeriod;
    private JTextArea jTextArea;
    private boolean stop;
    public void setStop(boolean stop) {
        this.stop = stop;
    }

    public Server(JTextArea jTextArea){
        tasks = new LinkedBlockingQueue<Task>();
        this.jTextArea = jTextArea;
        waitingPeriod = new AtomicInteger(0);
        this.stop=false;
    }
    public BlockingQueue<Task> getTasks() {
        return tasks;
    }

    public void setTasks(BlockingQueue<Task> tasks) {
        this.tasks = tasks;
    }

    public AtomicInteger getWaitingPeriod() {
        return waitingPeriod;
    }

    public void setWaitingPeriod(AtomicInteger waitingPeriod) {
        this.waitingPeriod = waitingPeriod;
    }
    public synchronized void addTask(Task newTask) {
        tasks.add(newTask);
        waitingPeriod.set(waitingPeriod.intValue() + newTask.getServiceTime());
    }

    @Override
    public synchronized void run() {
        while(!stop){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            jTextArea.append(Thread.currentThread().getName()+" will do: " + this.tasks.toString() + ". Waiting time:" + this.waitingPeriod.get() + "\n");
            System.out.println(Thread.currentThread().getName()+" will do: " + this.tasks.toString() + ". Waiting time:" + this.waitingPeriod.get());
            Task c = null;
            if(!tasks.isEmpty()) {
                c = tasks.element();
                c.setServiceTime(c.getServiceTime() - 1);
            }

            //System.out.println(sum);
            if(this.waitingPeriod.get() > 0)
                this.waitingPeriod.addAndGet(-1);
            if(c != null && (c.getServiceTime() == 0  || this.waitingPeriod.get() == 0))
            {
                tasks.poll();
            }
            try {
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
