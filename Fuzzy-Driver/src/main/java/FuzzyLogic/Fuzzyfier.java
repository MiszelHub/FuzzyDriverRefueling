package FuzzyLogic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 04.06.2017.
 */
public class Fuzzyfier<T extends Number> {
   private List<FuzzySet> fuzzySets;

    public Fuzzyfier(List<FuzzySet> membershipFunction) {
        this.fuzzySets = membershipFunction;
    }

    public LinguisticVariable FuzzyfyVariable(T variableValue, String variableName){

        List<FuzzySetMember> list = new ArrayList<>();

        for (FuzzySet fuzzySet : fuzzySets){
          list.add(new FuzzySetMember(fuzzySet.getFuzzySetName(),fuzzySet.getDegreeOfMembership(variableValue)));
        }

        return new LinguisticVariable(variableName,list);
    }


}
