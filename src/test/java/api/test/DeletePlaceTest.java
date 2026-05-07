package api.test;

import base.BaseTest;
import payload.TestDataBuild;
import resources.APIResources;

import org.testng.Assert;
import org.testng.annotations.Test;



import static io.restassured.RestAssured.given;

public class DeletePlaceTest extends BaseTest {

	@Test(dependsOnMethods = "api.test.AddPlaceTest.addPlace")
	public void deletePlace() {

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