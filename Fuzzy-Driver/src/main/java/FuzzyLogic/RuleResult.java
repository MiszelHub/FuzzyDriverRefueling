package FuzzyLogic;


import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;


public class RuleResult {

    @XmlAttribute(name = "variable")
    private String variable;
    @XmlValue
    private String value;

    @Override
    public String toString() {
        return "RuleResult{" +
                "variable='" + variable + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
