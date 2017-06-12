package symulation.data;

/**
 * Created by user on 04.06.2017.
 */
public class SiriInputData {
    public float fuelPriceOnCurrentStation;
    public int petrolStationsInRange;
    public int distanceToNextPetrolStation;
    public int distanceToJourneyEnd;

    @Override
    public String toString(){
        return "SiriInputData{" +
                "fuelPriceOnCurrentStation=" + fuelPriceOnCurrentStation +
                ", petrolStationsInRange=" + petrolStationsInRange +
                ", distanceToNextPetrolStation=" + distanceToNextPetrolStation +
                ", distanceToJourneyEnd=" + distanceToJourneyEnd +
                '}';
    }
}
