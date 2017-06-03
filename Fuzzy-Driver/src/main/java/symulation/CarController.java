package symulation;

import symulation.data.Car;
import symulation.data.OutOfFuelException;
import symulation.data.PetrolStation;
import symulation.data.Road;

/**
 * Created by user on 03.06.2017.
 */
public class CarController {
    private Car car;
    private Road road;
    private PetrolStation nextStation;

    public CarController(Car car, Road road) {
        this.car = car;
        this.road = road;
    }

    public PetrolStation getNextStation(){
        nextStation = this.road.getPetrolStations().poll();
        return nextStation;
    }

    public void consumeFuel(float fuel) throws OutOfFuelException {
        if (car.getCurrentFuelLevel() >= 0) {
            car.setCurrentFuelLevel(car.getCurrentFuelLevel() - fuel);
        }else{
            throw new OutOfFuelException("We are Out of Fuel");
        }
    }

    public void loadFuel(){

    }

    public Car getCar() {
        return car;
    }


    public Road getRoad() {
        return road;
    }
}
