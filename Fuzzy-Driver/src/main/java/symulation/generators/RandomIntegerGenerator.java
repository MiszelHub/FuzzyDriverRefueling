package symulation.generators;

import java.util.Random;

/**
 * Created by user on 03.06.2017.
 */
public class RandomIntegerGenerator implements RandomNumberGenerator<Integer> {

    public Integer generateNumberFromRange(Integer min, Integer max) {
        Random random = new Random();
        return random.ints(min,max).iterator().nextInt();
    }
}
