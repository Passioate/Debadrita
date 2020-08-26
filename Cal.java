package Code;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Cal {

	public static void main(String[] args) throws IOException 
	{
		 File fr=new File("C:\\Users\DEBADRITA\\eclipse-workspace\\Mock\\Memory.txt");    
         
		 int count=0; // Counts the no. of lines in text file
		 float max=0;
         
		 Scanner sc=new Scanner(fr);
		 
         ArrayList<String> data = new ArrayList<String>();
         
         JSONObject obj = new JSONObject();
         obj.put("Usecasename:","\"Homepage\"");
         
         while(sc.hasNextLine())
         {
        	data.add(sc.nextLine());
        	 count++;
         }
         
         int i=1;
         float sum=0;
         
         String serial="";
        
         for(int x=1;x<data.size();x=x+2)
         {
        	 
        	 String str=data.get(x).substring(24,31);
        	 
        	 serial=Integer.toString(i)+"s";
        	 i++;
        	 
        	 //Converting he string into float
        	 float f=Float.parseFloat(str);
        	 f=f/1024;		//Converting to KB
        	 
        	 System.out.println("\""+(i-1)+"s\":"+f);
        	 
        	 obj.put(serial,Float.toString(f));
        	 
        	 sum=sum+f;		//Calculating sum
        	 
        	 if(f>max)
        		 max=f;
        	
         }				// End of for loop
         
         float avg=sum/i;	// Calculating average
         
         obj.put("AverageMemory(KB):",Float.toString(avg));
         obj.put("MaxMemory(KB):",Float.toString(max));
         
         //Writing in JSON
         
         try (FileWriter file = new FileWriter("C:\\Users\\DEBADRITA\\eclipse-workspace\\Mock\\output.json"))
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

         System.out.println("AverageMemory(KB):"+avg);
         System.out.println("MaxMemory(KB):"+max);
		
	}

}