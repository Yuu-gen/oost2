package airplaneWithConditionedSynchronisationTemplate;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import javax.swing.JButton;
import java.awt.Rectangle;
import java.lang.Thread.State;

import javax.swing.JLabel;
/**
 * A visual class showing the states of all threads and all planes
 */
public class TravelCenter extends JFrame implements Observer{
	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JTextArea jTextAreaAirplanes = null;
	private JTextArea jTextAreaAgencies = null;
	private JButton jButtonInterrupt = null;
/**
 * List of planes
 */	
	private List<Airplane> planes = new ArrayList<Airplane>();
/**
 * List of Runnables (which are Travel Agencies booking or cancelling seats on the planes)
 */	
	private List<RunnableAdapter> runnables = new ArrayList<RunnableAdapter>();

	public static void main(String[] args) {
		new TravelCenter();
	}
	public TravelCenter() {
		super();
		this.initialize();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	private void createPlanes(){
// TODO 1. Erzeugen der Flugzeuge		
//		this.planes.add(new Airplane(10, "Oskar 1"));
//      ... mehr Flugzeuge ...		
	}
	private void createActionThreads(){
// TODO 2. Erzeugen von Buchungs- und Stornierthreads		
//		this.runnables.add(new BookingThread(this.planes, "Booking1"));
// 		... mehr Buchungsthreads
//		this.runnables.add(new CancellationThread(this.planes, "Cancel1"));
// 		... mehr Stornierthreads
	}
/**
 * This observes the planes   
 */	
	private void registerPlanes(){
		for(Airplane current : this.planes) current.addObserver(this);
	}
	private void interruptAll() {
		for(RunnableAdapter current : this.runnables) current.interrupt();
		this.updateAirplaneList();
		this.updateThreadStates();
	}
	public void update() {
		updateAirplaneList();
		updateThreadStates();
	}
/**	
 * In the sequel, updates to the UI are controlled by Java-internal EventQueue
 */
	private void updateThreadStates() {
		if (this.runnables.size() == 0) {
			this.jTextAreaAgencies.setText("No threads defined");
			return;
		}
		String threadText = "";
		for(RunnableAdapter current : this.runnables) {
			State state = current.getState();
// TIMED_WAITING occurs only if a thread is (RUNNABLE) in the monitor, hence this state is appropriately substituted 			
			if(state.equals(Thread.State.TIMED_WAITING)) state = Thread.State.RUNNABLE;
			threadText += current.toString() + " (" + state + ")\n";
		}
		final String result = threadText;
		EventQueue.invokeLater(()->this.jTextAreaAgencies.setText(result));
	}
	private void updateAirplaneList() {
		if (this.planes.size() == 0) {
			this.jTextAreaAirplanes.setText("No planes defined");
			return;
		}
		String airplaneText = "";
		for(Airplane current : this.planes)
			airplaneText += current.toString() + ": " + current.getOccupied() + " belegte Plätze\n"; 
		final String result = airplaneText;
		EventQueue.invokeLater(()->this.jTextAreaAirplanes.setText(result));
	}
	private void initialize() {
		this.setSize(598, 311);
		this.setContentPane(getJContentPane());
		this.setTitle("Flugzeugbuchungen");
		this.addWindowListener(new java.awt.event.WindowAdapter() { 
			public void windowClosing(java.awt.event.WindowEvent e) {    
				System.exit(0);
			}
		});
		this.createPlanes();
		this.registerPlanes();
		this.createActionThreads();
		for(RunnableAdapter current : this.runnables) current.start();
		this.update();
	}
	
	private JButton getJButtonInterrupt() {
		if (jButtonInterrupt == null) {
			jButtonInterrupt = new JButton();
			jButtonInterrupt.setBounds(new Rectangle(239, 233, 100, 20));
			jButtonInterrupt.setText("Interrupt All");
			jButtonInterrupt.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					interruptAll();
				}
			});
		}
		return jButtonInterrupt;
	}
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJTextAreaAirplanes(), null);
			jContentPane.add(getJTextAreaAgencies(), null);
			jContentPane.add(getJButtonInterrupt(), null);
			
			JLabel lblNewLabel = new JLabel("Airplanes");
			lblNewLabel.setBounds(70, 8, 92, 14);
			jContentPane.add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("Action Threads");
			lblNewLabel_1.setBounds(364, 11, 92, 14);
			jContentPane.add(lblNewLabel_1);
		}
		return jContentPane;
	}
	private JTextArea getJTextAreaAirplanes() {
		if (jTextAreaAirplanes == null) {
			jTextAreaAirplanes = new JTextArea();
			jTextAreaAirplanes.setBounds(new Rectangle(15, 33, 241, 189));
			jTextAreaAirplanes.setEditable(false);
		}
		return jTextAreaAirplanes;
	}
	
	private JTextArea getJTextAreaAgencies() {
		if (jTextAreaAgencies == null) {
			jTextAreaAgencies = new JTextArea();
			jTextAreaAgencies.setBounds(new Rectangle(286, 33, 241, 189));
			jTextAreaAgencies.setEditable(false);
		}
		return jTextAreaAgencies;
	}
} 
