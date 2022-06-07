package entities;

import Plugin.Task.Task;
import Plugin.Task.TaskType;
import dhbw.sose2022.softwareengineering.airportagentsim.simulation.api.geometry.Point;
import dhbw.sose2022.softwareengineering.airportagentsim.simulation.api.plugin.Plugin;
import dhbw.sose2022.softwareengineering.airportagentsim.simulation.api.simulation.entity.Entity;
import dhbw.sose2022.softwareengineering.airportagentsim.simulation.api.simulation.message.LocalMessage;
import dhbw.sose2022.softwareengineering.airportagentsim.simulation.api.simulation.message.Message;
import dhbw.sose2022.softwareengineering.airportagentsim.simulation.simulation.SimulationWorld;

import java.util.ArrayList;
import java.util.function.Consumer;

public class SecurityGate extends Door {

    TaskConnector taskConnector;
    public SecurityGate(int length, int height, int xPos, int yPos, SimulationWorld world, Plugin plugin, boolean isOpen){
        super(length, height, xPos, yPos, world, plugin, isOpen);
    }

    public void pluginUpdate() {
        if (this.getWorld().getIteration() == 0) {
            taskConnector.connectTasks(TaskType.PERFORM_SECURITY_CHECK);
        }
    }

        public void receiveMessage(Message m){
            if (m instanceof SecurityGateCheck) {
                this.openDoor();
            }
        }

        private static class SecurityGateCheck implements LocalMessage {
            int xPos;
            int yPos;

            public SecurityGateCheck(int xPos, int yPos) {
                this.xPos = xPos;
                this.yPos = yPos;
            }

            public Entity getOrigin() {
                return null;
            }

            public Point getOriginPosition() {
                return new Point(this.xPos, this.yPos);
            }

            @Override
            public void fromString(String s) {

            }

            public int getMaxRange() {
                return 1;
            }
        }

        public boolean checkPackage () {
            return true;
        }
    }
