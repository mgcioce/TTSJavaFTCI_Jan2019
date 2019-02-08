/**

 * 
 */
package model;
import java.util.*;


/**
 * This is the Model. It is used to pass data to the View and Controller components.
 *
 */
public class StudentModel {

	private String firstName;
	private String lastName;
	private final UUID STUDENT_ID;
	
	public StudentModel(String id, String first, String last) {
		this.firstName = first;
		this.lastName = last;
		this.STUDENT_ID = UUID.fromString(id);
	}
	
	public StudentModel(String first, String last) {
		this.firstName = first;
		this.lastName = last;
		this.STUDENT_ID = UUID.randomUUID();
	}
	
	public void setFirstName(String first) {
		this.firstName = first;
	}
	
	public void setLastName(String last) {
		this.lastName = last;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public UUID getStudentID() {
		return this.STUDENT_ID;
	}
	
	@Override
	public String toString() {
		return this.STUDENT_ID.toString() + "," + this.firstName + "," + this.lastName;
	}
	
}
