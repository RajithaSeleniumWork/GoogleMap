package api.test;

import base.BaseTest;
import io.restassured.response.Response;
import payload.TestDataBuild;
import resources.APIResources;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class AddPlaceTest extends BaseTest {

	@Test
	public void addPlace(ITestContext context) {

	    Response response =
	            given()
	                    .spec(req)
	                    .body(TestDataBuild.addPlacePayload())
	            .when()
	                    .post(APIResources.AddPlaceAPI.getResource())
	            .then()
	                    .spec(res)
	                    .statusCode(200)
	                    .extract()
	                    .response();

	    String place_id = response.jsonPath().getString("place_id");

	    context.setAttribute("place_id", place_id);

	    System.out.println("PLACE ID CREATED: " + place_id);
	}
}