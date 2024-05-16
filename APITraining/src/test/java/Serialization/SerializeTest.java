package Serialization;

import java.util.ArrayList;
import java.util.List;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;

public class SerializeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		RestAssured.baseURI = "https://rahulshettyacademy.com";
		AddPlace ap = new AddPlace();
		ap.setAccuracy(50);
		ap.setLanguage("French-IN");
		ap.setName("Frontline house");
		ap.setPhone_number("(+91) 983 893 3937");
		ap.setWebsite("http://google.com");
		ap.setAddress("29, side layout, cohen 09");
		List<String> myList = new ArrayList<String>();
		myList.add("shoe park");
		myList.add("shop");
		ap.setTypes(myList);
		Location l = new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		ap.setLocation(l);
		String response = given().relaxedHTTPSValidation().log().all().queryParam("key", "qaclick").body(ap).when().post("/maps/api/place/add/json")
				.then().log().all()
				.assertThat().statusCode(200).extract().response().asString();
		System.out.println(response);
	}

}
