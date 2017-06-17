package simulation.data;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by user on 03.06.2017.
 */
public class Road
{
    private int distance = 2000;
    private final Queue<PetrolStation> petrolStations;
    public Road()
    {
        petrolStations = new LinkedList<>();
    }

    public Road(int distance)
    {
        this.distance = distance;
        petrolStations = new LinkedList<>();
    }

    public void addPetrolStation(PetrolStation petrolStation){
        petrolStations.add(petrolStation);
    }
    public int getDistance()
    {
        return distance;
    }

    public Queue<PetrolStation> getPetrolStations() {
        return petrolStations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Road road = (Road) o;

        if (distance != road.distance) return false;
        return petrolStations != null ? petrolStations.equals(road.petrolStations) : road.petrolStations == null;
    }

    @Override
    public int hashCode() {
        int result = distance;
        result = 31 * result + ( petrolStations != null ? petrolStations.hashCode() : 0 );
        return result;
    }
}
