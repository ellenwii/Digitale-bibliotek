package createArff;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

public class createArff {

	public static void main(String[] args) {
		//CreateAttributes.generate(ReadFile("D:/testgit/Digitale-bibliotek/DiBi-clustering/SanFRANCISCOTOTData/SanFRANCISCOTOTData/SanFRANCISCOTOTData/Orig/1289900375947_PART1_Solr.xml").get(1));
		ArrayList<Picture> pictures = new ArrayList<Picture>();
		ArrayList<String> rawObjects = new ArrayList<String>();
		rawObjects = ReadFiles.ReadFile("D:/testgit/Digitale-bibliotek/DiBi-clustering/SanFRANCISCOTOTData/SanFRANCISCOTOTData/SanFRANCISCOTOTData/Orig/1289900375947_PART1_Solr.xml");
		for (int i = 0; i<rawObjects.size();i++){
			pictures.add(CreateAttributes.generate(rawObjects.get(i)));
		}
		generateArff(pictures);
		
		
	}
	public static void generateArff(ArrayList<Picture> pictures){
		try {
			Writer fstream = new FileWriter("test.arff");
			BufferedWriter bw = new BufferedWriter(fstream, 500);
			bw.write("\n@RELATION ImageCluster\n");
			bw.write("\n@ATTRIBUTE Id		REAL");
			bw.write("\n@ATTRIBUTE Type_s	STRING");
			bw.write("\n@ATTRIBUTE latitude_s	REAL");
			bw.write("\n@ATTRIBUTE longitude_s	REAL");
			bw.write("\n@ATTRIBUTE url_s	STRING");
			bw.write("\n@ATTRIBUTE user_s	STRING");
			bw.write("\n@ATTRIBUTE date_taken	DATE " +'"'+"yyyy-MM-dd'T'HH:mm:ss" +'"');
			bw.write("\n@ATTRIBUTE title_s	STRING");
			bw.write("\n@ATTRIBUTE attr_tags	STRING");
			bw.write("\n\n@DATA\n");
			System.out.println(pictures.size());
			for (int i = 0; i <pictures.size();i++){
				Picture picture = pictures.get(i);
				
				bw.write(picture.getId()+",");
				bw.write(picture.getType_s()+",");
				bw.write(picture.getLatitude_s()+",");
				bw.write(picture.getLongitude_s()+",");
				bw.write(picture.getUrl_s()+",");
				bw.write("'" + picture.getUser_s() + "'"+",");
				bw.write(picture.getDate_taken()+",");
				bw.write("'" + picture.getTitle_s()+"'"+",");
				ArrayList<String> tempArray = picture.getAttr_tags();
				
				if(tempArray != null){
					bw.write("'");
					for (int j=0;j<tempArray.size();j++){
						bw.write(" " + tempArray.get(j));
					}
					bw.write("'");
				}
				else bw.write("?");
				bw.write("\n");
				

			}
			bw.write("\n%\n%\n%\n");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("Error " + e.getMessage());
		}
	}
}
