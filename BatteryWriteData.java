package Code;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.json.simple.JSONObject;

public class BatteryWriteData {

	public static void main(String[] args) throws IOException 
	{
		 File fr=new File("C:\\Users\\DEBADRITA\\eclipse-workspace\\Mock\\Battery.txt");    
         
		 Scanner sc=new Scanner(fr);
		 
		 String current,drain="";
		 double percent=0.0;
		 String percentage="";
	       	
		 JSONObject obj = new JSONObject();
		 String foreground[]=new String[10];
		 
		 while (sc.hasNext()) 
		 {
		      current = sc.nextLine();	// takes every line
		      if(current.startsWith("    Uid u0a202:"))
		      {
		    	  drain=current.substring(16,22);
		    	  percent=Double.parseDouble(drain)/1000.0;
		    	  percentage=String.format("%.3f",percent);
		    	  System.out.println("\"Battery_percentage\":"+percentage);
		    	  System.out.println("\"Battery_drain\":"+drain);
		    	  
		      }
		      if(current.startsWith("    Foreground"))
		      {
		    	  foreground=current.split(":");
		    	  System.out.println("\"Foreground_time\":"+foreground[1]);
		      }
		 }
		 
		 
		 obj.put("Foreground_time:",foreground[1]);
		 obj.put("Battery_percentage:",percentage);
		 obj.put("Battery_drain:",drain);
		 
		 try (FileWriter file = new FileWriter("C:\\Users\\DEBADRITA\\eclipse-workspace\\Mock\\UseCase2.json"))
    	 {
 			//File Writer creates a file in write mode at the given location 
 			file.write(obj.toString());

 			//write function is use to write in file,
 			//here we write the Json object in the file
 			file.flush();

 		}
 		catch (IOException e) {
 			e.printStackTrace();
 		}
	}
}
