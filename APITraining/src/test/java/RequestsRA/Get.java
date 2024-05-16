package RequestsRA;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;

public class Get {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String response= given().relaxedHTTPSValidation().log().all().queryParam("key", "qaclick123").queryParam("place_id", "aa6d6a04ab1b189aa8a77c5da5ffb805").header("Content-Type", "application/json").when().get("/maps/api/place/get/json").then().log().all().assertThat().statusCode(200).extract().asString();
	    System.out.println(response);
	}

}
