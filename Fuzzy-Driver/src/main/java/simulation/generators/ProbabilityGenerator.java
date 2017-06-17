package simulation.generators;

import java.util.Random;

/**
 * Created by user on 17.06.2017.
 */
public class ProbabilityGenerator {

    public boolean isProbable(double probabilityLevel) {
        if (probabilityLevel > 1.0) {
            throw new IllegalArgumentException("Probability Level must be from range <0.0 , 1.0>");
        }
        Random random = new Random();
        return ( random.nextDouble() <= probabilityLevel );
    }
}
