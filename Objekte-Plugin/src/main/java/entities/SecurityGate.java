package entities;

import dhbw.sose2022.softwareengineering.airportagentsim.simulation.api.geometry.Point;
import dhbw.sose2022.softwareengineering.airportagentsim.simulation.api.plugin.Plugin;
import dhbw.sose2022.softwareengineering.airportagentsim.simulation.api.simulation.World;
import dhbw.sose2022.softwareengineering.airportagentsim.simulation.api.simulation.entity.Entity;
import dhbw.sose2022.softwareengineering.airportagentsim.simulation.api.simulation.entity.StaticEntity;
import dhbw.sose2022.softwareengineering.airportagentsim.simulation.api.simulation.message.LocalMessage;
import dhbw.sose2022.softwareengineering.airportagentsim.simulation.api.simulation.message.Message;
import dhbw.sose2022.softwareengineering.airportagentsim.simulation.simulation.SimulationWorld;

public class SecurityGate extends Door {
    public SecurityGate(int length, int height, int xPos, int yPos, SimulationWorld world, Plugin plugin, boolean isOpen){
        super(length, height, xPos, yPos, world, plugin, isOpen, 0);
    }

    public void pluginUpdate(){
        getWorld().sendMessage(new SecurityGate.SecurityGateCheck(this.xPos, this.yPos));
    }

    public void receiveMessage(Message m){
        if(m instanceof SecurityGate.SecurityGateCheck){

            // increase counter, if the Agent passes the door (only in workflow direction)
            this.counter++;
            this.openDoor();
        }
    }

    private static class SecurityGateCheck implements LocalMessage {
        int xPos;
        int yPos;
        public SecurityGateCheck(int xPos, int yPos){
            this.xPos = xPos;
            this.yPos = yPos;
        }
        public Entity getOrigin(){
            return null;
        }

        public Point getOriginPosition(){
            return new Point(this.xPos, this.yPos);
        }

        public int getMaxRange(){
            return 1;
        }
    }

    public boolean checkPackage(){
        return true;
    }
}
