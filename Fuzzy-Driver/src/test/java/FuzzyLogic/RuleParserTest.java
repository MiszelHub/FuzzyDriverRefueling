package FuzzyLogic;

import FuzzyLogic.RuleSet.RuleSet;
import app.XmlRuleSetParser;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by user on 10.06.2017.
 */
public class RuleParserTest {
    private XmlRuleSetParser parser;

    @Before
    public void setUp() throws Exception {
        parser = new XmlRuleSetParser();
    }

    @Test
    public void ReadRuleSetFromFile() throws Exception {
        RuleSet ruleSet = parser.readFile("C:\\Users\\user\\Desktop\\Repozytoria\\FuzzyDriverRefueling\\Fuzzy-Driver\\src\\main\\resources\\RuleSet.xml");

        assertThat(ruleSet)
                .isNotNull();
        assertThat(ruleSet.getRules())
                .isNotEmpty()
                .hasSize(2);

        System.out.println(ruleSet.toString());

    }
}
