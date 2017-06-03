package symulation.data;

/**
 * Created by user on 03.06.2017.
 */
public class Car {

    private float fuelCapacity = 35f;
    private float currentFuelLevel = 0;
    private float fuelConsumptionPerHundredKilometers = 7;
    private int positionOnRoad = 0;

    public Car() {

    }


    public float getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(float fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }


    public float getFuelConsumptionPerHundredKilometers() {
        return fuelConsumptionPerHundredKilometers;
    }

    public void setFuelConsumptionPerHundredKilometers(short fuelConsumptionPerHundredKilometers) {
        this.fuelConsumptionPerHundredKilometers = fuelConsumptionPerHundredKilometers;
    }


    public int getPositionOnRoad() {
        return positionOnRoad;
    }

    public void setPositionOnRoad(int positionOnRoad) {
        this.positionOnRoad = positionOnRoad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (fuelCapacity != car.fuelCapacity) return false;
        if (fuelConsumptionPerHundredKilometers != car.fuelConsumptionPerHundredKilometers) return false;
        return positionOnRoad == car.positionOnRoad;
    }

    @Override
    public int hashCode() {
        int result = (int) fuelCapacity;
        result = 31 * result + (int) fuelConsumptionPerHundredKilometers;
        result = 31 * result + positionOnRoad;
        return result;
    }

    public float getCurrentFuelLevel() {
        return currentFuelLevel;
    }

    public void setCurrentFuelLevel(float currentFuelLevel) {
        this.currentFuelLevel = currentFuelLevel;
    }
}
