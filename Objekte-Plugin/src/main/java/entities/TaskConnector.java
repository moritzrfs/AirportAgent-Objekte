package entities;

import Plugin.Task.Task;
import Plugin.Task.TaskType;
import dhbw.sose2022.softwareengineering.airportagentsim.simulation.api.simulation.entity.Entity;
import dhbw.sose2022.softwareengineering.airportagentsim.simulation.api.simulation.entity.StaticEntity;
import java.util.ArrayList;
import java.util.function.Consumer;

public class TaskConnector extends StaticEntity {

    ArrayList<Task> tasks;
    public void connectTasks(TaskType taskType){
        tasks = new ArrayList<Task>();
        this.getWorld().getEntities().forEach(
                new Consumer<Entity>() {
                    @Override
                    public void accept(Entity entity) {
                        if(entity instanceof Task){
                            if(((Task) entity).taskIsApplicable(taskType)){
                                tasks.add((Task) entity);
                            }
                        }
                    }
                });
    }
    @Override
    public void pluginUpdate() {

    }
}
