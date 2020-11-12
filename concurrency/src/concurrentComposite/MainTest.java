package concurrentComposite;

import junit.framework.TestCase;
/**
 * 3 simple test cases
 */
public class MainTest extends TestCase {
	private Directory d1, d2, d3, d4, d5; 
	private File f1,f2,f3,f4,f5,f6,f7;
	protected void setUp() throws Exception {
		super.setUp();
		f1 = new File(1, "f1");f2 = new File(2, "f2");f3 = new File(3, "f3");f4 = new File(4, "f4");f5 = new File(5, "f5");f6 = new File(6, "f6");f7 = new File(7, "f7");
		d1 = new Directory("d1");d2 = new Directory("d2");d3 = new Directory("d3");d4 = new Directory("d4");d5 = new Directory("d5");
	}
	public void test1(){
		this.perform(d1, 0);
	}
	public void test2(){
		d1.addComponent(f1);d1.addComponent(f2);
		this.perform(d1, 3); 
	}
/**
 * Main test case
 */	
	public void test3(){
		d1.addComponent(f1);d1.addComponent(f2);d1.addComponent(d2);d2.addComponent(f3);d2.addComponent(f4);
		d1.addComponent(d3);d1.addComponent(d4); d4.addComponent(d5); d5.addComponent(f5);
		d5.addComponent(f7); d4.addComponent(f6);
		this.perform(d1, 28); 
	}
	
	private void perform(Component underTest,Integer expected){
		System.out.println();
		System.out.println("===============");
		System.out.println("Start Test Case");
		System.out.println("===============");
		try {
			assertEquals(expected, underTest.calculateSize());
		} catch (InterruptedException e) {
			System.out.println(new InterruptedExceptionReaction(underTest).toString());
		}
	}
}
