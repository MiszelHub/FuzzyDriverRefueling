package FuzzyLogic;

/**
 * Created by user on 04.06.2017.
 */
public class FuzzySet {
    private FuzzySetName fuzzySetName;
    private MembershipFunction membershipFunction;

    public FuzzySet(FuzzySetName fuzzySetName, MembershipFunction membershipFunction) {
        this.fuzzySetName = fuzzySetName;
        this.membershipFunction = membershipFunction;
    }

    public float getDegreeOfMembership(Number x) {
        return membershipFunction.calculateDegreeOfTruth(x);
    }

    public FuzzySetName getFuzzySetName() {
        return fuzzySetName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FuzzySet fuzzySet = (FuzzySet) o;

        if (fuzzySetName != fuzzySet.fuzzySetName) return false;
        return membershipFunction.equals(fuzzySet.membershipFunction);
    }

    @Override
    public int hashCode() {
        int result = fuzzySetName.hashCode();
        result = 31 * result + membershipFunction.hashCode();
        return result;
    }
}
