package symulation;

import symulation.data.Road;

/**
 * Created by user on 03.06.2017.
 */

public class PetrolStationGenerator {
    private Road road;
    private int minimalDistanceBetweenStations = 50;
    private int DistanceBetweenStations = 200;
    private float minimalFuelPrice = 3.5f;
    private float maximumFuelPrice = 4f;

    public PetrolStationGenerator(Road road) {
        this.road = road;
    }

    public Road getRoad() {
        return road;
    }

    public void setRoad(Road road) {
        this.road = road;
    }

    public int getMinimalDistanceBetweenStations() {
        return minimalDistanceBetweenStations;
    }

    public void setMinimalDistanceBetweenStations(int minimalDistanceBetweenStations) {
        this.minimalDistanceBetweenStations = minimalDistanceBetweenStations;
    }

    public int getDistanceBetweenStations() {
        return DistanceBetweenStations;
    }

    public void setDistanceBetweenStations(int distanceBetweenStations) {
        DistanceBetweenStations = distanceBetweenStations;
    }

    public float getMinimalFuelPrice() {
        return minimalFuelPrice;
    }

    public void setMinimalFuelPrice(float minimalFuelPrice) {
        this.minimalFuelPrice = minimalFuelPrice;
    }

    public float getMaximumFuelPrice() {
        return maximumFuelPrice;
    }

    public void setMaximumFuelPrice(float maximumFuelPrice) {
        this.maximumFuelPrice = maximumFuelPrice;
    }
}
