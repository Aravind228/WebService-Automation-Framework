package stepDefinitions;

import static io.restassured.RestAssured.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojoclasses.Location;
import pojoclasses.Mainjson;
import resources.Testdata;
import testresources.EnumConstants;
import testresources.Util;




public class StepDefinitionsclass extends Util {
	
	RequestSpecification req;
	Mainjson mc;
	Response response;
	List<String> mc2;
	Location loc;
	Testdata obj= new Testdata();
	Util util;
	static Object Addplaceid;
	
	//*************************API1 Add place API*******************
	
	@Given("Add the addplaceapi payload {string} {string} {string}")
	public void add_the_addplaceapi_payload(String name, String location, String language) throws MalformedURLException, IOException {
		/*reqs=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").build();*/
		req=given().spec(Requestspecload())
		.body(obj.Addplace_payload(name,location,language));
	}
	@When("the user calls the {string} with {string} httprequest")
	public void the_user_calls_the_with_httprequest(String resource, String RequestTyoe) throws FileNotFoundException {
		/*ResponseSpecification respec=new ResponseSpecBuilder().expectStatusCode(200).expectBody("scope", equalTo("APP")).
				build();*/
		
		EnumConstants enumobj=EnumConstants.valueOf(resource);
		String resources=enumobj.getresources();
		System.out.println(resource);
		if(RequestTyoe.equalsIgnoreCase("post"))
		response=req.when().post(resources)
		.then().log().all().extract().response();
		else if(RequestTyoe.equalsIgnoreCase("get"))
		response=req.when().get(resources)
		.then().log().all().extract().response();
		else if(RequestTyoe.equalsIgnoreCase("delete"))
		response=req.when().delete(resources)
		.then().log().all().extract().response();
		else if(RequestTyoe.equalsIgnoreCase("update"))
		response=req.when().put(resources)
		.then().log().all().extract().response();
		
	}
	@Then("the {string} should be returned as {int}")
	public void the_should_be_returned_as(String string, Integer int1) {
	   assertEquals(response.getStatusCode(),200);
	}
	@Then("{string} in response body is {string}")
	public void in_response_body_is(String Actual_key, String Expected_value) {
	    /*String res=response.asString();
	    JsonPath json = new JsonPath(res);
	   String resp= json.getString(key);*/
	   assertEquals(Expected_value, getJsonvalue(response, Actual_key));
	}
	
	//*************************Get place API*********************************************
	//Verify the "place_id" added matches with the place in the "GetPlaceAPI"
	@Then("Verify the place_id added matches {string} in the {string}")
	public void verify_the_place_id_added_matches_in_the(String ExpectedPlacename, String resource) throws MalformedURLException, IOException {
		Addplaceid=getJsonvalue(response, "place_id");
		req=given().spec(Requestspecload()).queryParam("place_id", Addplaceid);
		the_user_calls_the_with_httprequest(resource,"get");
		Object Getplace_name=getJsonvalue(response, "name");
		assertEquals(Getplace_name, ExpectedPlacename);
		
	}
	
	//*************************Delete place API*********************************************
	@Given("DeletePlace Payload")
	public void delete_place_payload() throws MalformedURLException, IOException {
		req=given().spec(Requestspecload())
			.body(obj.deletepayload(Addplaceid));
		
			
	}
	

}
