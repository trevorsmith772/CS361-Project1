package fa.dfa;

import java.util.Map;
import java.util.Set;

import fa.State;

public class DFA implements DFAInterface {

    /* Instance Variables */
    private Set<DFAState> totalStates;
    private DFAState initialState;
    private Set<DFAState> finalStates;
    private Set<String> alphabet;
    private Map<String, DFAState> transitions;

    @Override
    public void addStartState(String name) {
        // TODO Auto-generated method stub

    }

    @Override
    public void addState(String name) {
        // TODO Auto-generated method stub

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
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Set<? extends State> getFinalStates() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public State getStartState() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Set<Character> getABC() {
        // TODO Auto-generated method stub
        return null;
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
    
    public String toString(){
        //TODO
        return null;
    }
}
