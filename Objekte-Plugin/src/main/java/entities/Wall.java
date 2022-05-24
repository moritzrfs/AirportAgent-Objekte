package entities;

import dhbw.sose2022.softwareengineering.airportagentsim.simulation.api.plugin.Plugin;
import dhbw.sose2022.softwareengineering.airportagentsim.simulation.api.simulation.World;
import dhbw.sose2022.softwareengineering.airportagentsim.simulation.api.simulation.entity.StaticEntity;
import lombok.Data;

@Data
public class Wall extends StaticEntity {

    private int length;
    private int height;
    private int xPos;
    private int yPos;
    private World world;
    private Plugin plugin;

    public Wall(){
    }

    @Override
    public void pluginUpdate() {

    }
}