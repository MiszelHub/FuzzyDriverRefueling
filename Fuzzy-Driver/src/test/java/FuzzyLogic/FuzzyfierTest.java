package FuzzyLogic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 04.06.2017.
 */
public class FuzzyfierTest {

    private Fuzzyfier<Float> fuzzyfier;
    private List<MembershipFunction> membershipFunctions;
    private List<FuzzySet> fuzzySets;
    private final static float PRICE = 7.5f;


    @Test
    public void fuzzyfyPriceWithTriangularMembershipFunction() throws Exception {

        fuzzySets = new ArrayList<>();
        fuzzySets.add(new FuzzySet(FuzzySetName.Low, new TriangularMembershipFunction(2,6,8)));
        fuzzySets.add(new FuzzySet(FuzzySetName.Middle, new TriangularMembershipFunction(7,11,13)));
        fuzzySets.add(new FuzzySet(FuzzySetName.High, new TriangularMembershipFunction(12,16,18)));

        fuzzyfier = new Fuzzyfier<>(fuzzySets);

        List<FuzzySetMember> fuzzySetMembers = fuzzyfier.FuzzyfyVariable(PRICE);

        fuzzySetMembers.forEach(fuzzySetMember -> System.out.println(fuzzySetMember.toString()));


    }
}
