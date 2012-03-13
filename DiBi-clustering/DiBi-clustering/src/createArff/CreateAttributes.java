package createArff;

import java.util.ArrayList;

public class CreateAttributes {

//	public static void main(String[] args) {
//		System.out.println("Hello World!");
//		
//	}
	
	public static Picture generate(String object){
		Picture picture = new Picture();
		String tempString = "";
		
		long 	id;
		String 	type_s;
		double 	latitude_s;
		double 	longitude_s;
		String 	url_s;
		String 	user_s;
		String 	date_taken;
		String 	title_s;
		ArrayList<String> attr_tags = new ArrayList<String>();
		
		ArrayList<String> rawString = new ArrayList<String>();
		int counter = 0;
//		System.out.println(object.length());
		for (int i = 0;i<object.length(); i++){
			if (object.charAt(i)== '"'){
				counter++;
			}
			if (counter == 2){
				i+=2;
				while(object.charAt(i)!='<'){
					
					tempString += object.charAt(i);
					i++;
				}
				rawString.add(tempString);
				tempString = "";
				counter = 0;
			}
		}
//		System.out.println("size of ");
//		System.out.println("size of rawString = " + rawString.size());
		picture.setId(Long.parseLong(rawString.get(0)));
		picture.setType_s(rawString.get(1));
		picture.setLatitude_s(Double.parseDouble(rawString.get(2)));
		picture.setLongitude_s(Double.parseDouble(rawString.get(3)));
		picture.setUrl_s(rawString.get(4));
		picture.setUser_s(rawString.get(5));
		String tempDate = "";
		for (int i = 0; i<rawString.get(6).length()-1;i++){
			tempDate += rawString.get(6).charAt(i);
		}
		picture.setDate_taken(tempDate);
		picture.setTitle_s(rawString.get(7));
//		System.out.println("Kom hit!");
		if (rawString.size()>8){
			for(int j = 8;j<rawString.size();j++){
				attr_tags.add(rawString.get(j));
			}
			picture.setAttr_tags(attr_tags);
		}
		else picture.setAttr_tags(null);
		//System.out.println("HJELP!");
		
		return picture;
	}
}
