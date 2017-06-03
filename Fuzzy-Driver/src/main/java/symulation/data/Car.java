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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (fuelCapacity != car.fuelCapacity) return false;
        if (fuelConsumptionPerHundredKilometers != car.fuelConsumptionPerHundredKilometers) return false;
        if (positionOnRoad != car.positionOnRoad) return false;
        return road != null ? road.equals(car.road) : car.road == null;
    }

    @Override
    public int hashCode() {
        int result = fuelCapacity;
        result = 31 * result + (int) fuelConsumptionPerHundredKilometers;
        result = 31 * result + ( road != null ? road.hashCode() : 0 );
        result = 31 * result + positionOnRoad;
        return result;
    }
}
