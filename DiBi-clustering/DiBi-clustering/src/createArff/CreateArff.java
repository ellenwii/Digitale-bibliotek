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

public class CreateArff {

	@SuppressWarnings("null")
	public static void main(String[] args) {
		
		
		System.out.println("Hello World!");
		
		try{
			FileInputStream fstream = new FileInputStream("D:/testgit/Digitale-bibliotek/DiBi-clustering/SanFRANCISCOTOTData/SanFRANCISCOTOTData/SanFRANCISCOTOTData/Orig/1289900375947_PART1_Solr.xml");
			
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			
			String strLine;
			String tempString="";
			ArrayList<String> objects = new ArrayList<String>();
			while ((strLine = br.readLine()) != null) {
				for (int i = 0; i<=strLine.length();i++){
					tempString+= strLine.charAt(i);
					String endString = "";
					//System.out.println(endString);
					String breakObject = "</doc>";
					if (tempString.length() >7){

						for (int j = tempString.length()-6;j<tempString.length();j++){
							endString+= tempString.charAt(j);

						}
						//System.out.println(endString);
						//System.out.println((endString==breakObject));
					}
					if (endString.equals(breakObject)){
						objects.add(tempString);
						tempString ="";
						System.out.println("Test");

					}
				}
			}
			in.close();
			System.out.println(objects);
		}
		catch (Exception e){
			System.err.println("Error " + e.getMessage());
		}
	}
	
<<<<<<< HEAD

	

=======
>>>>>>> c138d6bb748750503d4b6d0635fd5760252a094e
}
