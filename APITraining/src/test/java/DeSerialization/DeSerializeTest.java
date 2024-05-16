package DeSerialization;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import Serialization.AddPlace;
import Serialization.Location;
import io.restassured.RestAssured;

public class DeSerializeTest {

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
		GetResponse response = given().relaxedHTTPSValidation().log().all().queryParam("key", "qaclick").body(ap).when().post("/maps/api/place/add/json")
				.as(GetResponse.class);
		
		System.out.println(response.getPlace_id());
		System.out.println(response.getStatus());
		System.out.println(response.getReference());
		System.out.println(response.getScope());
		System.out.println(response.getId());

		
		
	}

	

}
