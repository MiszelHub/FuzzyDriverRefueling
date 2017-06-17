package simulation;

import FuzzyLogic.LinguisticVariableNotFoundException;
import org.apache.log4j.Logger;
import simulation.data.Car;
import simulation.exceptions.OutOfFuelException;
import simulation.data.Road;
import simulation.generators.ProbabilityGenerator;

/**
 * Created by user on 03.06.2017.
 */
public class JourneySimulation {
    private CarController carController;
    private Road road;
    private boolean isRandomEventEnabled;
    private float totalFuel = 0.0f;
    private ProbabilityGenerator probabilityGenerator;
    final static Logger logger = Logger.getLogger(JourneySimulation.class);

    public JourneySimulation(CarController carController, Road road, boolean isRandomEventEnabled) {
        this.carController = carController;
        this.road = road;
        this.isRandomEventEnabled = isRandomEventEnabled;
        probabilityGenerator = new ProbabilityGenerator();
    }

    public void startSimulation() throws OutOfFuelException, LinguisticVariableNotFoundException {
        while (carController.getCar().getPositionOnRoad() != road.getDistance()) {


            if (!road.getPetrolStations().isEmpty()) {
                if (carController.getCar().getPositionOnRoad() == carController.getNextStation().getPosition()) {
                    carController.getCar().setFuelConsumptionPerHundredKilometers(Car.STANDARD_FUEL_CONSUMPTION);
                    logger.info("Arrived at station " + carController.getNextStation().toString());
                    totalFuel += carController.analyzeFuelSituation();

                    if (isRandomEventEnabled(isRandomEventEnabled)) {
                        if (probabilityGenerator.isProbable(0.25)) {

                            carController.getCar().modifyFuelConsumptionPerHundredKilometers(randomEventFuelConsumptionModifier(probabilityGenerator.isProbable(0.5)));
                        }
                    }
                    logger.info("Fuel Consumption " + carController.getCar().getFuelConsumptionPerHundredKilometers());
                }
            }

            drive();

        }
        logger.info("Arrived at destination " + carController.getCar().getPositionOnRoad());
        logger.info("Journey Cost " + totalFuel);
    }

    private void drive() throws OutOfFuelException {

        float fuelToConsume = carController.getCar().getFuelConsumptionPerHundredKilometers() / 100f;

        carController.consumeFuel(fuelToConsume);
        carController.getCar().setPositionOnRoad(carController.getCar().getPositionOnRoad() + 1);
    }

    private boolean isRandomEventEnabled(boolean isEnabled) {
        return isEnabled;
    }

    private float randomEventFuelConsumptionModifier(boolean isFuelConsumptionIncreased) {
        if (isFuelConsumptionIncreased) {
            return 2f;
        } else {
            return -1f;
        }
    }
}
