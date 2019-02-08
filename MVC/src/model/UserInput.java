/**
 * 
 */
package model;

import java.util.Observable;

/**
 * @author mikea
 *
 */
public class UserInput extends Observable {

	private int menuChoice;
	
	public UserInput() {
		super();
	}
	
	public void setMenuChoice(int i) {
		this.menuChoice = i;
		setChanged();
		//notifyObservers(null);
	}

	public int getMenuChoice() {
		return this.menuChoice;
	}
}
