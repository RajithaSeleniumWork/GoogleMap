package base;

import org.testng.annotations.BeforeClass;

import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import specBuilder.RequestSpec;
import specBuilder.ResponseSpec;

public class BaseTest {

	public static RequestSpecification req;
    public static ResponseSpecification res;

    @BeforeClass
    public void setup() {

        req = RequestSpec.getRequestSpec();
        res = ResponseSpec.getResponseSpec();
    }

    public static String place_id;   // ✅ must be static
}