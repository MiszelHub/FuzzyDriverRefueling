package FuzzyLogic.RuleSet;



import FuzzyLogic.fuzzySet.FuzzySetMember;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.transform.Result;
import java.util.ArrayList;

/**
 * Created by user on 10.06.2017.
 */

public class Rule {

    @XmlElement(name = "RuleCondition")
    private ArrayList<RuleCondition> ruleConditions;

    @XmlElement(name = "Result")
    private RuleResult result;

    public Rule() {
    }

    public Rule(ArrayList<RuleCondition> ruleConditions, RuleResult result) {
        this.ruleConditions = ruleConditions;
        this.result = result;
    }

    public boolean isRuleConditionFulfilled(String fuzzySetName){
       return ruleConditions
               .stream()
               .map(RuleCondition::getValue)
               .anyMatch(s -> s.equals(fuzzySetName));
    }

    public ArrayList<RuleCondition> getRuleConditions() {
        return ruleConditions;
    }

    public RuleResult getResult() {
        return result;
    }

    @Override
    public String toString() {
        return "Rule{" +
                "ruleConditions=" + ruleConditions +
                ", result=" + result +
                '}';
    }
}
