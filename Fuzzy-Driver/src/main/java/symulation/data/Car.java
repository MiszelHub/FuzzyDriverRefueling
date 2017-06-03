package symulation.data;

/**
 * Created by user on 03.06.2017.
 */
public class Car {

    private int fuelCapacity;
    private short fuelConsumptionPerHundredKilometers;
    private Road road;
    private int positionOnRoad=0;

    public Car(Road road) {
        this.road = road;
    }

    public int getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(int fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public short getFuelConsumptionPerHundredKilometers() {
        return fuelConsumptionPerHundredKilometers;
    }

    public void setFuelConsumptionPerHundredKilometers(short fuelConsumptionPerHundredKilometers) {
        this.fuelConsumptionPerHundredKilometers = fuelConsumptionPerHundredKilometers;
    }

    public Road getRoad() {
        return road;
    }

    public void setRoad(Road road) {
        this.road = road;
    }

    public int getPositionOnRoad() {
        return positionOnRoad;
    }

    public void setPositionOnRoad(int positionOnRoad) {
        this.positionOnRoad = positionOnRoad;
    }
}
