package fa.dfa;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import fa.State;

public class DFA implements DFAInterface {

    /* Instance Variables to implement 5-tuple */
    private Set<DFAState> totalStates = new HashSet<>(); // Q
    private DFAState initialState; // q0
    private Set<DFAState> finalStates = new HashSet<>(); // F
    private Set<Character> alphabet = new HashSet<>(); // Sigma

    /**
     * DFA constructor. Sets all variables to null
     */
    public DFA() {
        totalStates = null;
        initialState = null;
        finalStates = null;
        alphabet = null;
    }

    /**
     * Adds a new start state to the dfa
     * 
     * @param name - the name of the added start state
     */
    public void addStartState(String name) {
        DFAState startState = new DFAState(name);
        totalStates.add(startState);
        initialState = startState;
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

    @Override
    public void addFinalState(String name) {
        // TODO Auto-generated method stub

    }

    @Override
    public void addTransition(String fromState, char onSymb, String toState) {
        // TODO Auto-generated method stub

    }

    @Override
    public Set<? extends State> getStates() {
        return totalStates;
    }

    @Override
    public Set<? extends State> getFinalStates() {
        return finalStates;
    }

    @Override
    public State getStartState() {
        return initialState;
    }

    @Override
    public Set<Character> getABC() {
        return alphabet;
    }

    @Override
    public boolean accepts(String s) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public State getToState(DFAState from, char onSymb) {
        // TODO Auto-generated method stub
        return null;
    }

    public String toString() {
        // TODO
        return null;
    }
}
