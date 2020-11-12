package concurrentComposite;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
public class Directory extends Component {
	private Collection<Component> components; // Components  
	public Directory(String name){
		super(name);
		this.components = new ArrayList<Component>();
	}
	public void addComponent(Component c){
		this.components.add(c);
	}
	public Integer doCalculateSize() throws InterruptedException{
		Set<Future<Integer>> futures = new HashSet<>();
/* 1. Nebenläufige Berechnungen aller meiner Komponenten */
		for (Component component : components) {
			Future<Integer> behaelter = new Future<Integer>();
			futures.add(behaelter);
			new CalculationThread(behaelter, component).start();
		}

/* 2. Abholen der Ergebnisse */
		Integer result = 0;
		for (Future<Integer> currentFuture : futures) {
			result += currentFuture.receiveContents();
		}
		return result;
	}
}
