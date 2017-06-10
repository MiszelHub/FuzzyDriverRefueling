package FuzzyLogic;



import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashSet;

/**
 * Created by user on 10.06.2017.
 */

@XmlRootElement(name = "RuleSet")
public class RuleSet {

    @XmlElement(name = "Rule")
    private HashSet<Rule> rules;

    public RuleSet() {
        rules = new HashSet<>();
    }

    public HashSet<Rule> getRules() {
        return rules;
    }

    @Override
    public String toString() {
        return "RuleSet{" +
                "rules=" + rules +
                '}';
    }
}
