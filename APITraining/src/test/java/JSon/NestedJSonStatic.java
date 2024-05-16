package JSon;

import io.restassured.path.json.JsonPath;
import junit.framework.Assert;

public class NestedJSonStatic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		JsonPath js = new JsonPath(PayLoad.getCourse());

		// Print No of courses returned by API
		int courseSize = js.getInt("courses.size()");
		System.out.println(courseSize);

		// Print Purchase Amount
		int purchaseAmount = js.getInt("dashboard.purchaseAmount");
		System.out.println(purchaseAmount);

		// Print Title of the first course
		String firstcourse = js.getString("courses[0].title");
		System.out.println(firstcourse);

		// Print All course titles and their respective Prices
		for (int i = 0; i < courseSize; i++) {
			String course = js.getString("courses[" + i + "].title");
			System.out.println(course);
			int price = js.getInt("courses[" + i + "].price");
			System.out.println(price);
		}

		// Print no of copies sold by RPA Course
		for (int j = 0; j < courseSize; j++) {
			String courseName = js.getString("courses[" + j + "].title");
			if (courseName.equalsIgnoreCase("RPA")) {
				int copiesCount = js.getInt("courses[" + j + "].copies");
				System.out.println(copiesCount);
			}
		}

		// Verify if Sum of all Course prices matches with Purchase Amount
		int sum = 0;
		for (int i = 0; i < courseSize; i++) {
			int price = js.getInt("courses[" + i + "].price");
			int copies = js.getInt("courses[" + i + "].copies");
			sum = sum + (price * copies);
		}
		System.out.println(sum);
		if (sum == purchaseAmount) {
			System.out.println("The purchase amount is same as sum");
		}
		Assert.assertEquals(purchaseAmount, sum);
	}

}
