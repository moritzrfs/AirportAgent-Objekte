package entities;

import Plugin.Task.Task;
import Plugin.Task.TaskType;
import dhbw.sose2022.softwareengineering.airportagentsim.simulation.api.plugin.Plugin;
import dhbw.sose2022.softwareengineering.airportagentsim.simulation.api.simulation.World;
import dhbw.sose2022.softwareengineering.airportagentsim.simulation.api.simulation.entity.Entity;
import dhbw.sose2022.softwareengineering.airportagentsim.simulation.api.simulation.entity.StaticEntity;
import dhbw.sose2022.softwareengineering.airportagentsim.simulation.simulation.SimulationWorld;
import lombok.Data;

import java.util.ArrayList;
import java.util.function.Consumer;

public class Door extends StaticEntity {

    protected boolean isOpen = false;


    public void openDoor(){
        if(this.isOpen){
            return;
        }else{
        setSolid(false);
        this.isOpen = true;}
    }

    public void closeDoor(){
        if(this.isOpen){
            setSolid(true);
            this.isOpen = false;
        }else return;  
    }

    @Override
    public void pluginUpdate() {

    }
}
