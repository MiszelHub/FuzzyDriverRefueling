package simulation.data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

/**
 * Created by user on 17.06.2017.
 */
@XmlRootElement(name = "LingusiticVariables")
public class LinguisticVariables {

    @XmlElement(name = "variable")
    public ArrayList<Variable> variables;

    @Override
    public String toString() {
        return "LinguisticVariables{" +
                "variables=" + variables +
                '}';
    }
}
