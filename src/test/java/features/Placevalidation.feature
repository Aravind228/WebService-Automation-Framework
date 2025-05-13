Feature: Validating place API'S

@Addplace
Scenario Outline: Verify whether the user able to add the place using addplace api's

		Given Add the addplaceapi payload "<name>" "<address>" "<language>"
		When the user calls the "AddPlaceAPI" with "post" httprequest
		Then the "status code" should be returned as 200
		And "status" in response body is "OK"
		And "scope" in response body is "APP"
		And Verify the place_id added matches "<name>" in the "GetPlaceAPI"
		
Examples:
		| name | address | language |
		| Surya | chennai |  tamil   | 
		| Vikram | newyork |  english | 


@Deleteplace	
Scenario: Verify whether the delete API Functionality is working		
		
		Given DeletePlace Payload
		When the user calls the "deletePlaceAPI" with "post" httprequest
		Then the "status code" should be returned as 200
		And "status" in response body is "OK" 