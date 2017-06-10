package FuzzyLogic;

import FuzzyLogic.fuzzySet.FuzzySetMember;

import java.util.List;

/**
 * Created by user on 04.06.2017.
 */
public class FuzzyVariable {
    String variableName;
    private List<FuzzySetMember> fuzzySetMembers;
    public FuzzyVariable(String variableName) {
        this.variableName = variableName;
    }

    public FuzzyVariable(String variableName, List<FuzzySetMember> fuzzySetMembers) {
        this.variableName = variableName;
        this.fuzzySetMembers = fuzzySetMembers;
    }

    public String getVariableName() {
        return variableName;
    }

    public List<FuzzySetMember> getFuzzySetMembers() {
        return fuzzySetMembers;
    }
}
