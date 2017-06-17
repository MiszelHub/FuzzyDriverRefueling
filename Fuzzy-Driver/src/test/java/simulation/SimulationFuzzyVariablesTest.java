package simulation;

import FuzzyLogic.RuleSet.RuleSet;
import app.XMLLinguisticVariablesParser;
import app.XmlFileParser;
import app.XmlRuleSetParser;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import simulation.data.LinguisticVariables;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by user on 17.06.2017.
 */
public class SimulationFuzzyVariablesTest {
    private LinguisticVariables linguisticVariables;
    private XmlFileParser<LinguisticVariables> parser;

    @Before
    public void setUp() throws Exception {
        parser = new XMLLinguisticVariablesParser();
    }

    @Test
    @Ignore
    public void loadVariablesFromXML() throws Exception {
        LinguisticVariables linguisticVariables = parser.readFile("C:\\Users\\user\\Desktop\\Repozytoria\\FuzzyDriverRefueling\\Fuzzy-Driver\\src\\main\\resources\\LinguisticVariablesTriangularMembershipFunction.xml");

        assertThat(linguisticVariables)
                .isNotNull();
        assertThat(linguisticVariables.variables)
                .isNotEmpty()
                .hasSize(4);

        System.out.println(linguisticVariables.toString());
    }

    @Test
    @Ignore
    public void loadVariablesFormXMLTrapezoidal() throws Exception {
        LinguisticVariables linguisticVariables = parser.readFile("C:\\Users\\user\\Desktop\\Repozytoria\\FuzzyDriverRefueling\\Fuzzy-Driver\\src\\main\\resources\\LinguisticVariablesTrapezoidalMembershipFunction.xml");

        assertThat(linguisticVariables)
                .isNotNull();
        assertThat(linguisticVariables.variables)
                .isNotEmpty()
                .hasSize(4);

        System.out.println(linguisticVariables.toString());
    }
}
