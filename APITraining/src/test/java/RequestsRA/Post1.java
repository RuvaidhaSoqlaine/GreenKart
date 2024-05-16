package RequestsRA;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class Post1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String response= given().relaxedHTTPSValidation().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json").body(PayLoad.Postt()).when().post("/maps/api/place/add/json").then().log().all().assertThat().statusCode(200).extract().asString();
	    System.out.println(response);
	    JsonPath js=new JsonPath(response);
	    System.out.println(js.get("place_id"));
	    System.out.println(js.get("reference"));
	}
	}


