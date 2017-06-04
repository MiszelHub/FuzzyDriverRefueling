package FuzzyLogic;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by user on 04.06.2017.
 */
public class MembershipFunctionTest {
    private MembershipFunction membershipFunction;

    @Test
    public void triangularFunction() throws Exception {
        membershipFunction = new TriangularMembershipFunction(2,6,8);

        Stream<Integer> integerStream = Stream.of(0, 1, 2, 3, 5, 6, 7, 8);

        List<Float> resultList = integerStream
                .map(x -> membershipFunction.calculateDegreeOfTruth(x))
                .collect(Collectors.toList());

        assertThat(resultList)
                .isNotEmpty()
                .containsSequence(0f, 0f, 0f, 0.25f, 0.75f, 1f, 0.5f, 0f);
    }

    @Test
    public void trapezoidalFunction() throws Exception {
        membershipFunction = new TrapezoidalMembershipFunction(1,5,7,8);

        Stream<Integer> integerStream = Stream.of(0, 1, 2, 3, 5, 6, 7, 8,9,10);

        List<Float> resultList = integerStream
                .map(x -> membershipFunction.calculateDegreeOfTruth(x))
                .collect(Collectors.toList());

        assertThat(resultList)
                .isNotEmpty()
                .containsSequence(0f, 0f, 0.25f, 0.5f, 1f, 1f, 1f,0f,0f,0f);
    }
}
