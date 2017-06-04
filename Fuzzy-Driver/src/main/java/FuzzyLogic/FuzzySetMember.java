package FuzzyLogic;

/**
 * Created by user on 04.06.2017.
 */
public class FuzzySetMember {
    private FuzzySetName name;
    private float degreeOfMembership;

    public FuzzySetMember(FuzzySetName name, float degreeOfMembership) {
        this.name = name;
        this.degreeOfMembership = degreeOfMembership;
    }

    @Override
    public String toString() {
        return "FuzzySetMember{" +
                "name=" + name +
                ", degreeOfMembership=" + degreeOfMembership +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FuzzySetMember that = (FuzzySetMember) o;

        if (Float.compare(that.degreeOfMembership, degreeOfMembership) != 0) return false;
        return name == that.name;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + ( degreeOfMembership != +0.0f ? Float.floatToIntBits(degreeOfMembership) : 0 );
        return result;
    }
}
