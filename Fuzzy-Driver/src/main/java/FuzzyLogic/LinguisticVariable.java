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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LinguisticVariable that = (LinguisticVariable) o;

        if (!name.equals(that.name)) return false;
        return fuzzySets.equals(that.fuzzySets);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + fuzzySets.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "LinguisticVariable{" +
                "name='" + name + '\'' +
                ", fuzzySets=" + fuzzySets +
                '}';
    }
}
