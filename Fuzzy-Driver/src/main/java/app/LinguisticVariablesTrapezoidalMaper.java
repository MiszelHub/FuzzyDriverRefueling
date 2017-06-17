package app;

import FuzzyLogic.LinguisticVariable;
import FuzzyLogic.fuzzySet.FuzzySet;
import FuzzyLogic.membershipFunctions.TrapezoidalMembershipFunction;
import simulation.data.LinguisticVariables;
import simulation.data.Variable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by user on 17.06.2017.
 */
public class LinguisticVariablesTrapezoidalMaper implements Mapper<LinguisticVariable> {
    private LinguisticVariables linguisticVariables;

    public LinguisticVariablesTrapezoidalMaper(LinguisticVariables linguisticVariables) {
        this.linguisticVariables = linguisticVariables;
    }

    @Override
    public ArrayList<LinguisticVariable> map() {
        return new ArrayList<>(linguisticVariables.variables.stream()
                .map(variable -> new LinguisticVariable(variable.name, mapFuzzySets(variable)))
                .collect(Collectors.toList()));
    }

    @Override
    public List<FuzzySet> mapFuzzySets(Variable variable) {
        return variable.fuzzySetBoundaries.stream()
                .map(fuzzySetBoundary -> new FuzzySet(fuzzySetBoundary.name, new TrapezoidalMembershipFunction(fuzzySetBoundary.a, fuzzySetBoundary.b, fuzzySetBoundary.c, fuzzySetBoundary.d)))
                .collect(Collectors.toList());
    }
}
