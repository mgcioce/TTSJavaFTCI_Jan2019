/**
 * 
 */
package main;
import model.*;
import controller.*;

/**
 * @author mikea
 *
 */
public class Main {

	
	public static void main(String[] args) {
		Database db = new Database();
		Controller c = new Controller(db,new UserInput());
		c.displayRecords();
	}

}
