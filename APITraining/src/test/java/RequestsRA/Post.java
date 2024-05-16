package RequestsRA;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
public class Post {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
RestAssured.baseURI="https://rahulshettyacademy.com";
String response= given().relaxedHTTPSValidation().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json").body("{ \r\n"
		+ "\r\n"
		+ "  \"location\": { \r\n"
		+ "\r\n"
		+ "    \"lat\": -38.383494, \r\n"      
		+ "\r\n"
		+ "    \"lng\": 33.427362 \r\n"
		+ "\r\n"
		+ "  }, \r\n"
		+ "\r\n"
		+ "  \"accuracy\": 50, \r\n"
		+ "\r\n"
		+ "  \"name\": \"Frontline house\", \r\n"
		+ "\r\n"
		+ "  \"phone_number\": \"(+91) 983 893 3937\", \r\n"
		+ "\r\n"
		+ "  \"address\": \"29, side layout, cohen 09\", \r\n"
		+ "\r\n"
		+ "  \"types\": [ \r\n"
		+ "\r\n"
		+ "    \"shoe park\", \r\n"
		+ "\r\n"
		+ "    \"shop\" \r\n"
		+ "\r\n"
		+ "  ], \r\n"
		+ "\r\n"
		+ "  \"website\": \"http://google.com\", \r\n"
		+ "\r\n"
		+ "  \"language\": \"French-IN\" \r\n"
		+ "\r\n"
		+ "} ").when().post("/maps/api/place/add/json").then().log().all().assertThat().statusCode(200).extract().asString();
	}

}

