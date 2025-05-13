package stepDefinitions;

import java.io.IOException;
import java.net.MalformedURLException;

import io.cucumber.java.Before;

public class Hooks {
	
	@Before("@Deleteplace")
	public void beforedeleteAPi() throws MalformedURLException, IOException {
		//if placeid is null only below code should be executed otherwise the e2e scenaris is useful
		// This hooks method is used to execute only the deleteplaceAPi directly
		// To execute directly the deleteAPi we needed the place id which is taken with the below code
		if(StepDefinitionsclass.Addplaceid==null) {
		StepDefinitionsclass sd = new StepDefinitionsclass();
		sd.add_the_addplaceapi_payload("Ashwin", "Mumbai", "French");
		sd.the_user_calls_the_with_httprequest("AddPlaceAPI", "post");
		sd.verify_the_place_id_added_matches_in_the("Ashwin", "GetPlaceAPI");
		
	}
}

}
