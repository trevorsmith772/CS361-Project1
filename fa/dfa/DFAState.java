package fa.dfa;

import java.util.HashMap;
import java.util.Map;

import fa.State;

public class DFAState extends State {
    
    /* Instance Variables */
    String name;    //name of the state
    private Map<Character, DFAState> transitions = new HashMap<>(); //transition map

    /**
     * Cosntructor for DFA state
     * 
     * @param name - name of the new state
     */
    public DFAState(String name){
        this.name = name;
        transitions = null;
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
    public Map<Character, DFAState> getTransitions(){
        return transitions;
    }
}
