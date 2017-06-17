package simulation.ai;

import simulation.data.SiriInputData;

/**
 * Created by user on 04.06.2017.
 */
public class StupidSiri implements Siri {
    @Override
    public float estimateNeededFuel(SiriInputData inputData) {
        if(inputData.distanceToJourneyEnd > 0){
            return calculateFuelNeededToTheNextStation(inputData.distanceToNextPetrolStation);

        }else{
            return 0f;
        }
    }

    public float calculateFuelNeededToTheNextStation(float distanceToTheNextStation)
    {
        float neededFuel = distanceToTheNextStation * 0.07f;
        return neededFuel + neededFuel*0.1f;
    }
}
