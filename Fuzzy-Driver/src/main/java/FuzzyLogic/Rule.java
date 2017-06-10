package FuzzyLogic;



import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

/**
 * Created by user on 10.06.2017.
 */

public class Rule {

    @XmlElement(name = "RuleCondition")
    private ArrayList<RuleCondition> ruleConditions;

    @XmlElement(name = "Result")
    private RuleResult result;

    @Override
    public String toString() {
        return "Rule{" +
                "ruleConditions=" + ruleConditions +
                ", result=" + result +
                '}';
    }
}
