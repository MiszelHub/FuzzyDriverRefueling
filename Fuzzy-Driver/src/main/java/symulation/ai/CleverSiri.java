package symulation.ai;

import FuzzyLogic.*;
import FuzzyLogic.RuleSet.RuleResult;
import symulation.data.SiriInputData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 12.06.2017.
 */
public class CleverSiri implements Siri {
    Fuzzyfier<Float> fuzzyfier;
    ImplicationController implicationController;
    Defuzyfier defuzyfier;

    public CleverSiri(ImplicationController implicationController, Defuzyfier defuzyfier, Fuzzyfier<Float> fuzzyfier) {
        this.implicationController = implicationController;
        this.defuzyfier = defuzyfier;
        this.fuzzyfier = fuzzyfier;
    }

    @Override
    public float estimateNeededFuel(SiriInputData inputData) throws LinguisticVariableNotFoundException {

        implicationController.setFuzzyVariables(fuzifyVariables(inputData));

        return defuzyfier.getFuelAmmountToTank();
    }

    protected ArrayList<FuzzyVariable> fuzifyVariables(SiriInputData inputData) throws LinguisticVariableNotFoundException {
        ArrayList<FuzzyVariable> fuzzyVariables = new ArrayList<>();

        fuzzyVariables.add(fuzzyfier.FuzzyfyVariable(inputData.fuelPriceOnCurrentStation, "fuelPriceOnCurrentStation"));
        fuzzyVariables.add(fuzzyfier.FuzzyfyVariable((float) inputData.petrolStationsInRange, "petrolStationsInRange"));
        fuzzyVariables.add(fuzzyfier.FuzzyfyVariable((float) inputData.distanceToNextPetrolStation, "distanceToNextPetrolStation"));
        fuzzyVariables.add(fuzzyfier.FuzzyfyVariable((float) inputData.distanceToJourneyEnd, "distanceToJourneyEnd"));

        return fuzzyVariables;
    }
}
