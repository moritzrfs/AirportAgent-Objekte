package entities;

import Plugin.Task.Task;
import Plugin.Task.TaskType;
import dhbw.sose2022.softwareengineering.airportagentsim.simulation.api.geometry.Point;
import dhbw.sose2022.softwareengineering.airportagentsim.simulation.api.plugin.Plugin;
import dhbw.sose2022.softwareengineering.airportagentsim.simulation.api.simulation.entity.Entity;
import dhbw.sose2022.softwareengineering.airportagentsim.simulation.api.simulation.entity.StaticEntity;
import dhbw.sose2022.softwareengineering.airportagentsim.simulation.api.simulation.message.LocalMessage;
import dhbw.sose2022.softwareengineering.airportagentsim.simulation.api.simulation.message.Message;
import dhbw.sose2022.softwareengineering.airportagentsim.simulation.simulation.SimulationWorld;

import java.util.ArrayList;
import java.util.function.Consumer;

public class BaggageDropOff extends StaticEntity {

    ArrayList<Task> tasks;

    private int length;
    private int height;
    private int xPos;
    private int yPos;
    private SimulationWorld world;
    private Plugin plugin;

    public BaggageDropOff(int length, int height, int xPos, int yPos, SimulationWorld world, Plugin plugin) {
        this.length = length;
        this.height = height;
        this.xPos = xPos;
        this.yPos = yPos;
        this.world = world;
        this.plugin = plugin;
    }

    public void receiveMessage(Message m){
        if(m instanceof BaggageSubmission){
        }
    }

    public void pluginUpdate() {
        if (this.getWorld().getIteration() == 0) {
            tasks = new ArrayList<Task>();
            this.getWorld().getEntities().forEach(
                    new Consumer<Entity>() {
                        @Override
                        public void accept(Entity entity) {
                            if (entity instanceof Task) {
                                if (((Task) entity).taskIsApplicable(TaskType.PERFORM_SECURITY_CHECK)) {
                                    tasks.add((Task) entity);
                                }
                            }
                        }
                    }
            );

            tasks.forEach(new Consumer<Task>() {

                @Override
                public void accept(Task task) {
                    //getWorld().sendMessage(new SecurityGateCheck(xPos, yPos));
                }
            });
        }
    }

    private static class BaggageSubmission implements LocalMessage {
        int xPos;
        int yPos;
        public BaggageSubmission(int xPos, int yPos){
            this.xPos = xPos;
            this.yPos = yPos;
        }
        public Entity getOrigin(){
            return null;
        }

        public Point getOriginPosition(){
            return new Point(this.xPos, this.yPos);
        }

        @Override
        public void fromString(String s) {

        }

        public int getMaxRange(){
            return 1;
        }
    }
}
