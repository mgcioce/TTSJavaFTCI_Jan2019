/**
 * 
 */
package model;
import java.util.*;
import java.io.*;
/**
 * @author mikea
 *
 */
public class Database {
	
	private final static String DATABASE = "studentDB.txt";
	private HashMap<String,StudentModel> db;
	private BufferedReader reader;
	private BufferedWriter writer;
	public Database() {
		try {
			reader = new BufferedReader(new FileReader(Database.DATABASE));
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		db = new HashMap<>();
		readInDatabase(this.db,this.reader);
	}
	
	private void readInDatabase(HashMap<String, StudentModel> hashmap, BufferedReader br) {
		try {
			boolean cont;
			do {
				cont = false;
				String nextLine = br.readLine();
				if (!Objects.isNull(nextLine)) {
					StudentModel nextRecord = createObject(nextLine);
					UUID id = nextRecord.getStudentID();
					hashmap.put(id.toString(),nextRecord);
					cont = true;
				}
			} while(cont);
			br.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	private StudentModel createObject(String next) {
		String[] data = next.split(",");
		return new StudentModel(data[0],data[1],data[2]);
	}
	
	public void create(String first, String last) {
		StudentModel sm = new StudentModel(first,last);
		UUID id = sm.getStudentID();
		this.db.put(id.toString(), sm);
	}
	
	public void delete(String id) {
		this.db.put(id,null);
	}
	
	public void update(String id, String first, String last) {
		StudentModel sm = this.db.get(id);
		sm.setFirstName(first);
		sm.setLastName(last);
	}
	
	public ArrayList<String> read() {
		Set<Map.Entry<String, StudentModel>> hashSet = this.db.entrySet();
		ArrayList<String> records = new ArrayList<>();
		for (Map.Entry<String, StudentModel> e: hashSet) {
			StudentModel nextStudent = e.getValue();
			records.add(nextStudent.toString());
		}
		return records;
	}
	
	public String read(String id) {
		StudentModel sm = this.db.get(id);
		return sm.toString();
	}
	
	public void close() {
		try {
			this.writer = new BufferedWriter(new FileWriter(Database.DATABASE,false));
			Set<Map.Entry<String, StudentModel>> records = this.db.entrySet();
			for (Map.Entry<String, StudentModel> e: records) {
				StudentModel nextStudent = e.getValue();
				String studentRecord = nextStudent.toString();
				writer.write(studentRecord);
				writer.newLine();
			}
			writer.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}		
	}
	/**
	 * Databases need to create, read, update, and delete.
	 */
}
