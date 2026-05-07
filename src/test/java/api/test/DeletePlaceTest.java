package api.test;

import base.BaseTest;
import payload.TestDataBuild;
import resources.APIResources;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;



import static io.restassured.RestAssured.given;

public class DeletePlaceTest extends BaseTest {

	@Test(dependsOnMethods = "api.test.AddPlaceTest.addPlace")
	public void deletePlace(ITestContext context) {
		
		 // ✅ Get place_id inside method (NOT at class level)
        String place_id = (String) context.getAttribute("place_id");

        System.out.println("USING PLACE_ID = " + place_id);

        // 🔥 safety check (important for Jenkins debugging)
        if (place_id == null) {
            throw new RuntimeException("place_id is NULL in UpdatePlaceTest");
        }

	    String response =
	        given()
	            .spec(req)
	            .body(TestDataBuild.deletePlacePayload(place_id))
	        .when()
	            .delete(APIResources.DeletePlaceAPI.getResource())
	        .then()
	            .spec(res)
	            .extract()
	            .jsonPath()
	            .getString("status");

	    Assert.assertEquals(response, "OK");
	}
}