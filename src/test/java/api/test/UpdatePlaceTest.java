package api.test;

import base.BaseTest;
import payload.TestDataBuild;
import resources.APIResources;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class UpdatePlaceTest extends BaseTest {
	
	@Test(dependsOnMethods = "api.test.AddPlaceTest.addPlace")
	public void updatePlace() {

	    given()
	        .spec(req)
	        .body(TestDataBuild.updatePlacePayload(place_id))
	    .when()
	        .put(APIResources.UpdatePlaceAPI.getResource())
	    .then()
	        .spec(res)
	        .statusCode(200);
	}
}