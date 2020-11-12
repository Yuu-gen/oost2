package quicksort;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/**
 * Takes a List and sorts it in ascending order
 * Single-threaded variant
 */
public class Quicksort {

    private ArrayList<Integer> list;

    public Quicksort(ArrayList<Integer> list) {
        this.list = list;
    }
    /**
     * Returns a sorted IntegerList
     * @return
     */
    public ArrayList<Integer> sort() {
        return sort(new ArrayList<>(this.list));
    }

    private ArrayList<Integer> sort(ArrayList<Integer> list) {
        if (isSorted(list)) return list;
        else {
            ArrayList<Integer> lower = new ArrayList<>();
            ArrayList<Integer> equal = new ArrayList<>();
            ArrayList<Integer> greater = new ArrayList<>();
            Integer pivot = list.get(0);

            for (Integer element: list) {
                if(element < pivot) lower.add(element);
                else if(element == pivot) equal.add(element);
                else greater.add(element);
            }

            return (ArrayList<Integer>) Stream.of(sort(lower), equal, sort(greater)).
                    flatMap(Collection::stream).collect(Collectors.toList());
        }
    }

    public boolean isSorted() {
        return isSorted(this.list);
    }

    private boolean isSorted(ArrayList<Integer> list) {
        if (list.size() <= 1) return true;
        else return isSortedNonEmptyList();
    }

    /**
     * REQUIRES: List with size > 1
     */
    private boolean isSortedNonEmptyList() {
        for (int i = 0; i < this.list.size() - 1; i++) {
            if (this.list.get(i) > this.list.get(i + 1)) return false;
        }

        return true;
    }
}
