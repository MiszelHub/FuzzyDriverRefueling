package FuzzyLogic.membershipFunctions;


/**
 * Created by user on 04.06.2017.
 */
public class TrapezoidalMembershipFunction implements MembershipFunction {

    private float a;
    private float b;
    private float c;
    private float d;

    public TrapezoidalMembershipFunction(float a, float b, float c, float d) {

        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        validateParameters();
    }

    private void validateParameters() {
        if (!( ( a < b ) && ( b <= c ) && ( c < d ) )) {
            throw new IllegalArgumentException("arguments should be as follow a<b, b<=c, c<d");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TrapezoidalMembershipFunction that = (TrapezoidalMembershipFunction) o;

        if (Float.compare(that.a, a) != 0) return false;
        if (Float.compare(that.b, b) != 0) return false;
        if (Float.compare(that.c, c) != 0) return false;
        return Float.compare(that.d, d) == 0;
    }

    @Override
    public int hashCode() {
        int result = ( a != +0.0f ? Float.floatToIntBits(a) : 0 );
        result = 31 * result + ( b != +0.0f ? Float.floatToIntBits(b) : 0 );
        result = 31 * result + ( c != +0.0f ? Float.floatToIntBits(c) : 0 );
        result = 31 * result + ( d != +0.0f ? Float.floatToIntBits(d) : 0 );
        return result;
    }

    @Override
    public float calculateDegreeOfTruth(Number x) {
        if (x.floatValue() <= a) {
            return 0;
        } else if (( a <= x.floatValue() ) && ( x.floatValue() <= b )) {
            return ( ( x.floatValue() - a ) / ( b - a ) );
        } else if (( b <= x.floatValue() ) && ( x.floatValue() <= c )) {
            return 1;
        } else if (( c <= x.floatValue() ) && ( x.floatValue() <= d )) {
            return ( ( d - x.floatValue() ) / ( d - c ) );
        } else {
            return 0;
        }


    }
}
