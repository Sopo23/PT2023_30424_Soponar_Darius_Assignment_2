package businessModel;

import Model.Server;
import Model.Task;

import java.util.List;

public class ConcreteStrategyTime implements Strategy{
    @Override
    public void addTask(List<Server> severs, Task t) {
        int aux1=999;
        int index=0;
        for(int i=0;i<severs.size();i++){
            if(severs.get(i).getWaitingPeriod().intValue()<aux1){
                aux1=severs.get(i).getWaitingPeriod().intValue();
                index=i;
                }
            }
        severs.get(index).addTask(t);
        }
    }

