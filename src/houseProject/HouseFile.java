package houseProject;


import java.io.*;


import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class HouseFile {

	private static BufferedReader readingFile;
	private static PrintWriter writingFile;
	private static boolean isReadingOpen = false;
	private static boolean isWritingOpen = false;
	
	public static void prepareToRead (){
		try {
			if (isReadingOpen)
				readingFile.close();
			if (isWritingOpen)
				writingFile.close();
			readingFile = new BufferedReader(new FileReader("houses.ray"));
			isReadingOpen = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void prepareToWrite(){
		try {
			if (isReadingOpen)
				readingFile.close();
			if (isWritingOpen)
				writingFile.close();
			writingFile = new PrintWriter(new FileWriter("houses.ray"));
			isWritingOpen = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static ListHouse getNextHouse(){
		
		try {
			JSONObject house;
			JSONParser parser = new JSONParser();
			String read = readingFile.readLine();
			
			if(read == ""){
				return null;
			}
			
			house = (JSONObject) parser.parse(read);
			
			ListHouse nextHouse = new ListHouse(house);
			
			return nextHouse;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	
	public static void write(ListHouse house){
		try {
			
			JSONObject theHouse = house.getHouse();
			
			StringWriter out = new StringWriter();
			theHouse.writeJSONString(out);
			
			writingFile.println(out.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void close(){
		try {
			if (isReadingOpen)
				readingFile.close();
			if (isWritingOpen)
				writingFile.close();
			isWritingOpen = false;
			isReadingOpen = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}