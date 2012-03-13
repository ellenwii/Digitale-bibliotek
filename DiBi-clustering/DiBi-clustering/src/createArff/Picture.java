package createArff;

import java.sql.Date;
import java.util.ArrayList;

public class Picture {

	private long 	id;
	private String 	type_s;
	private double 	latitude_s;
	private double 	longitude_s;
	private String 	url_s;
	private String 	user_s;
	private String 	date_taken;
	private String 	title_s;
	private ArrayList<String> attr_tags = new ArrayList<String>();
	
	public Picture(){
		
	}
	public Picture(long id, String type_s, double latitude_s, double longitude_s, String url_s, String user_s, String date_taken, String title_s, ArrayList<String> attr_tags){
		setId(id);
		setType_s(type_s);
		setLatitude_s(latitude_s);
		setLongitude_s(longitude_s);
		setUrl_s(url_s);
		setUser_s(user_s);
		String tempString = "";
		for (int i = 0; i<date_taken.length()-1;i++){
			tempString += date_taken.charAt(i);
		}
		setDate_taken(tempString);
		setTitle_s(title_s);
		setAttr_tags(attr_tags);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getType_s() {
		return type_s;
	}

	public void setType_s(String type_s) {
		this.type_s = type_s;
	}

	public double getLatitude_s() {
		return latitude_s;
	}

	public void setLatitude_s(double latitude_s) {
		this.latitude_s = latitude_s;
	}

	public double getLongitude_s() {
		return longitude_s;
	}

	public void setLongitude_s(double longitude_s) {
		this.longitude_s = longitude_s;
	}

	public String getUrl_s() {
		return url_s;
	}

	public void setUrl_s(String url_s) {
		this.url_s = url_s;
	}

	public String getUser_s() {
		return user_s;
	}

	public void setUser_s(String user_s) {
		this.user_s = user_s;
	}

	public String getDate_taken() {
		return date_taken;
	}

	public void setDate_taken(String date_taken) {
		this.date_taken = date_taken;
	}

	public String getTitle_s() {
		return title_s;
	}

	public void setTitle_s(String title_s) {
		this.title_s = title_s;
	}

	public ArrayList<String> getAttr_tags() {
		return attr_tags;
	}

	public void setAttr_tags(ArrayList<String> attr_tags) {
		this.attr_tags = attr_tags;
	}
	
}
