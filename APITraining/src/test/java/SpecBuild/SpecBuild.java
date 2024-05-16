package SpecBuild;

import java.util.ArrayList;
import java.util.List;
import static io.restassured.RestAssured.*;
import Serialization.AddPlace;
import Serialization.Location;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecBuild {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		
		RequestSpecification req= new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.addQueryParam("key", "qaclick123").setContentType(ContentType.JSON).build();
		
		RequestSpecification response= given().relaxedHTTPSValidation().spec(req).body(ap);
		
		ResponseSpecification resspec= new ResponseSpecBuilder().expectStatusCode(200)
				.expectContentType(ContentType.JSON).build();
		
		Response res= response.when().post("/maps/api/place/add/json").then().log().all().spec(resspec).extract().response();
		
		String responseString =res.asString();
		System.out.println(responseString);
	}

}
