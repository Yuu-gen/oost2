package quicksort.Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import quicksort.QuicksortGeneric;
import quicksort.QuicksortGenericSingleThread;

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
	
	@Test
	public void testSortUnsortedVariableSizedIntegerList() {
		ArrayList<Integer> list = randomIntList(500);

		QuicksortGeneric<Integer> q = new QuicksortGeneric<Integer>(list);
		ArrayList<Integer> sortedList = q.sort();
		assertEquals((ArrayList<Integer>) (list.stream().sorted().collect(Collectors.toList())), sortedList);
		System.out.println("IntegerList:"+ '\n' +sortedList);
	}
	
	@Test
	public void testSortUnsortedVariableSizedStringList() {
		ArrayList<String> list = randomStringList(50000);
		QuicksortGeneric<String> q = new QuicksortGeneric<String>(list);
		ArrayList<String> sortedList = q.sort();
		assertEquals((ArrayList<String>) (list.stream().sorted().collect(Collectors.toList())), sortedList);
		//System.out.println("StringList:"+ '\n' +sortedList);
	}
	@Test
	public void SortSingleUnsortedVariableSizedStringList() {
		ArrayList<String> list = randomStringList(50000);
		QuicksortGenericSingleThread<String> q = new QuicksortGenericSingleThread<String>(list);
		ArrayList<String> sortedList = q.sort();
		assertEquals((ArrayList<String>) (list.stream().sorted().collect(Collectors.toList())), sortedList);
		//System.out.println("StringList:"+ '\n' +sortedList);
	}
	
	private ArrayList<Integer> randomIntList(Integer size){
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < size; i++) {
			result.add(new Random().nextInt());
		}
		return result;
		
	}
	
	private ArrayList<String> randomStringList(Integer size){
		ArrayList<String> result = new ArrayList<String>();
		for (int i = 0; i < size; i++) {
			result.add(generateString(new Random(),"abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ",Math.abs((new Random().nextInt(20)))));
		}
		//System.out.println("randomStringList "+result);
		return result;
		
	}
	public static String generateString(Random random, String characters, int length)
	{
	    char[] text = new char[length];
	    for (int i = 0; i < length; i++)
	    {
	        text[i] = characters.charAt(random.nextInt(characters.length()));
	    }
	    return new String(text);
	}
	
}
