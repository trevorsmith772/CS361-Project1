package fa.dfa;

import java.util.HashMap;
import java.util.Map;

import fa.State;

public class DFAState extends State {
    
    /* Instance Variables */
    private HashMap<Character, DFAState> transitions; //transition map

    /**
     * Cosntructor for DFA state
     * 
     * @param name - name of the new state
     */
    public DFAState(String name){
        this.name = name;
        transitions = new HashMap<>();
    }

    /**
     * Creates a new transition for the state
     * 
     * @param inputChar - input character from the alphabet
     * @param toState - state we're transitioning to
     */
    public void addTransition(char inputChar, DFAState toState){
        transitions.put(inputChar, toState);
    }

    /**
     * Getter for transitions
     * 
     * @return transitions for the state
     */
    public Map<Character, DFAState> getTransition(){
        
        return transitions;
    }

    public DFAState getNextTransition(char transition) {
        DFAState ret = transitions.get(transition);
        if (ret == null)
            return null;
        else
            return ret;
    }

    /**
     * Getter for name
     * 
     * @return the name of the state
     */
    public String getName() {
        return name;
    }
}
