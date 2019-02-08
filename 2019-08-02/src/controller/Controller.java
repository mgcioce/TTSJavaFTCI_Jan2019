/**
 * 
 */
package controller;
import model.*;
import view.View;

import java.util.ArrayList;

import model.Database;
/**
 * @author mikea
 *
 */
public class Controller {

	private StudentModel model;
	//private View view;
	private Database db;
	private UserInput input;
	
	public Controller(Database d, UserInput i) {
		this.model = null;
		//this.view = v;
		this.db = d;
		this.input = i;
	}
	
	public String getFirstName() {
		return this.model.getFirstName();
	}
	
	public String getLastName() {
		return this.model.getLastName();
	}
	
	public String getStudentId() {
		return this.model.getStudentID().toString();
	}
	
	public void setFirstName(String first) {
		this.model.setFirstName(first);
	}
	
	public void setLastName(String last) {
		this.model.setLastName(last);
	}
	
	public void create(String first, String last) {
		this.db.create(first, last);
	}
	
	public void delete(String id) {
		this.db.delete(id);
	}
	
	public void update(String id, String first, String last) {
		this.db.update(id, first, last);
	}
	
	public ArrayList<String> read() {
		return this.db.read();
	}
	
	public String read(String id) {
		return this.db.read(id);
	}
	
//	public void mainMenu() {
//		int c = View.mainMenu();	
//	}
	
	public void displayRecords() {
		View.displayRecords(this.db.read());
	}
	
	private void setStudentModel(StudentModel s) {
		this.model = s;
	}
}
