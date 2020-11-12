package quicksort.Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import quicksort.QuicksortGeneric;

public class QuickSortGenericTests {

	@Test
	public void testSortedForSingleElementList() {
		ArrayList<Integer> l = new ArrayList<>();
		l.add(1);
		QuicksortGeneric<Integer> q = new QuicksortGeneric<Integer>(l);

		assertTrue(q.isSorted());
	}

	@Test
	public void testSortedForSortedMultiElementList() {
		ArrayList<Integer> l = new ArrayList<>();
		l.add(0);
		l.add(1);
		l.add(2);

		QuicksortGeneric<Integer> q = new QuicksortGeneric<Integer>(l);
		assertTrue(q.isSorted());

		l.add(2);

		QuicksortGeneric<Integer> p = new QuicksortGeneric<Integer>(l);
		assertTrue(p.isSorted());
	}

	@Test
	public void testSortedForUnsortedMultiElementList() {
		ArrayList<Integer> l = new ArrayList<>();
		l.add(2);
		l.add(1);
		l.add(3);

		QuicksortGeneric<Integer> q = new QuicksortGeneric<Integer>(l);
		assertFalse(q.isSorted());

		l.add(0);

		QuicksortGeneric<Integer> p = new QuicksortGeneric<Integer>(l);
		assertFalse(p.isSorted());
	}

	@Test
	public void testSortEmptyList() {
		QuicksortGeneric<Integer> q = new QuicksortGeneric<Integer>(new ArrayList<Integer>());
		assertEquals(q.sort(), new ArrayList<Integer>());
	}

	@Test
	public void testSortSortedIntegerList() {
		ArrayList<Integer> l = new ArrayList<>();
		l.add(0);
		l.add(0);
		l.add(1);
		l.add(2);

		QuicksortGeneric<Integer> q = new QuicksortGeneric<Integer>(l);
		assertEquals(q.sort(), l);
	}

	@Test
	public void testSortUnsortedIntegerList() {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(2);
		list.add(0);
		list.add(1);
		list.add(3);
		list.add(9);
		list.add(1);
		list.add(3);

		QuicksortGeneric<Integer> q = new QuicksortGeneric<Integer>(list);
		assertEquals((ArrayList<Integer>) (list.stream().sorted().collect(Collectors.toList())), q.sort());
	}
	
	@Test
	public void testSortUnsortedStringList() {
		ArrayList<String> list = new ArrayList<>();
		list.add("z");
		list.add("v");
		list.add("i");
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("q");

		QuicksortGeneric<String> q = new QuicksortGeneric<String>(list);
		assertEquals((ArrayList<String>) (list.stream().sorted().collect(Collectors.toList())), q.sort());
	}
}
