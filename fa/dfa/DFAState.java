package fa.dfa;

import java.util.HashMap;
import java.util.Map;
import fa.State;

/**
 * Description: This class represents a single DFA state, which extends the
 * State.java class. This object contains a hash map to keep track of its
 * transitions within its DFA.
 * 
 * @author Trevor Smith (trevorsmith772)
 * @author Brandon Mattaini (brandonmattaini)
 * @author Berto Cisneros (bertocisneros)
 * 
 * Date: 2/28/2021
 */
public class DFAState extends State {

    /* Instance Variables */
    private HashMap<Character, DFAState> transitions; // transition map

    /**
     * Constructor for DFA state
     * 
     * @param name - name of the new state
     */
    public DFAState(String name) {
        this.name = name;
        transitions = new HashMap<>();
    }

    /**
     * Creates a new transition for the state
     * 
     * @param inputChar - input character from the alphabet
     * @param toState   - state we're transitioning to
     */
    public void addTransition(char inputChar, DFAState toState) {
        transitions.put(inputChar, toState);
    }

    /**
     * Getter for transitions
     * 
     * @return transitions for the state
     */
    public Map<Character, DFAState> getTransition() {

        return transitions;
    }
}
