package businessModel;

import Model.Server;
import Model.Task;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Scheduler {
    private List<Server> servers;
    private int maxNoServers;
    private int maxTasksPerServers;
    private Strategy strategy;

    public Scheduler(int maxNoServers, JTextArea jTextArea )
    {
        this.servers = new ArrayList<Server>();
        this.maxNoServers = maxNoServers;
        strategy = new ConcreteStrategyTime();
        for(int i = 0; i<maxNoServers; i++)
        {
            servers.add(new Server(jTextArea));
        }
    }

    public void changeStrategy(SelectionPolicy policy){

        if(policy == SelectionPolicy.SHORTEST_QUEUE){
            strategy = new ConcreteStrategyOueue();
        }
        if(policy == SelectionPolicy.SHORTEST_TIME){
            strategy = new ConcreteStrategyTime();
        }
    }
    public synchronized void dispatchTask(Task t){
        strategy.addTask(servers,t);
    }
    public synchronized List<Server> getServers(){
        return servers;
    }
}
