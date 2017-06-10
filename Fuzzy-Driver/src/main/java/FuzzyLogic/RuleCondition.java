package FuzzyLogic;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

/**
 * Created by user on 10.06.2017.
 */

public class RuleCondition {
    @XmlAttribute(name = "variable")
    private String variable;
    @XmlValue
    private String value;

    @Override
    public String toString() {
        return "RuleCondition{" +
                "variable='" + variable + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
