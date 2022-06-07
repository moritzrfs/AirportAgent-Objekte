package plugin;

import entities.BaggageDropOff;
import entities.*;

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
