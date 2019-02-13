/**
 * 
 */
package controller;
import model.*;
import view.*;

import java.util.ArrayList;


import model.Database;
/**
 * @author mikea
 *
 */
public class Controller {

	private StudentModel model;
	private Database db;
	private MainMenuView mmv;
	private CreateView cv;
	private ReadView rv;
	private ReadOptionsView rov;
	private ReadQueryView rqv;
	private UserInput input;
	private UpdateOptionsView uov;
	private UpdateNameView unv;
	private UpdateErrorView uev;
	private DeleteOptionsView dov;
	private DeleteRecordView drv;
	
	public Controller(Database d, UserInput i, MainMenuView mmv) {
		//this.mmv = mmv;
		this.model = null;
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

	public void deleteAll() {
		this.db.deleteAll();
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

	public String read(String first, String last) {
		return this.db.read(first, last);
	}
	
	private void setStudentModel(StudentModel s) {
		this.model = s;
	}

	public void mainMenu() {
		this.mmv = new MainMenuView();
		int choice = mmv.mainMenu();
		input.setMenuChoice(choice);
	}

	public void createView() {
		this.cv = new CreateView();
		String[] data = cv.createView();
		if (data[0].equalsIgnoreCase("0")){
			return;
		} else {
			create(data[0],data[1]);
			readView(data[0],data[1]);
		}

	}

	public void readView(String first, String last) {
		this.rv = new ReadView();
		this.rv.readView(read(first,last));
	}

	public void readView(String id) {
		this.rv = new ReadView();
		this.rv.readView(read(id));
	}

	public void readOptions() {
		this.rov = new ReadOptionsView();
		int choice = rov.readOptions();
		input.setMenuChoice(choice);
	}

	public void readQueryName() {
		this.rqv = new ReadQueryView();
		String[] data = rqv.queryByName();
		if (data[0].equalsIgnoreCase("0"))
			return;
		else {
			readView(data[0],data[1]);
		}
	}

	public void readQueryId() {
		this.rqv = new ReadQueryView();
		String data = rqv.queryById();
		if (data.equalsIgnoreCase("0"))
			return;
		else {
			readView(data);
		}
	}

	public void readAll() {
		this.rv = new ReadView();
		this.rv.readView(read());
	}

	public void updateOptions() {
		this.uov = new UpdateOptionsView();
		int choice = uov.updateOptions();
		input.setMenuChoice(choice);
	}

	public void updateFirstName() {
		this.unv = new UpdateNameView();
		String[] data = unv.updateFirstName();
		if (data[0].equalsIgnoreCase("0"))
			return;
		else {
			String record = read(data[0]);
			if (record.equalsIgnoreCase("Error: no record found")) {
				this.uev = new UpdateErrorView();
				uev.error();
				return;
			}
			String [] parsedRecord = record.split(",");
			update(parsedRecord[0],data[1],parsedRecord[2]);
			readView(parsedRecord[0]);
		}
	}

	public void updateLastName() {
		this.unv = new UpdateNameView();
		String[] data = unv.updateLastName();
		if (data[0].equalsIgnoreCase("0"))
			return;
		else {
			String record = read(data[0]);
			if (record.equalsIgnoreCase("Error: no record found")) {
				this.uev = new UpdateErrorView();
				uev.error();
				return;
			}
			String [] parsedRecord = record.split(",");
			update(parsedRecord[0],parsedRecord[1],data[1]);
			readView(parsedRecord[0]);
		}
	}

	public void deleteOptions() {
		this.dov = new DeleteOptionsView();
		int choice = dov.deleteOptions();
		input.setMenuChoice(choice);
	}

	public void deleteRecord() {
		this.drv = new DeleteRecordView();
		String data = drv.deleteRecord();
		if (data.equalsIgnoreCase("0"))
			return;
		else {
			delete(data);
			readAll();
		}
	}

	public void deleteAllRecords() {
		this.drv = new DeleteRecordView();
		String answer = drv.deleteAllRecords();
		if (answer.equalsIgnoreCase("y")) {
			deleteAll();
			readAll();
		}

	}


}
