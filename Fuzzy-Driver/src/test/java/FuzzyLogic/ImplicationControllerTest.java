package FuzzyLogic;

import FuzzyLogic.RuleSet.Rule;
import FuzzyLogic.RuleSet.RuleCondition;
import FuzzyLogic.RuleSet.RuleResult;
import FuzzyLogic.RuleSet.RuleSet;
import FuzzyLogic.fuzzySet.FuzzySetMember;
import app.XmlFileParser;
import app.XmlRuleSetParser;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

import static org.mockito.Mockito.mock;

/**
 * Created by user on 10.06.2017.
 */
public class ImplicationControllerTest {
    private ImplicationController implicationController;

    @Before
    public void setUp() throws Exception {
        implicationController = new ImplicationController(mock(XmlRuleSetParser.class),"testPath");
    }

    @Test
    public void IsRuleFulfiled() throws Exception {
        ArrayList<RuleCondition> ruleConditions = new ArrayList<>();
        ruleConditions.add(new RuleCondition("FuelLevel","Low"));
        ruleConditions.add(new RuleCondition("Distance","Medium"));

        Rule rule = new Rule(ruleConditions,new RuleResult("FuelToTank","A Lot"));

        FuzzySetMember fuzzySetMember1 = new FuzzySetMember("Low", 0.2f);
        FuzzySetMember fuzzySetMember2 = new FuzzySetMember("Medium", 0.5f);
        FuzzySetMember fuzzySetMember3 = new FuzzySetMember("High", 1);

        FuzzyVariable fuzzyVariable = new FuzzyVariable("FuelLevel", new ArrayList<FuzzySetMember>(Arrays.asList(fuzzySetMember1, fuzzySetMember2, fuzzySetMember3)));
        implicationController.evaluateRule(rule, fuzzyVariable);
    }
}
