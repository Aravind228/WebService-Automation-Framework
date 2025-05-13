package resources;

import java.util.ArrayList;
import java.util.List;
import pojoclasses.Location;
import pojoclasses.Mainjson;

public class Testdata {
	
	
	Mainjson mc;
	List<String> mc2;
	Location loc;
	
	public Mainjson Addplace_payload(String name,String address,String language) {
		
		mc2 = new ArrayList<String>();
		mc2.add("shoe park");
		mc2.add("shop");
		
		loc = new Location();
		loc.setLat(-38.383494);
		loc.setLng(33.427362);
		
		mc = new Mainjson();
		mc.setAccuracy(50);
		mc.setName(name);
		mc.setPhone_number("(+91) 983 893 3937");
		mc.setAddress(address);
		mc.setWebsite("http://google.com");
		mc.setLanguage(language);
		mc.setTypes(mc2);
		mc.setLocation(loc);
		return mc;
		
	}
	
	public String deletepayload(Object placeid) {
		return "{\r\n" + 
				"    \"place_id\": \""+placeid+"\"   \r\n" + 
				"}";
	}

}
