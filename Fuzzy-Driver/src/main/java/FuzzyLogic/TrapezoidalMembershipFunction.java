package FuzzyLogic;


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
    public float calculateDegreeOfTruth(float x) {
        if (x <= a) {
            return 0;
        } else if (( a <= x ) && ( x <= b )) {
            return ( ( x - a ) / ( b - a ) );
        } else if (( b <= x ) && ( x <= c )) {
            return 1;
        } else if (( c <= x ) && ( x <= d )) {
            return ( ( d - x ) / ( d - c ) );
        } else {
            return 0;
        }


    }
}
