package fa.dfa;

import fa.State;
import java.util.HashSet;
import java.util.Set;


public class DFA implements DFAInterface {

    /* Instance Variables to implement 5-tuple */
    private Set<DFAState> totalStates; // Q
    private DFAState initialState; // q0
    private Set<DFAState> finalStates; // F
    private Set<Character> alphabet; // Sigma

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
        totalStates.remove(fState);

        fState.addTransition(onSymb, tState);
        totalStates.add(fState);
        if(!alphabet.contains(onSymb)){
            alphabet.add(onSymb);
        }
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
        DFAState currState = initialState;
        for(int i = 0; i < s.length(); i++){
            currState = getToState(currState, s.charAt(i));
        }
        if(finalStates.contains(currState)){
            return true;
        }
        else {
            return false;
        }
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
    public DFAState getToState(DFAState from, char onSymb) {
        
        return from.getTransition().get(onSymb);
    }



    /*
     * @return the state, alphabet, table, etc. are printed out
     */
    public String toString() {
        String output = "";

        String tab = "\t";
        for(char b : alphabet){
            tab += b + "\t";
        }
        tab += "\n";

        for(DFAState target: totalStates){
            tab += target.getName() + "\t";

            for(char c : alphabet){
                tab += getToState(target, c).getName() + "\t";
            }
            tab += "\n";
        }


        String finalPrint = "";
        String finalAlph = "";

        for(char alph : alphabet){
            finalAlph += alph + " ";
        }


        for(DFAState end : finalStates){
            finalPrint += end.getName() + " ";
        }

        output += "Q = { ";
        for(DFAState state : totalStates){
            output += state.getName() + " ";
        }

        output += "}\n";
        output += "Sigma = { " + finalAlph + "}\n" +
        "delta =\n" + 
        "           " + "\n" + tab +
        "q0 = " + initialState.getName() + "\n" +
        "F = { " + finalPrint + "}" + "\n";

        return output;
    }
}
