package fa.dfa;

import fa.State;
import java.util.HashSet;
import java.util.Set;


public class DFA implements DFAInterface {

    /* Instance Variables to implement 5-tuple */
    private Set<DFAState> totalStates; // Q
    private DFAState initialState; // q0
    private Set<DFAState> finalStates = new HashSet<>(); // F
    private Set<Character> alphabet = new HashSet<>(); // Sigma

    /**
     * DFA constructor. Sets all variables to null
     */
    public DFA() {
        totalStates = new HashSet<>();
        initialState = null;
        finalStates = new HashSet<>();
        alphabet = new HashSet<>();
    }

    /**
     * Adds a new start state to the dfa
     * 
     * @param name - the name of the added start state
     */
    public void addStartState(String name) {

        for(DFAState state : finalStates){
            if(state.getName().equals(name)){
                initialState = state;
            }
        }
        if(initialState == null){
            DFAState startState = new DFAState(name);
            totalStates.add(startState);
            initialState = startState;
        }
    }

    /**
     * Adds a new state to the dfa
     * 
     * @param name - the name of the new state
     */
    public void addState(String name) {
        DFAState newState = new DFAState(name);
        totalStates.add(newState);
    }

    /**
     * Adds a new final state to the dfa
     * 
     * @param name - the name of the new final state
     */
    public void addFinalState(String name) {
        DFAState finalState = new DFAState(name);
        totalStates.add(finalState);
        finalStates.add(finalState);
    }

    /**
     * Adds a new transition to the dfa, or rather to the state we're transitioning
     * from
     * 
     * @param fromState - current state
     * @param onSymb    - input character from alphabet
     * @param toState   - state we transition to
     */
    public void addTransition(String fromState, char onSymb, String toState) {
        DFAState fState = get(fromState);
        DFAState tState = get(toState);

        fState.addTransition(onSymb, tState);
    }

    /**
     * Helper method to retrieve a state from the totalStates Set
     * 
     * @param name - the name of the state
     * @return the state we want to get
     */
    private DFAState get(String name) {
        DFAState[] array = totalStates.toArray(new DFAState[totalStates.size()]);
        DFAState state = null;
        for (DFAState a : array) {
            if (a.getName().equals(name)) {
                state = a;
            }
        }
        return state;
    }

    /**
     * Getter for states
     * 
     * @return the set of states
     */
    public Set<? extends State> getStates() {
        return totalStates;
    }

    /**
     * Getter for final states
     * 
     * @return the set of final states
     */
    public Set<? extends State> getFinalStates() {
        return finalStates;
    }

    /**
     * Getter for start state
     * 
     * @return the initial state
     */
    public State getStartState() {
        return initialState;
    }

    /**
     * Getter for alphabet
     * 
     * @return the set of characters
     */
    public Set<Character> getABC() {
        return alphabet;
    }

    @Override
    public boolean accepts(String s) {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * Gets the state that will
     *  be transitioned to, given
     *  a from state and an input 
     *  character
     * 
     * @param from - state to be transitioned from
     * @param onSymb - input character
     * @return the state we are transitioning to
     */
    public State getToState(DFAState from, char onSymb) {
        
        return from.getTransition().get(onSymb);
    }

    
    public String toString() {
        String output = "";
        int total = totalStates.size();

        String tab = "\t\t";
        for(char b : alphabet){
            tab += b + "\t\t";
        }
        tab += "\n";

        for(DFAState target: totalStates){
            tab += "\t\t" + target.getName() + "\t\t";

            for(char c : alphabet){
                tab += target.getNextTransition(c).getName() + "\t\t";
            }
            tab += "\n";
        }


        output += "Q = { " + totalStates.toString() + " }\n" + 
        "Sigma = { " + alphabet.toString() + " }\n" + 
        "delta =\n" + 
        "           " + alphabet.toString() + "\n" + tab +
        "q0 = " + initialState.getName() + "\n" +
        "F = { " + finalStates.toString() + "\n";





//      for(int i = 0; i <= total; i++){
//            output += alphabet.forEach(alphabet:toString);
//        }
        // "       a   a   b\n" + 
        // "       b   a   b\n" + 
        // "q0 = " + initialState.toString() + "\n" + 
        // "F = { " + finalStates.toString() + " }";
        return output;
    }
}
