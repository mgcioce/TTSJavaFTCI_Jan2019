/**
 * 
 */

/**
 * @author mikea
 *
 */
public class Vehicle {

	
	
	int numOfWheels;
	int numOfDoors;
	String transmission;
	String fuelType;
	String engineSize;
	double tireSize;
	String tireBrand;
	
	public Vehicle() {
		numOfWheels = 0;
		numOfDoors = 0;
		transmission = null;
		fuelType = null;
		engineSize = null;
		tireSize = 0;
		tireBrand = null;
		//super();
	}
	public Vehicle(int wheels, int doors, String trans, String fuel, String engine,
						double tire, String brand) {
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
	
	public static void main(String[] args) {
		
		

	}

}
