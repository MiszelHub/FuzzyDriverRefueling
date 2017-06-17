package simulation.ai;

import FuzzyLogic.LinguisticVariableNotFoundException;
import simulation.data.SiriInputData;

/**
 * Created by user on 04.06.2017.
 */
public interface Siri {
    float estimateNeededFuel(SiriInputData inputData) throws LinguisticVariableNotFoundException;
}
