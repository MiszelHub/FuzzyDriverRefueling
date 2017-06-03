package symulation;

import org.junit.Before;
import org.junit.Test;
import symulation.data.Road;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.groups.Tuple.tuple;

/**
 * Created by user on 03.06.2017.
 */
public class PetrolStationGeneratorTest {
    private PetrolStationGenerator generator;
    private Road road;

    @Before
    public void setUp() throws Exception {
        road = new Road(2000);
        generator = new PetrolStationGenerator(road);
    }

    @Test
    public void generateStationsForTheRoad() throws Exception {
        generator.generateStationsOnTheRoad();

        assertThat(road.getPetrolStations())
                .isNotEmpty()
                .doesNotContainNull()
                .doesNotHaveDuplicates()
                .extracting("petrolPrice")
                .allMatch((x -> (Float)x < 4f))
                .allMatch(x -> (Float)x > 3.5f);


        System.out.println(road.getPetrolStations().toString());
    }
}
