import java.io.File;
import java.util.Scanner;
import java.util.ArrayList; 
import java.util.Collections; 
import java.io.*;

public class Main
{
	public static void main(String[] args) 
	{ 
		Map<String, ArrayList<String>> map = new Map<>(); 
        ArrayList<String> all = new ArrayList<>();
    	Scanner input = new Scanner(System.in);
    	String strLine = "";
        // Open the File which contains data
    	try {
            BufferedReader br = new BufferedReader(new FileReader("../file/data.txt"));
            while (strLine != null)
            {
                //Read data line by line 
                	strLine = br.readLine();
                    if(strLine != null){
                    	String[] data = strLine.split(":",2);
                        
                        // Slice data and store into hash map
		                if(map.get(data[0]) == null) //if data doesn't exist yet, store into new hash element
		                {
		                	ArrayList<String> temp =  new ArrayList<>();
		                	temp.add(data[1]);
		                	map.add(data[0], temp);
                            all.add(data[0]);
		                }
		                else{ //if data exist, append the existing hash element
		                	map.get(data[0]).add(data[1]);
		                }
                    }
            }
             br.close();

             // Handling the exception
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (IOException e) {
            System.err.println("Unable to read the file.");
        }

        // if argument is 'show',  print all value in HTML table format
        if(args[0].equals("show")){
            Collections.sort(all);
            System.out.println("<table class='table'>");
            System.out.println("<tr><th>No</th>");
            System.out.println("<th>Nama Editor </th>");
            System.out.println("<th>Jumlah Artikel </th></tr>");
            
            for(int i =0; i<all.size(); i++){
                ArrayList<String> e = map.get(all.get(i));
                System.out.println("<tr><td>"+(i+1)+"</td>");
                System.out.println("<td>"+all.get(i)+"</td>");
                System.out.println("<td>"+e.size()+"</td></tr>");
            }
            System.out.println("</table>");
        
        //if argument was not 'show', so that was an editor name then get its data from hash
        // and print into HTML format
        }else{
             ArrayList<String> result = map.get(args[0]);
             if(result != null) //if data found print it 
            {
                Collections.sort(result);
                System.out.println("<h5 class='mb-3'>Daftar artikel dengan editor "+args[0]+" </h5>");
                System.out.print("<ul class='list-group'>");
                result.forEach((e)->System.out.print("<li class='list-group-item list-group-item-action'>"+e+"</li>"));
                System.out.print("</ul>");
            }
            else // status: 404
            {
                System.out.println("Data For "+args[0]+" Not Found");
            }
        }
	}  
}   