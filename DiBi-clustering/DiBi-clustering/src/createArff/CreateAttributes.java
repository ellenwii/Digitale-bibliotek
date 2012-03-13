package createArff;

import java.util.ArrayList;

public class CreateAttributes {

//	public static void main(String[] args) {
//		System.out.println("Hello World!");
//		
//	}
	
	public static void generate(String object){
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
		
		for (int i = 0;i<object.length(); i++){
			if (object.charAt(i)== '"'){
				counter++;
			}
			if (counter == 2){
				i++;
				while(object.charAt(i)!='<'){
					
					tempString += object.charAt(i);
					i++;
				}
				rawString.add(tempString);
				tempString = "";
				counter = 0;
			}
		
			System.out.println(rawString.size());
		}
	}
}
