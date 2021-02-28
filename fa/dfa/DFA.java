package fa.dfa;

import fa.State;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Description: This class represents a DFA object that contains variables to
 * represent a 5-tuple. This class is used in combination with DFADriver to
 * construct a DFA and return whether given strings are accepted or rejected by
 * the DFA.
 * 
 * @author Trevor Smith (trevorsmith772)
 * @author Brandon Mattaini (brandonmattaini)
 * @author Berto Cisneros (bertocisneros)
 * 
 * Date: 2/28/2021
 */
public class DFA implements DFAInterface {

    /* Instance Variables to implement 5-tuple */
    private LinkedHashSet<DFAState> totalStates; // Q
    private DFAState initialState; // q0
    private LinkedHashSet<DFAState> finalStates; // F
    private LinkedHashSet<Character> alphabet; // Sigma

    /**
     * DFA constructor. Sets all variables to null
     */
    public DFA() {
        totalStates = new LinkedHashSet<>();
        initialState = null;
        finalStates = new LinkedHashSet<>();
        alphabet = new LinkedHashSet<>();
    }




    /**
     * Adds a new start state to the dfa
     * 
     * @param name - the name of the added start state
     */
    public void addStartState(String name) {

        for (DFAState state : finalStates) {
            if (state.getName().equals(name)) {
                initialState = state;
            }
        }
        if (initialState == null) {
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

        if (!alphabet.contains(onSymb)) {
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
        for (int i = 0; i < s.length(); i++) {
            currState = getToState(currState, s.charAt(i));
        }
        if (finalStates.contains(currState)) {
            return true;
        } else {
            return false;
        }
    }

    // haha

    /**
     * Gets the state that will be transitioned to, given a from state and an input
     * character
     * 
     * @param from   - state to be transitioned from
     * @param onSymb - input character
     * @return the state we are transitioning to
     */
    public DFAState getToState(DFAState from, char onSymb) {

        return from.getTransition().get(onSymb);
    }

    /**
     * Construct the textual representation of the DFA, for example A simple two
     * state DFA Q = { a b } Sigma = { 0 1 } delta = 0 1 a a b b a b q0 = a F = { b
     * }
     * 
     * The order of the states and the alphabet is the order in which they were
     * instantiated in the DFA.
     * 
     * @return String representation of the DFA
     */
    public String toString() {
        String output = "";

        String table = "\t\t";
        for (char b : alphabet) {
            table += b + "\t";
        }
        table += "\n";

        for (DFAState target : totalStates) {
            table += "\t";
            table += target.getName() + "\t";

            for (char c : alphabet) {
                table += getToState(target, c).getName() + "\t";
            }
            table += "\n";
        }

        String finalPrint = "";
        String finalAlph = "";

        for (char alph : alphabet) {
            finalAlph += alph + " ";
        }

        for (DFAState end : finalStates) {
            finalPrint += end.getName() + " ";
        }

        output += "Q = { ";
        for (DFAState state : totalStates) {
            output += state.getName() + " ";
        }

        output += "}\n";
        output += "Sigma = { " + finalAlph + "}\n" + "delta =\n" + "           " + "\n" + table + "q0 = "
                + initialState.getName() + "\n" + "F = { " + finalPrint + "}" + "\n";

        return output;
    }
}
