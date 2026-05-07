package api.test;

import base.BaseTest;
import resources.APIResources;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetPlaceTest extends BaseTest {

	@Test(dependsOnMethods = "api.test.AddPlaceTest.addPlace")
	public void getPlace() {

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