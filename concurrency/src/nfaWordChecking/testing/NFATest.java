package nfaWordChecking.testing;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import nfaWordChecking.nfaModel.AutomatonState;
import nfaWordChecking.nfaModel.NFA;
import nfaWordChecking.nfaModel.Transition;
import nfaWordChecking.objectSpaces.TagDirectory;

class NFATest {
	
	private Set<Transition> transitions;
	private Set<AutomatonState> states;
	private NFA nfa;
	
	private AutomatonState z0;
	private AutomatonState z1;
	private AutomatonState z2;
	private AutomatonState z3;
	
	private Transition t0;
	private Transition t1;
	private Transition t2;
	private Transition t3;
	private Transition t4;
	private Transition t5;
	private Transition t6;
	
	@BeforeEach
	void setUp() {
		transitions = new HashSet<>();
		states = new HashSet<>();
		
		// STATES
		boolean isTerminal = true;
		
		z0 = new AutomatonState("z0", !isTerminal);
		z1 = new AutomatonState("z1", !isTerminal);
		z2 = new AutomatonState("z2", !isTerminal);
		z3 = new AutomatonState("z3", isTerminal);
		
		states.add(z0);
		states.add(z1);
		states.add(z2);
		states.add(z3);
		
		// TRANSITIONS
		t0 = new Transition(z0, '0', z0);
		t1 = new Transition(z0, '1', z0);
		t2 = new Transition(z0, '0', z1);
		
		t3 = new Transition(z1, '0', z2);
		t4 = new Transition(z1, '1', z2);
		
		t5 = new Transition(z2, '0', z3);
		t6 = new Transition(z2, '1', z3);
		
		transitions.add(t0);
		transitions.add(t1);
		transitions.add(t2);
		transitions.add(t3);
		transitions.add(t4);
		transitions.add(t5);
		transitions.add(t6);
		
		// BUILD NFA
		nfa = new NFA(z0, states, transitions);
	}
	
	@Test
	void z0_0() {
		Set<AutomatonState> expected = new HashSet<>();
		expected.add(z0);
		expected.add(z1);
		assertEquals(expected, nfa.getTargetStates(z0, '0'));
	}
	@Test
	void z0_1() {
		Set<AutomatonState> expected = new HashSet<>();
		expected.add(z0);
		assertEquals(expected, nfa.getTargetStates(z0, '1'));
	}

	@Test
	void z1_0() {
		Set<AutomatonState> expected = new HashSet<>();
		expected.add(z2);
		assertEquals(expected, nfa.getTargetStates(z1, '0'));
	}
	@Test
	void z1_1() {
		Set<AutomatonState> expected = new HashSet<>();
		expected.add(z2);
		assertEquals(expected, nfa.getTargetStates(z1, '1'));
	}
	
	@Test
	void z2_0() {
		Set<AutomatonState> expected = new HashSet<>();
		expected.add(z3);
		assertEquals(expected, nfa.getTargetStates(z2, '0'));
	}
	@Test
	void z2_1() {
		Set<AutomatonState> expected = new HashSet<>();
		expected.add(z3);
		assertEquals(expected, nfa.getTargetStates(z2, '1'));
	}
	
	@Test
	void testCheck1() {
		try {
			TagDirectory.initialize();
			assertTrue( nfa.check("000"));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	void testCheck2() {
		try {
			TagDirectory.initialize();
			assertFalse( nfa.check("000111"));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
