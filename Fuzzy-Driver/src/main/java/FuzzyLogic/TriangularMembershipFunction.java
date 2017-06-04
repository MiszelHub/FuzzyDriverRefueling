package FuzzyLogic;

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
    }

    @Override
    public float calculateDegreeOfTruth(float x) {
        if (x <= a) {
            return 0;
        } else if (( a <= x ) && ( x <= b )){
            return ((x-a)/(b-a));
        }else if(( b <= x ) && ( x <= c )){
            return ((c-x)/(c-b));
        }else{
            return 0;
        }

    }
}
