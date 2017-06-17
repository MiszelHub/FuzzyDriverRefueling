package simulation.ai;

import simulation.data.SiriInputData;

/**
 * Created by user on 04.06.2017.
 */
public class StupidSiri implements Siri {
    @Override
    public float estimateNeededFuel(SiriInputData inputData) {
        if(inputData.distanceToJourneyEnd > 0){
            return 35f;
        }else{
            return 0f;
        }
    }
}
