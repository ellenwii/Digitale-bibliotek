package createArff;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.sun.xml.internal.stream.util.BufferAllocator;

import weka.core.Attribute;
import weka.core.FastVector;
import weka.core.Instance;
import weka.core.Instances;

public class ReadFiles {

	@SuppressWarnings("null")
	
		
	public static ArrayList<String> ReadFile (String fileName){
		
		try{
			//FileInputStream fstream = new FileInputStream("D:/testgit/Digitale-bibliotek/DiBi-clustering/SanFRANCISCOTOTData/SanFRANCISCOTOTData/SanFRANCISCOTOTData/Orig/1289900375947_PART1_Solr.xml");
			FileInputStream fstream = new FileInputStream(fileName);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			//int counter = 0;
			String strLine;
			String tempString="";
			ArrayList<String> objects = new ArrayList<String>();
			while ((strLine = br.readLine()) != null) {	
				for (int i = 43; i<strLine.length();i++){
					if (strLine.charAt(i)=='\''){						
						continue;
					}
					tempString+= strLine.charAt(i);
					String endString = "";
					//System.out.println(endString);
					String breakObject = "</doc>";
					String end = "</add>";
					if (tempString.length() >7){

						for (int j = tempString.length()-6;j<tempString.length();j++){
							endString+= tempString.charAt(j);

						}
						//System.out.println(endString);
						//System.out.println((endString==breakObject));
					}
				
					if (endString.equals(end)){
						break;
					}
					else if (endString.equals(breakObject)){
						objects.add(tempString);
						//counter++;
						tempString ="";
//						System.out.println("Test" );
//						System.out.println(counter);
					}		
					
				}
			}
			in.close();
			//System.out.println(objects);
			return objects;
		}
		
		catch (Exception e){
			System.err.println("Error " + e.getMessage());
			return null;
		}
		
	}

}
