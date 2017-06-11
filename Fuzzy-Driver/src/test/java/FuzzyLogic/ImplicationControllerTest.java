package FuzzyLogic;

import FuzzyLogic.RuleSet.Rule;
import FuzzyLogic.RuleSet.RuleCondition;
import FuzzyLogic.RuleSet.RuleResult;
import FuzzyLogic.RuleSet.RuleSet;
import FuzzyLogic.fuzzySet.FuzzySetMember;
import app.XmlRuleSetParser;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by user on 10.06.2017.
 */
public class ImplicationControllerTest {
    private ImplicationController implicationController;
    private XmlRuleSetParser xmlRuleSetParser;

    @Before
    public void setUp() throws Exception {
        xmlRuleSetParser = mock(XmlRuleSetParser.class);
        implicationController = new ImplicationController(xmlRuleSetParser,"testPath");
    }

    @Test
    public void IsRuleFulfiled() throws Exception {
        ArrayList<RuleCondition> ruleConditions = new ArrayList<>();
        ruleConditions.add(new RuleCondition("FuelLevel","Low"));
        ruleConditions.add(new RuleCondition("Distance","Medium"));

        Rule rule = new Rule(ruleConditions,new RuleResult("FuelToTank","A Lot",1));

        FuzzySetMember fuzzySetMember1 = new FuzzySetMember("Low", 0.2f);
        FuzzySetMember fuzzySetMember2 = new FuzzySetMember("Medium", 0.5f);
        FuzzySetMember fuzzySetMember3 = new FuzzySetMember("High", 1);

        FuzzyVariable fuzzyVariable = new FuzzyVariable("FuelLevel", new ArrayList<FuzzySetMember>(Arrays.asList(fuzzySetMember1, fuzzySetMember2, fuzzySetMember3)));
        FuzzyVariable fuzzyVariable1 = new FuzzyVariable("Distance", new ArrayList<FuzzySetMember>(Arrays.asList(fuzzySetMember1, fuzzySetMember2, fuzzySetMember3)));

        ArrayList<FuzzyVariable> fuzzyVariables = new ArrayList<>();
        fuzzyVariables.add(fuzzyVariable);
        fuzzyVariables.add(fuzzyVariable1);

        Optional<RuleResult> ruleResult = implicationController.eveluateRule(rule, fuzzyVariables);

        assertThat(ruleResult)
                .isNotEmpty()
                .contains(new RuleResult("FuelToTank","A Lot",1f*0.2f*0.5f));
    }

    @Test
    public void findVariablesForTheRule() throws Exception {
        ArrayList<RuleCondition> ruleConditions = new ArrayList<>();
        ruleConditions.add(new RuleCondition("FuelLevel","Low"));
        ruleConditions.add(new RuleCondition("Distance","Medium"));
        Rule rule = new Rule(ruleConditions,new RuleResult("FuelToTank","A Lot",1));

        FuzzySetMember fuzzySetMember1 = new FuzzySetMember("Low", 0.2f);
        FuzzySetMember fuzzySetMember2 = new FuzzySetMember("Medium", 0.5f);
        FuzzySetMember fuzzySetMember3 = new FuzzySetMember("High", 1);

        FuzzyVariable fuzzyVariable = new FuzzyVariable("FuelLevel", new ArrayList<FuzzySetMember>(Arrays.asList(fuzzySetMember1, fuzzySetMember2, fuzzySetMember3)));
        FuzzyVariable fuzzyVariable1 = new FuzzyVariable("Distance", new ArrayList<FuzzySetMember>(Arrays.asList(fuzzySetMember1, fuzzySetMember2, fuzzySetMember3)));
        FuzzyVariable fuzzyVariable2 = new FuzzyVariable("WRONG Variable Name", new ArrayList<FuzzySetMember>(Arrays.asList(fuzzySetMember1, fuzzySetMember2, fuzzySetMember3)));

        implicationController.addFuzzyVariable(fuzzyVariable);
        implicationController.addFuzzyVariable(fuzzyVariable1);
        implicationController.addFuzzyVariable(fuzzyVariable2);

        List<FuzzyVariable> variablesForEvaluatingTheRule = implicationController.findVariablesForEvaluatingTheRule(rule);

        assertThat(variablesForEvaluatingTheRule)
                .containsSequence(fuzzyVariable,fuzzyVariable1);
    }

    @Test
    public void evaluateRules() throws Exception {
        ArrayList<RuleCondition> ruleConditions = new ArrayList<>();
        ruleConditions.add(new RuleCondition("FuelLevel","Low"));
        ruleConditions.add(new RuleCondition("Distance","Medium"));
        Rule rule = new Rule(ruleConditions,new RuleResult("FuelToTank","A Lot",1));

        ArrayList<RuleCondition> ruleConditions1 = new ArrayList<>();
        ruleConditions.add(new RuleCondition("MinLevel","Low"));
        ruleConditions.add(new RuleCondition("MaxDistance","Medium"));
        Rule rule1 = new Rule(ruleConditions1,new RuleResult("FuelToTank","A Lot",1));
        RuleSet ruleSet = new RuleSet();
        ruleSet.addRule(rule1);
        ruleSet.addRule(rule);

        FuzzySetMember fuzzySetMember1 = new FuzzySetMember("Low", 0.2f);
        FuzzySetMember fuzzySetMember2 = new FuzzySetMember("Medium", 0.5f);
        FuzzySetMember fuzzySetMember3 = new FuzzySetMember("High", 1);

        FuzzyVariable fuzzyVariable = new FuzzyVariable("FuelLevel", new ArrayList<FuzzySetMember>(Arrays.asList(fuzzySetMember1, fuzzySetMember2, fuzzySetMember3)));
        FuzzyVariable fuzzyVariable1 = new FuzzyVariable("Distance", new ArrayList<FuzzySetMember>(Arrays.asList(fuzzySetMember1, fuzzySetMember2, fuzzySetMember3)));
        FuzzyVariable fuzzyVariable2 = new FuzzyVariable("WRONG Variable Name", new ArrayList<FuzzySetMember>(Arrays.asList(fuzzySetMember1, fuzzySetMember2, fuzzySetMember3)));

        implicationController.addFuzzyVariable(fuzzyVariable);
        implicationController.addFuzzyVariable(fuzzyVariable1);
        implicationController.addFuzzyVariable(fuzzyVariable2);

        //when(xmlRuleSetParser.readFile("testPath")).thenReturn(ruleSet);
        implicationController.setRuleSet(ruleSet);

        List<RuleResult> ruleResults = implicationController.evaluateRules();

        assertThat(ruleResults)
                .hasSize(1)
                .contains(new RuleResult("FuelToTank","A Lot",1f*0.2f*0.5f));
    }
}
