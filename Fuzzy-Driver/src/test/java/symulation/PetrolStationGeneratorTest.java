package symulation;

import org.junit.Before;
import org.junit.Test;
import symulation.data.Road;

import static org.assertj.core.api.Assertions.assertThat;

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
                .doesNotHaveDuplicates();

        System.out.println(road.getPetrolStations().toString());
    }
}
