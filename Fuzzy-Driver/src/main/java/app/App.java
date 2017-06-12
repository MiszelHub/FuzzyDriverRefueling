package app;


import org.apache.log4j.Logger;
import symulation.CarController;
import symulation.JourneySimulation;
import symulation.generators.PetrolStationGenerator;
import symulation.ai.StupidSiri;
import symulation.data.Car;
import symulation.data.Road;
import symulation.exceptions.OutOfFuelException;

/**
 * Hello world!
 *
 */
public class App 
{
    final static Logger logger = Logger.getLogger(App.class);

    public static void main( String[] args )
    {
        Car car = new Car();
        Road road = new Road();
        CarController carController = new CarController(car,road,new StupidSiri());

        PetrolStationGenerator petrolStationGenerator = new PetrolStationGenerator(road);
        petrolStationGenerator.generateStationsOnTheRoad();


        JourneySimulation journeySimulation = new JourneySimulation(carController,road);

        try {
            logger.info("started simulation");
            journeySimulation.startSimulation();
        } catch (OutOfFuelException e) {
            e.printStackTrace();
        }
    }
}
