package apitesting.LibMS.base;

import apitesting.LibMS.utils.APIConfig;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class AbstractAPITest {
    protected String baseUrl;

    @BeforeAll
    public void setUp() {
        baseUrl = APIConfig.BASE_URI;
        RestAssured.baseURI = baseUrl;
        System.out.println("Base URL set up: " + baseUrl);
    }
}