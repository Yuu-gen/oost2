package quicksort;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import baseClasses.Future;

public class QuicksortGeneric<T extends Comparable<? super T>> {

	private ArrayList<T> list;

	public QuicksortGeneric(ArrayList<T> list) {
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
	 * @param list
	 * @return
	 */
	private ArrayList<T> sort(ArrayList<T> list) {
		if (isSorted(list)) //mit Überprüfung auf ein-elementige Liste ersetzen
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
			Future<ArrayList<T>> lowerPart = new Future<ArrayList<T>>();
			Future<ArrayList<T>> greaterPart = new Future<ArrayList<T>>();
			new QuickSortThread<>(lowerPart, lower).start();
			new QuickSortThread<>(greaterPart, greater).start();
			
			try {
				result.addAll(lowerPart.receiveContents());
				result.addAll(equal);
				result.addAll(greaterPart.receiveContents());

			} catch (InterruptedException e) {
				System.err.println("AAAAAAAAAARGH! interrupted while sorting.");
			}
			return result;

//			try {
//				return (ArrayList<T>) Stream.of(lowerPart.receiveContents(), equal, greaterPart.receiveContents()).flatMap(Collection::stream)
//						.collect(Collectors.toList());
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			return result;
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
