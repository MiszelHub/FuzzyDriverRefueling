package simulation.data;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;

/**
 * Created by user on 17.06.2017.
 */
public class Variable {
    @XmlAttribute(name = "name")
    public String name;
    @XmlElement(name = "FuzzySetBoundaries")
    public ArrayList<FuzzySetBoundaries> fuzzySetBoundaries;

    public Variable() {
    }

    public Variable(String name, ArrayList<FuzzySetBoundaries> fuzzySetBoundaries) {
        this.name = name;
        this.fuzzySetBoundaries = fuzzySetBoundaries;
    }

    @Override
    public String toString() {
        return "Variable{" +
                "name='" + name + '\'' +
                ", fuzzySetBoundaries=" + fuzzySetBoundaries +
                '}'+"\n";
    }
}
