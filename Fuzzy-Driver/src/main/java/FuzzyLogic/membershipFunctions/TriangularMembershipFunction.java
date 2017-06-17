package FuzzyLogic.membershipFunctions;

/**
 * Created by user on 04.06.2017.
 */
public class TriangularMembershipFunction implements MembershipFunction {

    private float a;
    private float b;
    private float c;

    public TriangularMembershipFunction(float a, float b, float c) {
        this.a = a;
        this.b = b;
        this.c = c;
        validateParameters();
    }

    private void validateParameters() {
        if (!( ( a < b ) && ( b < c ) )) {
            throw new IllegalArgumentException("arguments should be as follow a<b, b<c");
        }
    }

    @Override
    public float calculateDegreeOfTruth(Number x) {
        if (x.floatValue() <= a) {
            return 0;
        } else if (( a <= x.floatValue() ) && ( x.floatValue() <= b )) {
            return ( ( x.floatValue() - a ) / ( b - a ) );
        } else if (( b <= x.floatValue()) && ( x.floatValue() <= c )) {
            return ( ( c - x.floatValue() ) / ( c - b ) );
        } else {
            return 0;
        }

    }

    @Override
    public float getCharacteristicValue() {
        return b;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TriangularMembershipFunction that = (TriangularMembershipFunction) o;

        if (Float.compare(that.a, a) != 0) return false;
        if (Float.compare(that.b, b) != 0) return false;
        return Float.compare(that.c, c) == 0;
    }

    @Override
    public int hashCode() {
        int result = ( a != +0.0f ? Float.floatToIntBits(a) : 0 );
        result = 31 * result + ( b != +0.0f ? Float.floatToIntBits(b) : 0 );
        result = 31 * result + ( c != +0.0f ? Float.floatToIntBits(c) : 0 );
        return result;
    }

    @Override
    public String toString() {
        return "TriangularMembershipFunction{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }
}
