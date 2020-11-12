package quicksort;

import java.util.ArrayList;

import baseClasses.Future;
import baseClasses.RunnableAdapter;

public class QuickSortThread extends RunnableAdapter {
	private Future<ArrayList<Integer>> futureResult;
	private Quicksort sorter;
	
	public QuickSortThread(Future<ArrayList<Integer>> futureResult, ArrayList<Integer> list) {
		super();
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

}
