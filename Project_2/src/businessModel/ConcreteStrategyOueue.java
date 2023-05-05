package businessModel;

import Model.Server;
import Model.Task;

import java.util.List;

public class ConcreteStrategyOueue implements Strategy{

    @Override
    public void addTask(List<Server> severs, Task t) {
        int zaza=999;
        int index=0;
        for(int i=0;i<severs.size();i++){
            if(severs.get(i).getTasks().size()<zaza){
                zaza=severs.get(i).getTasks().size();
                index=i;
            }
        }
        severs.get(index).addTask(t);
    }
}
