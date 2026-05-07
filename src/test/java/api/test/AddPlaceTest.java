package api.test;

import base.BaseTest;

import io.restassured.response.Response;
import payload.TestDataBuild;
import resources.APIResources;

import org.testng.annotations.Test;


import static io.restassured.RestAssured.given;

public class AddPlaceTest extends BaseTest {

    

	@Test
	public void addPlace() {

	    Response response =
	        given()
	            .spec(req)
	            .body(TestDataBuild.addPlacePayload())
	        .when()
	            .post(APIResources.AddPlaceAPI.getResource())
	        .then()
	            .spec(res)
	            .extract().response();

	    place_id = response.jsonPath().getString("place_id");
	}
}