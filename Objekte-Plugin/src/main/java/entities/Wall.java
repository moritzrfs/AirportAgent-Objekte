package entities;

import dhbw.sose2022.softwareengineering.airportagentsim.simulation.api.plugin.Plugin;
import dhbw.sose2022.softwareengineering.airportagentsim.simulation.api.simulation.World;
import dhbw.sose2022.softwareengineering.airportagentsim.simulation.api.simulation.entity.StaticEntity;
import dhbw.sose2022.softwareengineering.airportagentsim.simulation.simulation.SimulationWorld;
import lombok.Data;

public class Wall extends StaticEntity {

    private int length;
    private int height;
    private int xPos;
    private int yPos;
    private SimulationWorld world;
    private Plugin plugin;

    public Wall(int length, int height, int xPos, int yPos, SimulationWorld world, Plugin plugin) {
        this.length = length;
        this.height = height;
        this.xPos = xPos;
        this.yPos = yPos;
        this.world = world;
        this.plugin = plugin;
    }

    @Override
    public void pluginUpdate() {

    }
}