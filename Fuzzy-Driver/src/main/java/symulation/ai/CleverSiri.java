package symulation.ai;

import FuzzyLogic.Defuzyfier;
import FuzzyLogic.Fuzzyfier;
import FuzzyLogic.ImplicationController;
import symulation.data.SiriInputData;

/**
 * Created by user on 12.06.2017.
 */
public class CleverSiri implements Siri{
    Fuzzyfier<Float> fuzzyfier;
    ImplicationController implicationController;
    Defuzyfier defuzyfier;

    public CleverSiri(ImplicationController implicationController, Defuzyfier defuzyfier) {
        this.implicationController = implicationController;
        this.defuzyfier = defuzyfier;
    }

    @Override
    public float estimateNeededFuel(SiriInputData inputData) {
        //fuzzyfier.FuzzyfyVariable()
        return 0;
    }
}
