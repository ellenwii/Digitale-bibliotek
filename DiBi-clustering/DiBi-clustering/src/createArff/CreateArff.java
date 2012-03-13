package createArff;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.*;

public class createArff {

	public static void main(String[] args) {
		//CreateAttributes.generate(ReadFile("D:/testgit/Digitale-bibliotek/DiBi-clustering/SanFRANCISCOTOTData/SanFRANCISCOTOTData/SanFRANCISCOTOTData/Orig/1289900375947_PART1_Solr.xml").get(1));
		ArrayList<Picture> pictures = new ArrayList<Picture>();
		ArrayList<String> rawObjects = new ArrayList<String>();
		
		
		File dir = new File("D:/testgit/Digitale-bibliotek/DiBi-clustering/DiBi-clustering/TestCase1");
		String[] children = dir.list();
		for(int i = 0; i<children.length;i++){
			rawObjects = ReadFiles.ReadFile("D:/testgit/Digitale-bibliotek/DiBi-clustering/DiBi-clustering/TestCase1/" +children[i]);
//			System.out.println(children[i]);
//			System.out.println(rawObjects.size());
			for (int j = 0; j<rawObjects.size();j++){
				pictures.add(CreateAttributes.generate(rawObjects.get(i)));
			}
		}
		generateArff(pictures);
		
		
	}

	public static void generateArff(ArrayList<Picture> pictures){
		try {
			FileOutputStream initWrite = new FileOutputStream("test.arff");
			initWrite.close();
			FileOutputStream fstream = new FileOutputStream("test.arff", true);
			//BufferedWriter bw = new BufferedWriter(fstream, 500);
			String superTemp= "";
			superTemp+=("\n@RELATION ImageCluster\n");
			superTemp+=("\n@ATTRIBUTE Id		REAL");
			superTemp+=("\n@ATTRIBUTE Type_s	STRING");
			superTemp+=("\n@ATTRIBUTE latitude_s	REAL");
			superTemp+=("\n@ATTRIBUTE longitude_s	REAL");
			superTemp+=("\n@ATTRIBUTE url_s	STRING");
			superTemp+=("\n@ATTRIBUTE user_s	STRING");
			superTemp+=("\n@ATTRIBUTE date_taken	DATE " +'"'+"yyyy-MM-dd'T'HH:mm:ss" +'"');
			superTemp+=("\n@ATTRIBUTE title_s	STRING");
			superTemp+=("\n@ATTRIBUTE attr_tags	STRING");
			superTemp+=("\n\n@DATA\n");
			System.out.println(pictures.size());
			for (int i = 0; i <pictures.size();i++){
				Picture picture = pictures.get(i);
				
				superTemp+=(picture.getId()+",");
				superTemp+=(picture.getType_s()+",");
				superTemp+=(picture.getLatitude_s()+",");
				superTemp+=(picture.getLongitude_s()+",");
				superTemp+=(picture.getUrl_s()+",");
				superTemp+=("'" + picture.getUser_s() + "'"+",");
				superTemp+=(picture.getDate_taken()+",");
				superTemp+=("'" + picture.getTitle_s()+"'"+",");
				ArrayList<String> tempArray = picture.getAttr_tags();
				
				if(tempArray != null){
					superTemp+=("'");
					for (int j=0;j<tempArray.size();j++){
						superTemp+=(" " + tempArray.get(j));
					}
					superTemp+=("'");
				}
				else superTemp+=("?");
				superTemp+=("\n");
				
				byte buf[] = superTemp.getBytes();
				for (int k=0;k<buf.length;k++){
					fstream.write(buf[k]);
					//System.out.println("LoL!");
				}
				superTemp="";

			}
			//superTemp+=("\n%\n%\n%\n");
			System.out.println(superTemp.length());
			
			
			fstream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("Error " + e.getMessage());
		}
	}
}
