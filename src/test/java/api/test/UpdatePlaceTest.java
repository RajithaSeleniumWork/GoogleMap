package api.test;

import base.BaseTest;
import payload.TestDataBuild;
import resources.APIResources;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UpdatePlaceTest extends BaseTest {

    @Test(dependsOnMethods = "api.test.AddPlaceTest.addPlace")
    public void updatePlace(ITestContext context) {

        // ✅ Get place_id inside method (NOT at class level)
        String place_id = (String) context.getAttribute("place_id");

        System.out.println("USING PLACE_ID = " + place_id);

        // 🔥 safety check (important for Jenkins debugging)
        if (place_id == null) {
            throw new RuntimeException("place_id is NULL in UpdatePlaceTest");
        }

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