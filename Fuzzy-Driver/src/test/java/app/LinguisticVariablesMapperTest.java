package app;

import FuzzyLogic.LinguisticVariable;
import FuzzyLogic.fuzzySet.FuzzySet;
import FuzzyLogic.membershipFunctions.TrapezoidalMembershipFunction;
import FuzzyLogic.membershipFunctions.TriangularMembershipFunction;
import org.junit.Before;
import org.junit.Test;
import simulation.data.FuzzySetBoundaries;
import simulation.data.LinguisticVariables;
import simulation.data.Variable;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by user on 17.06.2017.
 */
public class LinguisticVariablesMapperTest {
    private LinguisticVariables linguisticVariables;

    @Before
    public void setUp() throws Exception {
        linguisticVariables = new LinguisticVariables();

        ArrayList<FuzzySetBoundaries> fuzzySetBoundaries = new ArrayList<>();
        fuzzySetBoundaries.add(new FuzzySetBoundaries("Low", 1, 2, 3, 4));
        fuzzySetBoundaries.add(new FuzzySetBoundaries("Middle", 3, 4, 5, 6));
        fuzzySetBoundaries.add(new FuzzySetBoundaries("High", 5, 6, 7, 8));

        ArrayList<Variable> variables = new ArrayList<>();

        variables.add(new Variable("FuelLevel", fuzzySetBoundaries));

        linguisticVariables.variables = variables;
    }

    @Test
    public void mapLinguisticVariablesWithTraingularMembershipFunction() throws Exception {
        final LinguisticVariablesTriangularMapper mapper = new LinguisticVariablesTriangularMapper(linguisticVariables);

        List<LinguisticVariable> mappedVariables = mapper.map();

        List<FuzzySet> fuzzySets = new ArrayList<>();
        fuzzySets.add(new FuzzySet("Low",new TriangularMembershipFunction(1,2,3)));
        fuzzySets.add(new FuzzySet("Middle",new TriangularMembershipFunction(3,4,5)));
        fuzzySets.add(new FuzzySet("High",new TriangularMembershipFunction(5,6,7)));

        assertThat(mappedVariables)
                .isNotEmpty()
                .hasSize(1)
                .contains(new LinguisticVariable("FuelLevel",fuzzySets));
    }
    @Test
    public void mapLinguisticVariablesWithTrapezoidalMembershipFunction() throws Exception {
        final LinguisticVariablesTrapezoidalMaper mapper = new LinguisticVariablesTrapezoidalMaper(linguisticVariables);

        List<LinguisticVariable> mappedVariables = mapper.map();

        List<FuzzySet> fuzzySets = new ArrayList<>();
        fuzzySets.add(new FuzzySet("Low",new TrapezoidalMembershipFunction(1,2,3,4)));
        fuzzySets.add(new FuzzySet("Middle",new TrapezoidalMembershipFunction(3,4,5,6)));
        fuzzySets.add(new FuzzySet("High",new TrapezoidalMembershipFunction(5,6,7,8)));

        assertThat(mappedVariables)
                .isNotEmpty()
                .hasSize(1)
                .contains(new LinguisticVariable("FuelLevel",fuzzySets));
    }
}
