package businessModel;

import Model.Server;
import Model.Task;

import java.util.List;

public interface Strategy {
    public void addTask(List<Server> severs, Task t);
}
