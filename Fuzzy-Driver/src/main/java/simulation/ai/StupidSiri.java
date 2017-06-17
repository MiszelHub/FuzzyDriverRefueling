package simulation.ai;

import org.apache.log4j.Logger;
import simulation.data.Car;
import simulation.data.SiriInputData;



/**
 * Created by user on 04.06.2017.
 */
public class StupidSiri implements Siri {
    private static final Logger logger = Logger.getLogger(StupidSiri.class);
    @Override
    public float estimateNeededFuel(SiriInputData inputData) {
        if(inputData.distanceToJourneyEnd > 0){
            return calculateFuelNeededToTheNextStation(inputData);

        }else{
            return 0f;
        }
    }

    public float calculateFuelNeededToTheNextStation(SiriInputData inputdata)
    {
        if(inputdata.distanceToNextPetrolStation > 0){

            float neededFuel = (inputdata.distanceToNextPetrolStation * Car.STANDARD_FUEL_CONSUMPTION)/100;
            logger.info("fuelAmmount "+(neededFuel + neededFuel*0.30f));
            return neededFuel + neededFuel*0.30f;
        }else {
            float neededFuel = (inputdata.distanceToJourneyEnd * Car.STANDARD_FUEL_CONSUMPTION)/100;
            logger.info("fuelAmmount "+(neededFuel + neededFuel*0.30f));
            return neededFuel + neededFuel*0.30f;
        }
    }
}
