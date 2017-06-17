package simulation.generators;

import java.util.Random;

/**
 * Created by user on 03.06.2017.
 */
public class RandomFloatGenerator implements RandomNumberGenerator<Float> {
    @Override
    public Float generateNumberFromRange(Float min, Float max) {
        Random random = new Random();

        Double result = random.doubles(min,max).iterator().nextDouble();

        return result.floatValue();
    }
}
