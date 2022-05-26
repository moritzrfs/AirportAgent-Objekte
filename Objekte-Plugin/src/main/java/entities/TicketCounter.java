package entities;

import dhbw.sose2022.softwareengineering.airportagentsim.simulation.api.plugin.Plugin;
import dhbw.sose2022.softwareengineering.airportagentsim.simulation.api.simulation.World;
import dhbw.sose2022.softwareengineering.airportagentsim.simulation.api.simulation.entity.StaticEntity;

public class TicketCounter extends Door {
    public TicketCounter(int length, int height, int xPos, int yPos, World world, Plugin plugin, boolean isOpen){
        super(length, height, xPos, yPos, world, plugin, isOpen);
    }

    public boolean checkTicket(){
        return true;
    }
}
