package quicksort;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import baseClasses.Future;

public class QuicksortGenericSingleThread<T extends Comparable<? super T>> {

	private ArrayList<T> list;

	public QuicksortGenericSingleThread(ArrayList<T> list) {
		super();
		this.list = list;
	}

	/**
	 * Returns a sorted IntegerList
	 * 
	 * @return
	 */
	public ArrayList<T> sort() {
		return sort(new ArrayList<T>(this.list));
	}

	/**
	 * Sorts an ArrayList using mutilated quicksort!
	 * 
	 * @param list
	 * @return
	 */
	private ArrayList<T> sort(ArrayList<T> list) {
		if (isSorted(list))
			return list;
		else {
			ArrayList<T> lower = new ArrayList<T>();
			ArrayList<T> equal = new ArrayList<T>();
			ArrayList<T> greater = new ArrayList<T>();
			T pivot = list.get(0);

			for (T element : list) {
				if (element.compareTo(pivot) < 0)
					lower.add(element);
				else if (element.compareTo(pivot) == 0)
					equal.add(element);
				else
					greater.add(element);
			}
			ArrayList<T> result = new ArrayList<>();

			result.addAll(sort(lower));
			result.addAll(equal);
			result.addAll(sort(greater));
			return result;

//			return (ArrayList<T>) Stream.of(sort(lower), equal, sort(greater)).flatMap(Collection::stream)
//					.collect(Collectors.toList());
		}
	}

	public boolean isSorted() {
		return isSorted(this.list);
	}

	private boolean isSorted(ArrayList<T> list) {
		if (list.size() <= 1)
			return true;
		else
			return isSortedNonEmptyList();
	}

	/**
	 * REQUIRES: List with size > 1
	 */
	private boolean isSortedNonEmptyList() {
		for (int i = 0; i < this.list.size() - 1; i++) {
			if (this.list.get(i).compareTo(this.list.get(i + 1)) > 0)
				return false;
		}

		return true;
	}

}
