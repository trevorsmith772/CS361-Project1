package fa.dfa;

import java.util.HashMap;
import java.util.Map;

import fa.State;

public class DFAState extends State {
    
    /* Instance Variables */
    private Map<String, DFAState> transitions = new HashMap<>();

    public DFAState(String name){
        this.name = name;
        transitions = null;
    }

    public Map<String, DFAState> getTransitions(){
        return transitions;
    }
}
