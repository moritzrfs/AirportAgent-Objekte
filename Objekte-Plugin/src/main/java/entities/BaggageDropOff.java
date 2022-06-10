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

public class BaggageDropOff extends StaticEntity {

    TaskConnector taskConnector;

    public void receiveMessage(Message m){
        if(m instanceof BaggageSubmission){
        }
    }

    public void pluginUpdate() {
        if (this.getWorld().getIteration() == 0) {
            taskConnector.connectTasks(TaskType.DROP_LUGGAGE);
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
