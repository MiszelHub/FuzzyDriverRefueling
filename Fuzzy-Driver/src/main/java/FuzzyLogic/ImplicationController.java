package FuzzyLogic;

import FuzzyLogic.RuleSet.Rule;
import FuzzyLogic.RuleSet.RuleCondition;
import FuzzyLogic.RuleSet.RuleResult;
import FuzzyLogic.RuleSet.RuleSet;
import FuzzyLogic.fuzzySet.FuzzySetMember;
import app.XmlFileParser;

import javax.xml.bind.JAXBException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by user on 10.06.2017.
 */
public class ImplicationController {
    private XmlFileParser<RuleSet> parser;
    private RuleSet ruleSet;

    List<FuzzyVariable> fuzzyVariables;

    public ImplicationController(XmlFileParser<RuleSet> parser, String ruleSetFilePath) throws JAXBException {
        this.parser = parser;
        ruleSet = parser.readFile(ruleSetFilePath);

        fuzzyVariables = new ArrayList<>();
    }

    public void AddFuzzyVariable(FuzzyVariable fuzzyVariable) {
        fuzzyVariables.add(fuzzyVariable);
    }

    public List<RuleResult> evaluateRules() {

        return ruleSet.getRules()
                .stream()
                .map(rule -> eveluateRule(rule, findVariablesForEvaluatingTheRule(rule)))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());

    }

    private Optional<RuleResult> eveluateRule(Rule rule, List<FuzzyVariable> fuzzyVariables) {

        int fulfiledConditions = 0;
        for (FuzzyVariable fuzzyVariable : fuzzyVariables) {
            RuleCondition conditionMatchingVariable = findConditionMatchingVariable(rule, fuzzyVariable);
            if (isConditionFulfiled(conditionMatchingVariable, fuzzyVariable)) {
                fulfiledConditions++;
            }
            if(fulfiledConditions == 2){
                return Optional.of(rule.getResult());
            }
        }

        return Optional.empty();


    }

    private boolean isConditionFulfiled(RuleCondition ruleCondition, FuzzyVariable fuzzyVariable) {
        return fuzzyVariable.getFuzzySetMembers().stream().anyMatch(fuzzySetMember -> fuzzySetMember.getName().equals(ruleCondition.getValue()));
    }

    private RuleCondition findConditionMatchingVariable(Rule rule, FuzzyVariable variable) {
        return rule.getRuleConditions().stream().filter(ruleCondition -> ruleCondition.getVariable().equals(variable.getVariableName())).findFirst().orElseGet(null);
    }

    private List<FuzzyVariable> findVariablesForEvaluatingTheRule(Rule rule) {

        return fuzzyVariables
                .stream()
                .filter(fuzzyVariable -> ruleContainsConditionForVariable(rule, fuzzyVariable))
                .collect(Collectors.toList());


    }

    private boolean ruleContainsConditionForVariable(Rule rule, FuzzyVariable variable) {
        return rule.getRuleConditions()
                .stream()
                .map(RuleCondition::getVariable)
                .anyMatch(s -> s.equals(variable.getVariableName()));
    }

    // 1.wez  Rula
    // 2.Wez Jego Rule Conditions
    // 3.Weź FuzzyVariables Odpowiadające jego RuleCondition.variable
    // 4.Sprawdź czy spełniają regułe
    protected Optional<RuleResult> evaluateRule(Rule rule, FuzzyVariable fuzzyVariable) {
        List<FuzzySetMember> fuzzySetMembers = fuzzyVariable.getFuzzySetMembers()
                .stream()
                .filter(fuzzySetMember -> fuzzySetMember.getDegreeOfMembership() != 0)
                .collect(Collectors.toList());
        boolean isRuleFulfiled = fuzzySetMembers
                .stream()
                .map(FuzzySetMember::getName)
                .allMatch(rule::isRuleConditionFulfilled);

        if (isRuleFulfiled) {
            return Optional.of(rule.getResult());
        } else {
            return Optional.empty();
        }


    }
}