package symulation;

import org.apache.log4j.Logger;
import symulation.data.Car;
import symulation.data.SiriInputData;
import symulation.exceptions.OutOfFuelException;
import symulation.data.PetrolStation;
import symulation.data.Road;

import java.util.ArrayList;

/**
 * Created by user on 03.06.2017.
 */
public class CarController {
    private Car car;
    private Road road;
    private PetrolStation nextStation;
    private Siri siri;
    final static Logger logger = Logger.getLogger(CarController.class);

    public CarController(Car car, Road road, Siri siri) {
        this.car = car;
        this.road = road;
        this.siri = siri;
    }

    public PetrolStation getNextStation() {

        return road.getPetrolStations().peek();
    }

    public void consumeFuel(float fuel) throws OutOfFuelException {
        if (car.getCurrentFuelLevel() >= 0) {
            car.setCurrentFuelLevel(car.getCurrentFuelLevel() - fuel);
        } else {
            throw new OutOfFuelException("We are Out of Fuel");
        }
    }

    public void analyzeFuelSituation() {
        PetrolStation petrolStation = road.getPetrolStations().poll();

        SiriInputData inputData = new SiriInputData();
        inputData.fuelPriceOnCurrentStation = petrolStation.getPetrolPrice();
        inputData.distanceToJourneyEnd = estimateDistanceToJourneyEnd();
       if(!road.getPetrolStations().isEmpty()){
           inputData.distanceToNextPetrolStation = calculateDistanceToNextPetrolStation();
           inputData.petrolStatnionsInRange = calculatePetrolStationsInRange();
       }else{
           inputData.distanceToNextPetrolStation = 0;
           inputData.petrolStatnionsInRange = 0;
       }


        logger.info(inputData.toString());

        loadFuel(siri.estimateNeededFuel(inputData));

    }

    private int calculatePetrolStationsInRange() {
        float carRange = calculateCarRangeInKilometers();
        ArrayList<PetrolStation> stations = new ArrayList<>(road.getPetrolStations());

        Long stationsInRangeCount = stations.stream()
                .map(PetrolStation::getPosition)
                .filter(petrolStationPosition -> petrolStationPosition - car.getPositionOnRoad() <= carRange)
                .count();

        return stationsInRangeCount.intValue();
    }

    private int calculateCarRangeInKilometers() {
        return (int) ( car.getCurrentFuelLevel() / ( car.getFuelConsumptionPerHundredKilometers() / 100 ) );
    }

    private int estimateDistanceToJourneyEnd() {
        return road.getDistance() - car.getPositionOnRoad();
    }

    private int calculateDistanceToNextPetrolStation() {
        return road.getPetrolStations().peek().getPosition() - car.getPositionOnRoad();
    }

    public void loadFuel(float fuelAmmount) {
        float fuelPossibleToTank = car.getFuelCapacity() - car.getCurrentFuelLevel();

        if (fuelAmmount > fuelPossibleToTank) {
            car.setCurrentFuelLevel(car.getCurrentFuelLevel() + fuelPossibleToTank);
        } else {
            car.setCurrentFuelLevel(car.getCurrentFuelLevel() + fuelAmmount);
        }

    }

    public Car getCar() {
        return car;
    }


    public Road getRoad() {
        return road;
    }
}
