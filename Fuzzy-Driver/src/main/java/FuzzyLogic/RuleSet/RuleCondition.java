package FuzzyLogic.RuleSet;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlValue;

/**
 * Created by user on 10.06.2017.
 */

public class RuleCondition {
    @XmlAttribute(name = "variable")
    private String variable;
    @XmlValue
    private String value;

    public RuleCondition() {
    }

    public RuleCondition(String variable, String value) {
        this.variable = variable;
        this.value = value;
    }

    @XmlTransient
    public String getVariable() {
        return variable;
    }

    public void setVariable(String variable) {
        this.variable = variable;
    }

    @XmlTransient
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "RuleCondition{" +
                "variable='" + variable + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
