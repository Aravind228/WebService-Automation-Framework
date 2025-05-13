package testresources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class Util {
	 
	public static RequestSpecification reqs;
	public RequestSpecification Requestspecload() throws IOException,MalformedURLException {
	if(reqs==null) {	
	PrintStream stream = new PrintStream(new FileOutputStream("logging.text"));
	RestAssured.baseURI="https://rahulshettyacademy.com";
	reqs=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").
				setContentType(ContentType.JSON).addQueryParam("key","qaclick123").
				addFilter(RequestLoggingFilter.logRequestTo(stream)).
				/*addFilter(ResponseLoggingFilter.logResponseTo(stream)).*/
				build();
	return reqs;
	
	}
	return reqs;
	}
	public String getglobalvalues(String key) throws IOException,MalformedURLException {
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Program Files\\eclipse\\selenium projects\\mavenclass\\Testng_2020\\API_RestAssured_Framework\\src\\test\\java\\testresources\\file.properties");
		prop.load(fis);
		return prop.getProperty(key);
		
		
	}
	
	public Object getJsonvalue(Response response,String value) {
		Object obj=null;
		try {
		String json_body= response.asString();
		JsonPath json = new JsonPath(json_body);
		obj=json.get(value);
		return obj;
		
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	return obj;
	
	

}
}
