package FuzzyLogic;

import java.util.List;

/**
 * Created by user on 04.06.2017.
 */
public class LinguisticVariable {
    String variableName;
    private List<FuzzySetMember> fuzzySetMembers;

    public LinguisticVariable(String variableName) {
        this.variableName = variableName;
    }

    public LinguisticVariable(String variableName, List<FuzzySetMember> fuzzySetMembers) {
        this.variableName = variableName;
        this.fuzzySetMembers = fuzzySetMembers;
    }

}
