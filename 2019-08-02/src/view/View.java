/**
 * 
 */
package view;
import java.util.*;
/**
 * @author mikea
 *
 */
public class View {
	
	public static int mainMenu() {
		System.out.println("Welcome to the student database.\n\n\t1.Create" +
				"\n\t2.Read\n\t3.Update\n\t4.Delete\n\t0.Exit");
		Scanner kb = new Scanner(System.in);
		return kb.nextInt();
	}
	
	public static void displayRecords(ArrayList<String> records) {
		for (String s: records) {
			System.out.println(s);
		}
	}
	
}
