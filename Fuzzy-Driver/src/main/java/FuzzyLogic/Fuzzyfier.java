package FuzzyLogic;

import FuzzyLogic.fuzzySet.FuzzySet;
import FuzzyLogic.fuzzySet.FuzzySetMember;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 04.06.2017.
 */
public class Fuzzyfier<T extends Number> {
    private List<LinguisticVariable> linguisticVariables;

    public Fuzzyfier(List<LinguisticVariable> linguisticVariables) {
        this.linguisticVariables = linguisticVariables;
    }

    public FuzzyVariable FuzzyfyVariable(T variableValue, String variableName) throws LinguisticVariableNotFoundException {

        List<FuzzySetMember> list = new ArrayList<>();

        LinguisticVariable linguisticVariable = findLinguisticVariableCorespondingToTheName(variableName);

        for (FuzzySet fuzzySet : linguisticVariable.getFuzzySets()) {
            list.add(new FuzzySetMember(fuzzySet.getFuzzySetName(), fuzzySet.getDegreeOfMembership(variableValue)));
        }

        return new FuzzyVariable(variableName, list);
    }

    private LinguisticVariable findLinguisticVariableCorespondingToTheName(String variableName) throws LinguisticVariableNotFoundException {
        return linguisticVariables
                .stream()
                .filter(linguisticVariable -> linguisticVariable.getName().equals(variableName))
                .findFirst()
                .orElseThrow(LinguisticVariableNotFoundException::new);
    }


}
