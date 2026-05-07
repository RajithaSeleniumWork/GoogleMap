package api.test;

import base.BaseTest;
import resources.APIResources;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetPlaceTest extends BaseTest {

	@Test(dependsOnMethods = "api.test.AddPlaceTest.addPlace")
	public void getPlace(ITestContext context) {
		
		 // ✅ Get place_id inside method (NOT at class level)
        String place_id = (String) context.getAttribute("place_id");

        System.out.println("USING PLACE_ID = " + place_id);

        // 🔥 safety check (important for Jenkins debugging)
        if (place_id == null) {
            throw new RuntimeException("place_id is NULL in UpdatePlaceTest");
        }

	    given()
	        .spec(req)
	        .queryParam("place_id", place_id)
	    .when()
	        .get(APIResources.GetPlaceAPI.getResource())
	    .then()
	        .spec(res)
	        .statusCode(200)
	        .body("address", equalTo("India"));
	}
}