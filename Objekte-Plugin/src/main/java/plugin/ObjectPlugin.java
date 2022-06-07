package plugin;

import Plugin.Task.Task;
import Plugin.Task.TaskType;
import dhbw.sose2022.softwareengineering.airportagentsim.simulation.api.AirportAgentSimulation;
import dhbw.sose2022.softwareengineering.airportagentsim.simulation.api.config.ConfigurationFormatException;
import dhbw.sose2022.softwareengineering.airportagentsim.simulation.api.simulation.entity.Entity;
import entities.BaggageDropOff;
import entities.*;

import java.util.ArrayList;
import java.util.function.Consumer;

public class ObjectPlugin implements dhbw.sose2022.softwareengineering.airportagentsim.simulation.api.plugin.Plugin {


    @Override
    public void activate() {
        try {
            AirportAgentSimulation.registerEntity(this, "wall", Wall.class);
            AirportAgentSimulation.registerEntity(this, "baggageDropOff", BaggageDropOff.class);
            AirportAgentSimulation.registerEntity(this, "door", Door.class);
            AirportAgentSimulation.registerEntity(this, "securityGate", SecurityGate.class);
            AirportAgentSimulation.registerEntity(this, "ticketCounter", TicketCounter.class);
        } catch (ConfigurationFormatException e) {
            e.printStackTrace();
        }

    }

}
