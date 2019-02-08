import java.io.*;
import java.io.FileWriter;
import java.util.*;

/**
 * @author mikea
 *
 */
public class Sedan extends Vehicle {

	boolean sunRoof;
	
	public Sedan() {
		super();
		this.sunRoof = false;
	}
	
	public Sedan(boolean sun) {
		super();
		this.sunRoof = sun;
	}
	
	public Sedan(int wheels, int doors, String trans, String fuel, String engine,
			double tire, String brand, boolean sun) {
		
		super(wheels, doors, trans, fuel, engine, tire, brand);
		this.sunRoof = sun;
		
	}
	
	@Override
	public String toString() {
		return this.numOfWheels + "," + this.numOfDoors + "," + this.transmission + 
				"," + this.fuelType + "," + this.engineSize + "," + this.tireSize + 
				"," + this.tireBrand + "," + this.sunRoof;
	}

	public static void main(String[] args) {
		/**
		 * Below here is an example of code that can write data to a text file.
		 * we still need to be able to read in data from the text file, in case 
		 * we need to update or delete data.
		 */
		
		ArrayList<String> db = new ArrayList<>();
		
		try {
			//the statement below creates a BufferedReader object that opens my current carDB
			BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\mikea\\Desktop\\carDB"));
			boolean readCont = false;			
			do{
				readCont = false;
				String next = in.readLine();
				if (!Objects.isNull(next)) {
					db.add(next);
					readCont = true;
				}
			}while(readCont);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			for(String s: db)
				System.out.println(s);
		}
		
		/**
		 * the code above creates a BufferedReader object that allows us to read in text from the 
		 * carDB file line by line. Then it prints out to the screen the data we just read in.
		 * 
		 * The data is read in as a single string object, so we need to separate the parts of the 
		 * string into individual parts that we can then store in a Sedan object. This is known
		 * as "Parsing"
		 * 
		 * To parse the data read in, we need to specify what it is that separates the values
		 * in the text. This separator is called a "Delimiter". In my case, I used a comma (,) 
		 * to separate each value I stored in the text file, therefore I will specify the comma 
		 * as a delimiter.
		 * 
		 * to do this, we need to use the split() method in the String class
		 */
		ArrayList<Vehicle> carLot = new ArrayList<>();
		String[] parsedString; 
		for(String s: db) {
			parsedString = s.split(",");
			Vehicle nextCar = new Sedan(Integer.parseInt(parsedString[0]), 
					Integer.parseInt(parsedString[1]),
					parsedString[2], parsedString[3],
					parsedString[4],Double.parseDouble(parsedString[5]),
					parsedString[6],Boolean.parseBoolean(parsedString[7]));
			carLot.add(nextCar);
		}
		
		/**
		 * After we execute the code above, we now have an ArrayList of car objects that 
		 * models the data we read in from our text file. 
		 * 
		 * At this point, out program is getting pretty complicated. If we want to be able to 
		 * search through our car lot, we need to have a way to do that. We do have means of 
		 * updating objects with new data, but we need to have a way to search for that data.
		 * To best do this, we should "refactor", i.e. rewrite, our program to make it a 
		 * CRUD like application (Create Read Update Delete); Let's do this in a new program
		 */
		
		boolean cont = false;
		do {
			cont = false;
			Scanner kb = new Scanner(System.in);
			System.out.println("Get ready to enter car data on a sedan: \n");
			ArrayList<String> userInput = new ArrayList<>();
			boolean sun = false;
			String[] prompts = {"How many wheels does the sedan have?", "How many doors?", 
					"what kind of transmission?", "What fuel does it use?", "Whats the engine size?",
					"What is the tire size?","How about the tire brand?","does the sedan have a sun roof?"};
			for (int i = 0; i < prompts.length; i++) {
				System.out.println(prompts[i]);
				userInput.add(kb.next());
			}
			if (userInput.get(7).equalsIgnoreCase("yes")) {
				sun = true;
			}
			Sedan nextCar = new Sedan(Integer.parseInt(userInput.get(0)), 
										Integer.parseInt(userInput.get(1)),
										userInput.get(2), userInput.get(3),
										userInput.get(4),Double.parseDouble(userInput.get(5)),
										userInput.get(6),sun);
			try {
				BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\mikea\\Desktop\\carDB",true));
				writer.write(nextCar.toString());
				writer.newLine();
				writer.close();
				//writer.write("the text you want to write here");
				//writer.newLine() creates a new line in the text file
				//writer.close() do this when you are finished to actually write the text to the file
			} catch (Exception e) {
				System.out.println(e.toString());
			}
			System.out.println("do you want to continue?(Y/N)");
			if (kb.next().equalsIgnoreCase("y")) {
				cont = true;
			}
		} while (cont);
		
		
	}
}
