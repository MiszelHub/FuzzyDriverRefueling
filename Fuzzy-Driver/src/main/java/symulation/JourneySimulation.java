package symulation;

import FuzzyLogic.LinguisticVariableNotFoundException;
import app.App;
import org.apache.log4j.Logger;
import symulation.exceptions.OutOfFuelException;
import symulation.data.PetrolStation;
import symulation.data.Road;

/**
 * Created by user on 03.06.2017.
 */
public class JourneySimulation {
    private CarController carController;
    private Road road;
    final static Logger logger = Logger.getLogger(JourneySimulation.class);

    public JourneySimulation(CarController carController, Road road) {
        this.carController = carController;
        this.road = road;
    }

    public void startSimulation() throws OutOfFuelException, LinguisticVariableNotFoundException {
        while (carController.getCar().getPositionOnRoad() != road.getDistance()) {


            if (!road.getPetrolStations().isEmpty()) {
                if (carController.getCar().getPositionOnRoad() == carController.getNextStation().getPosition()) {
                    logger.info("Arrived at station " + carController.getNextStation().toString());
                    carController.analyzeFuelSituation();
                }
            }

            drive();

        }
        logger.info("Arrived at destination "+carController.getCar().getPositionOnRoad());
    }

    private void drive() throws OutOfFuelException {

        float fuelToConsume = carController.getCar().getFuelConsumptionPerHundredKilometers() / 100f;

        carController.consumeFuel(fuelToConsume);
        carController.getCar().setPositionOnRoad(carController.getCar().getPositionOnRoad() + 1);
    }
}
