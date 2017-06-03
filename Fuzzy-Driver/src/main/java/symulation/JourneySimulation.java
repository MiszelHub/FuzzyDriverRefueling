package symulation;

import symulation.data.Car;
import symulation.data.OutOfFuelException;
import symulation.data.PetrolStation;
import symulation.data.Road;

/**
 * Created by user on 03.06.2017.
 */
public class JourneySimulation {
    private CarController carController;
    private Road road;


    public JourneySimulation(CarController carController, Road road) {
        this.carController = carController;
        this.road = road;
    }

    public void startSimulation() throws OutOfFuelException {
        while (carController.getCar().getPositionOnRoad() != road.getDistance()){

                driveToNextDestination(carController.getNextStation());

        }
    }

    private void driveToNextDestination(PetrolStation petrolStation) throws OutOfFuelException {
        int distanceToDrive = petrolStation.getPosition() - carController.getCar().getPositionOnRoad();
        float fuelToConsume = carController.getCar().getFuelConsumptionPerHundredKilometers()/100f;

        for (int i = 0; i < distanceToDrive; i++) {
            carController.consumeFuel(fuelToConsume);
        }
    }
}
