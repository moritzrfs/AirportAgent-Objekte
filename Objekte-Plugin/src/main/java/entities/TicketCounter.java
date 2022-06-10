package entities;

import Plugin.Task.Task;
import Plugin.Task.TaskMessage;
import Plugin.Task.TaskType;
import dhbw.sose2022.softwareengineering.airportagentsim.simulation.api.geometry.Point;
import dhbw.sose2022.softwareengineering.airportagentsim.simulation.api.plugin.Plugin;
import dhbw.sose2022.softwareengineering.airportagentsim.simulation.api.simulation.World;
import dhbw.sose2022.softwareengineering.airportagentsim.simulation.api.simulation.entity.StaticEntity;
import dhbw.sose2022.softwareengineering.airportagentsim.simulation.api.simulation.entity.Entity;
import dhbw.sose2022.softwareengineering.airportagentsim.simulation.api.simulation.message.Message;
import dhbw.sose2022.softwareengineering.airportagentsim.simulation.api.simulation.message.DirectedMessage;
import dhbw.sose2022.softwareengineering.airportagentsim.simulation.api.simulation.message.LocalMessage;
import dhbw.sose2022.softwareengineering.airportagentsim.simulation.simulation.SimulationWorld;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Consumer;

public class TicketCounter extends entities.Door {

    ArrayList<Task> tasks;
    ArrayList<Entity> clients;
    TaskConnector taskConnector;

    public boolean checkTicket(){
        return true;
    }

    public void pluginUpdate(){
        if (this.getWorld().getIteration() == 0){
            taskConnector.connectTasks(TaskType.PERFORM_TICKET_CHECK);
        }

        tasks.forEach(new Consumer<Task>() {
            @Override
            public void accept(Task task) {
                getWorld().sendMessage(new TicketCheck(getPosition().getX(), getPosition().getX()));
            }
        });
        clients.forEach(new Consumer<Entity>() {
            @Override
            public void accept(Entity entity) {
                if(entity.getPosition().getX() > xPos && isOpen){
                    closeDoor();
                }
            }
        });
    }

    public void receiveMessage(Message m){
        if(m instanceof TaskMessage){
            this.openDoor();
            clients.add(((TaskMessage) m).getOrigin());
        }
    }

    private static class TicketCheck implements LocalMessage, DirectedMessage {
        int xPos;
        int yPos;

        Task target;
        public TicketCheck(int xPos, int yPos){
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

        @Override
        public Entity getTarget() {
            return this.target;
        }
    }

}
