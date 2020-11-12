package quicksort;

import java.util.ArrayList;

import baseClasses.Future;
import baseClasses.RunnableAdapter;

public class QuickSortThread<T extends Comparable<? super T>> extends RunnableAdapter {
	private Future<ArrayList<T>> futureResult;
	private QuicksortGeneric<T> sorter;
	
	public QuickSortThread(Future<ArrayList<T>> futureResult, ArrayList<T> list) {
		super();
		this.futureResult = futureResult;
		this.sorter = new QuicksortGeneric<T>(list);
	}

	@Override
	public void run() {
		//System.out.println("Thread started sorting");
		this.futureResult.setContents(this.sorter.sort());	
	}

}
