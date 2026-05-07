package api.test;

import base.BaseTest;
import resources.APIResources;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class GetPlaceTest extends BaseTest {

	@Test
	public void getPlace(ITestContext context) {

	    String place_id = (String) context.getAttribute("place_id");

	    System.out.println("GET USING PLACE_ID = " + place_id);

	    // 🔥 safety check
	    if (place_id == null) {
	        throw new RuntimeException("place_id is NULL in GetPlaceTest");
	    }

	    given()
	            .spec(req)
	            .queryParam("place_id", place_id)
	    .when()
	            .get(APIResources.GetPlaceAPI.getResource())
	    .then()
	            .spec(res)
	            .statusCode(200);
	}
}