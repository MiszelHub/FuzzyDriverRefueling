package app;

import FuzzyLogic.fuzzySet.FuzzySet;
import simulation.data.Variable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 17.06.2017.
 */
public interface Mapper<T> {
    ArrayList<T> map();

     List<FuzzySet> mapFuzzySets(Variable variable);
}
