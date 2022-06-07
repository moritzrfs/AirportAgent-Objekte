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
    private int length;
    private int height;
    protected int xPos;
    protected int yPos;
    private SimulationWorld world;
    private Plugin plugin;
    protected boolean isOpen;
    private final int startLength;
    private final int startHeigth;


    public Door(int length, int height, int xPos, int yPos, SimulationWorld world, Plugin plugin, boolean isOpen){
        this.length = length;
        this.height = height;
        this.xPos = xPos;
        this.yPos = yPos;
        this.world = world;
        this.plugin = plugin;
        this.isOpen = isOpen;
        this.startHeigth = height;
        this.startLength = length;
    }

    public void openDoor(){
        if(this.isOpen){
            return;
        }else{
        this.length = 0;
        this.height = 0;
        this.isOpen = true;}
    }

    public void closeDoor(){
        if(this.isOpen){
            this.length = this.startLength;
            this.height = this.startHeigth;
            this.isOpen = false;
        }else return;  
    }

    @Override
    public void pluginUpdate() {

    }
}
