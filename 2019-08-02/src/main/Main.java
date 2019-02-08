/**
 * 
 */
package main;
import model.*;
import controller.*;
import view.MainMenuView;



/**
 * @author mikea
 *
 */
public class Main {

	
	public static void main(String[] args) {
		Database db = new Database();
		UserInput ui = new UserInput();
		Controller c = new Controller(db,ui, new MainMenuView());

		int choice = 0;
		do {
			c.mainMenu();
			choice = ui.getMenuChoice();
			switch(choice) {
				case 0: break;

				case 1: {
					c.createView();
					break;
				}

				case 2: {
					int readChoice = 0;
					do {
						c.readOptions();
						readChoice = ui.getMenuChoice();
						switch(readChoice) {
							case 0: break;

							case 1: {
								c.readQueryName();
								break;
							}
							case 2: {
								c.readQueryId();
								break;
							}
							case 3: {
								c.readAll();
								break;
							}
						}
					} while (readChoice != 0);
					break;
				}

				case 3: {
					int updateChoice = 0;
					do {
						c.updateOptions();
						updateChoice = ui.getMenuChoice();
						switch(updateChoice) {
							case 0: break;

							case 1: {
								c.updateFirstName();
								break;
							}

							case 2: {
								c.updateLastName();
								break;
							}
						}
					} while(updateChoice != 0);
					break;
				}

				case 4: {
					int deleteChoice = 0;
					do {
						c.deleteOptions();
						deleteChoice = ui.getMenuChoice();
						switch(deleteChoice) {
							case 0: break;

							case 1: {
								c.deleteRecord();
								break;
							}

							case 2: {
								c.deleteAllRecords();
								break;
							}
						}
					} while (deleteChoice != 0);
				}
			}
		} while (choice != 0);

		System.out.println("Goodbye");
		db.close();

	}

}
