package FuzzyLogic.RuleSet;


import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;


public class RuleResult {

    @XmlAttribute(name = "variable")
    private String variable;
    @XmlValue
    private String value;
    @XmlAttribute(name = "weight")
    private float weight;

    public RuleResult() {
    }

    public RuleResult(String variable, String value) {
        this.variable = variable;
        this.value = value;
    }

    public RuleResult(String variable, String value, float weight) {
        this.variable = variable;
        this.value = value;
        this.weight = weight;
    }

    public String getVariable() {
        return variable;
    }

    public String getValue() {
        return value;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "RuleResult{" +
                "variable='" + variable + '\'' +
                ", value='" + value + '\'' +
                ", weight=" + weight +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RuleResult that = (RuleResult) o;

        if (Float.compare(that.weight, weight) != 0) return false;
        if (!variable.equals(that.variable)) return false;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        int result = variable.hashCode();
        result = 31 * result + value.hashCode();
        result = 31 * result + ( weight != +0.0f ? Float.floatToIntBits(weight) : 0 );
        return result;
    }
}
