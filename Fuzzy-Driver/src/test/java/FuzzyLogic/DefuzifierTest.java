package FuzzyLogic;

import FuzzyLogic.RuleSet.RuleResult;
import FuzzyLogic.fuzzySet.FuzzySet;
import FuzzyLogic.membershipFunctions.TrapezoidalMembershipFunction;
import FuzzyLogic.membershipFunctions.TriangularMembershipFunction;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by user on 12.06.2017.
 */
public class DefuzifierTest {
    private Defuzyfier defuzyfier;
    private ImplicationController implicationController;
    private LinguisticVariable linguisticVariable;
    private List<FuzzySet> fuzzySets;

    @Before
    public void setUp() throws Exception {
        implicationController = mock(ImplicationController.class);
        List<RuleResult> ruleResults = new ArrayList<>();
        ruleResults.add(new RuleResult("FuelToTank", "Low", 0.2f));
        ruleResults.add(new RuleResult("FuelToTank", "Medium", 0.5f));

        when(implicationController.evaluateRules()).thenReturn(ruleResults);

        fuzzySets = new ArrayList<>();
        linguisticVariable = new LinguisticVariable("FuelToTank", fuzzySets);
        defuzyfier = new Defuzyfier(implicationController, linguisticVariable);
    }


    @Test
    public void CalculateNeededFuelTriangular() throws Exception {
        fuzzySets.add(new FuzzySet("Low", new TriangularMembershipFunction(2, 10, 15)));
        fuzzySets.add(new FuzzySet("Medium", new TriangularMembershipFunction(13, 19, 23)));
        fuzzySets.add(new FuzzySet("High", new TriangularMembershipFunction(20, 25, 29)));

        float fuelAmmountToTank = defuzyfier.getFuelAmmountToTank();

        final float EXPECTED_AMOUNT = 16.428572f;

        assertThat(fuelAmmountToTank).isEqualTo(EXPECTED_AMOUNT);
    }

    @Test
    public void CalculateNeededFuelTrapezoidal() throws Exception {
        fuzzySets.add(new FuzzySet("Low", new TrapezoidalMembershipFunction(5, 10, 15, 20)));
        fuzzySets.add(new FuzzySet("Medium", new TrapezoidalMembershipFunction(18, 23, 28, 33)));
        fuzzySets.add(new FuzzySet("High", new TrapezoidalMembershipFunction(31, 36, 41, 46)));


        float fuelAmmountToTank = defuzyfier.getFuelAmmountToTank();

        final float EXPECTED_AMOUNT = 21.785715f;

        assertThat(fuelAmmountToTank).isEqualTo(EXPECTED_AMOUNT);
    }
}
