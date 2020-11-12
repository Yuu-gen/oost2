package quicksort.Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.stream.Collectors;


import org.junit.jupiter.api.Test;

import quicksort.Quicksort;

public class QuicksortTests {
    Quicksort quicksort;



    @Test
    public void testSortedForSingeElementList(){
        ArrayList<Integer> l = new ArrayList<>();
        l.add(1);
        Quicksort q = new Quicksort(l);

        assertTrue(q.isSorted());
    }

    @Test
    public void testSortedForSortedMultyElementList(){
        ArrayList<Integer> l = new ArrayList<>();
        l.add(0);
        l.add(1);
        l.add(2);

        Quicksort q = new Quicksort(l);
        assertTrue(q.isSorted());

        l.add(2);

        Quicksort p = new Quicksort(l);
        assertTrue(p.isSorted());
    }

    @Test
    public void testSortedForUnsortedMultyElementList(){
        ArrayList<Integer> l = new ArrayList<>();
        l.add(2);
        l.add(1);
        l.add(3);

        Quicksort q = new Quicksort(l);
        assertFalse(q.isSorted());

        l.add(0);

        Quicksort p = new Quicksort(l);
        assertFalse(p.isSorted());
    }

    @Test
    public void testSortEmptyList(){
        Quicksort q = new Quicksort(new ArrayList<Integer>());
        assertEquals(q.sort(), new ArrayList<Integer>());
    }

    @Test
    public void testSortSortedList(){
        ArrayList<Integer> l = new ArrayList<>();
        l.add(0);
        l.add(0);
        l.add(1);
        l.add(2);

        Quicksort q = new Quicksort(l);
        assertEquals(q.sort(),l);
    }

    @Test
    public void testSortUnsortedList(){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(0);
        list.add(1);
        list.add(3);
        list.add(9);
        list.add(1);
        list.add(3);

        Quicksort q = new Quicksort(list);
        assertEquals((ArrayList<Integer>)(list.stream().sorted().collect(Collectors.toList())),
                q.sort());
    }
}

