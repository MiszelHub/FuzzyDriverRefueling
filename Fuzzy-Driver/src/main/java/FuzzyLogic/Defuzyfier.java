package FuzzyLogic;

import FuzzyLogic.RuleSet.RuleResult;
import FuzzyLogic.fuzzySet.FuzzySet;


import java.util.List;

/**
 * Created by user on 11.06.2017.
 */
public class Defuzyfier {
    private ImplicationController implicationController;
    private LinguisticVariable linguisticVariable;

    public Defuzyfier(ImplicationController implicationController, LinguisticVariable linguisticVariable) {
        this.implicationController = implicationController;
        this.linguisticVariable = linguisticVariable;
    }

    public float getFuelAmmountToTank() {
        List<RuleResult> ruleResults = implicationController.evaluateRules();
        float sumOfRuleWeightAndCharacteristicValueProduct = 0f;
        float sumOfWeights = 0f;
        for (RuleResult ruleResult : ruleResults) {
            sumOfRuleWeightAndCharacteristicValueProduct += ruleResult.getWeight() * getCharacteristicValueForTheSet(ruleResult.getValue());
            sumOfWeights += ruleResult.getWeight();
        }

        return sumOfRuleWeightAndCharacteristicValueProduct/sumOfWeights;

    }

    private float getCharacteristicValueForTheSet(String setName) {
        return linguisticVariable.getFuzzySets().stream()
                .filter(fuzzySet -> fuzzySet.getFuzzySetName().equals(setName))
                .findFirst()
                .map(FuzzySet::getCharacteristicValue)
                .get();
    }
}
