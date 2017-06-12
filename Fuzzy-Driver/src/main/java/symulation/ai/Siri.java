package symulation.ai;

import FuzzyLogic.LinguisticVariableNotFoundException;
import symulation.data.PetrolStation;
import symulation.data.SiriInputData;

/**
 * Created by user on 04.06.2017.
 */
public interface Siri {
    float estimateNeededFuel(SiriInputData inputData) throws LinguisticVariableNotFoundException;
}
