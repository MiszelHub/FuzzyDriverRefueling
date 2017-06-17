package simulation;

import org.junit.Test;
import simulation.generators.RandomFloatGenerator;
import simulation.generators.RandomIntegerGenerator;
import simulation.generators.RandomNumberGenerator;

import static org.assertj.core.api.Assertions.assertThat;
/**
 * Created by user on 03.06.2017.
 */
public class NumberGeneratorTest {

    private RandomNumberGenerator generator;



    @Test
    public void GenerateIntNumberFromRange() throws Exception {
        generator = new RandomIntegerGenerator();
        int tmp = (int) generator.generateNumberFromRange(50,200);
        System.out.println(tmp);
        assertThat(tmp).isBetween(50,200);
    }

    @Test
    public void generateFloat() throws Exception {
        generator = new RandomFloatGenerator();
        float tmp = (float) generator.generateNumberFromRange(3.5f,4f);
        System.out.println(tmp);
        assertThat(tmp).isBetween(3.5f,4f);
    }
}
