package symulation.data;

/**
 * Created by user on 04.06.2017.
 */
public class SiriInputData {
    public float fuelPriceOnCurrentStation;
    public int petrolStatnionsInRange;
    public int distanceToNextPetrolStation;
    public int distanceToJourneyEnd;

    @Override
    public String toString() {
        return "SiriInputData{" +
                "fuelPriceOnCurrentStation=" + fuelPriceOnCurrentStation +
                ", petrolStatnionsInRange=" + petrolStatnionsInRange +
                ", distanceToNextPetrolStation=" + distanceToNextPetrolStation +
                ", distanceToJourneyEnd=" + distanceToJourneyEnd +
                '}';
    }
}
