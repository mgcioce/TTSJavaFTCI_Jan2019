import java.util.*;

/**
 * 
 */

/**
 * @author mikea
 *
 */
public class Vehicle {

	
	/**
	 * I'm going to add a new field here called ID. I'm using the "final" keyword to
	 * say that once this field gets a value it can't be changed.
	 * 
	 * The data type is a UUID class object, which stands for Universally Unique Identifier.
	 * This allows us to give each car in the database a unique ID to search by.
	 */
	private final UUID ID; 
	int numOfWheels;
	int numOfDoors;
	String transmission;
	String fuelType;
	String engineSize;
	double tireSize;
	String tireBrand;
	String make;
	String model;
	String classification;
	
	/**
	 * I also created a classification field. This is used to tell the computer what 
	 * object i need to create - a Vehicle object or a Sedan object.
	 */
	public Vehicle() {
		
		this.classification = "Vehicle";
		this.ID = UUID.randomUUID();
		this.make = "";
		this.model = "";
		numOfWheels = 0;
		numOfDoors = 0;
		transmission = null;
		fuelType = null;
		engineSize = null;
		tireSize = 0;
		tireBrand = null;
	}
	
	//use this constructor for reading in from the database
	public Vehicle(String id,String make, String model,int wheels, int doors, String trans, String fuel, 
						String engine,double tire, String brand) {
		
		setClassification();
		this.make = make;
		this.model = model;
		this.ID = UUID.fromString(id);
		this.numOfWheels = wheels;
		this.numOfDoors = doors;
		this.transmission = trans;
		this.fuelType = fuel;
		this.engineSize = engine;
		this.tireSize = tire;
		this.tireBrand = brand;
	}
	
	//use this constructor when the user enters data manually for a new record
	public Vehicle(String make, String model,int wheels, int doors, String trans, String fuel, 
			String engine,double tire, String brand) {

		setClassification();
		this.make = make;
		this.model = model;
		this.ID = UUID.randomUUID();
		this.numOfWheels = wheels;
		this.numOfDoors = doors;
		this.transmission = trans;
		this.fuelType = fuel;
		this.engineSize = engine;
		this.tireSize = tire;
		this.tireBrand = brand;
	}
	
	public void setNumOfWheels(int n) {
		this.numOfWheels = n;
	}
	
	public int getNumOfWheels() {
		return this.numOfWheels;
	}
	
	public void setNumOfDoors(int d) {
		this.numOfDoors = d;
	}
	
	public int getNumOfDoors() {
		return this.numOfDoors;
	}
	
	public void setTransmission(String trans) {
		this.transmission = trans;
	}
	
	public String getTransmission() {
		return this.transmission;
	}
	
	public void setFuelType(String fuel) {
		this.fuelType = fuel;
	}
	
	public String getFuelType() {
		return this.fuelType;
	}
	
	public void setTireSize(double t) {
		this.tireSize = t;
	}
	
	public double getTireSize() {
		return this.tireSize;
	}
	
	public void setTireBrand(String brand) {
		this.tireBrand = brand;
	}
	
	public String getTireBrand() {
		return this.tireBrand;
	}
	
	public void setMake(String m) {
		this.make = m;
	}
	
	public String getMake() {
		return this.make;
	}
	
	public void setModel(String m) {
		this.model = m;
	}
	
	public String getModel() {
		return this.model;
	}
	
	protected void setClassification() {
		this.classification = "Vehicle";
	}
	
	public UUID getID() {
		return this.ID;
	}
	
	@Override
	public String toString() {
		return this.ID.toString() + "," + this.classification + "," + this.make + "," + this.model + "," + 
				this.numOfWheels + "," + this.numOfDoors + "," + this.transmission + "," +
				this.fuelType + "," + this.engineSize + "," + this.tireSize + "," +
				this.tireBrand;
	}

}
