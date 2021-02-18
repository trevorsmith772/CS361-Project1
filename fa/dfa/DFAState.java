package fa.dfa;

import fa.State;

public class DFAState extends State {
    
    /* Instance Variables */
    private DFAState[] transitions;

    public DFAState(String name){
        this.name = name;
        transitions = new DFAState[2];
    }

    public DFAState[] getTransitions(){
        return transitions;
    }
}
