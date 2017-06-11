package FuzzyLogic;

import FuzzyLogic.fuzzySet.FuzzySet;

import java.util.List;

/**
 * Created by user on 11.06.2017.
 */
public class LinguisticVariable {
    private final String name;
    private final List<FuzzySet> fuzzySets;

    public LinguisticVariable(String name, List<FuzzySet> fuzzySets) {
        this.name = name;
        this.fuzzySets = fuzzySets;
    }

    public final String getName() {
        return name;
    }

    public final List<FuzzySet> getFuzzySets() {
        return fuzzySets;
    }
}
