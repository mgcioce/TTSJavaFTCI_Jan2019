import java.io.*;
import java.io.FileWriter;
import java.util.*;

/**
 * @author mikea
 *
 */
public class Sedan extends Vehicle {

	boolean sunRoof;
	double trunkSize;
	
	public Sedan() {
		super();
		this.sunRoof = false;
		this.trunkSize = 0.0;
	}
	
	public Sedan(boolean sun) {
		super();
		this.sunRoof = sun;
		this.trunkSize = 0.0;
	}
	
	//use this constructor for reading in from the database
	public Sedan(String id,String make, String model,int wheels, int doors, String trans, String fuel,
			String engine, double tire, String brand, boolean sun,double trunk) {
		
		super(id,make,model,wheels, doors, trans, fuel, engine, tire, brand);
		this.sunRoof = sun;
		this.trunkSize = trunk;
		setClassification();	
	}
	
	//use this constructor when the user enters data manually for a new record
	public Sedan(String make, String model,int wheels, int doors, String trans, String fuel,
			String engine, double tire, String brand, boolean sun,double trunk) {
		
		super(make,model,wheels, doors, trans, fuel, engine, tire, brand);
		this.sunRoof = sun;
		this.trunkSize = trunk;
		setClassification();
	}
	
	public void setSunRoof(boolean tf) {
		this.sunRoof = tf;
	}
	
	public boolean getSunRoof() {
		return this.sunRoof;
	}
	
	public void setTrunkSize(double s) {
		this.trunkSize = s;
	}
	
	public double getTrunkSize() {
		return this.trunkSize;
	}
	
	@Override
	protected void setClassification() {
		this.classification = "Sedan";
	}
	
	public String getClassification() {
		return this.classification;
	}
	
	public String toString() {
		String returnString = super.toString();
		return returnString.concat("," + this.sunRoof + "," + this.trunkSize);
	}

}
