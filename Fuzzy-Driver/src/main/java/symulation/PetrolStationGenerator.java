package symulation;

import symulation.data.PetrolStation;
import symulation.data.Road;

/**
 * Created by user on 03.06.2017.
 */

public class PetrolStationGenerator {
    private Road road;
    private int minimalDistanceBetweenStations = 50;
    private int maximumDistanceBetweenStations = 200;
    private float minimalFuelPrice = 3.5f;
    private float maximumFuelPrice = 4f;

    public PetrolStationGenerator(Road road) {
        this.road = road;
    }

    public void generateStationsOnTheRoad(){
        RandomIntegerGenerator generator = new RandomIntegerGenerator();
        int lastStationPosition = 0;
        road.addPetrolStation(generateStation(lastStationPosition));

        while (lastStationPosition < road.getDistance()){
           int nextStationDistance = generator.generateNumberFromRange(minimalDistanceBetweenStations,maximumDistanceBetweenStations);

           if(lastStationPosition+nextStationDistance <= road.getDistance()){
                road.addPetrolStation(generateStation(lastStationPosition+nextStationDistance));
                lastStationPosition += nextStationDistance;
           }else{
               break;
           }

        }
    }

    private PetrolStation generateStation(int positionOnRoad){
        float fuelPrice = new RandomFloatGenerator().generateNumberFromRange(minimalFuelPrice,maximumFuelPrice);

        return new PetrolStation(positionOnRoad,fuelPrice);
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

    public int getMaximumDistanceBetweenStations() {
        return maximumDistanceBetweenStations;
    }

    public void setMaximumDistanceBetweenStations(int maximumDistanceBetweenStations) {
        this.maximumDistanceBetweenStations = maximumDistanceBetweenStations;
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
