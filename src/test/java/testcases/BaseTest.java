package testcases;

import api.AuthBuilder;
import api.ListingsApi;
import api.SellingApi;
import assertions.ListingsAssertion;
import assertions.SellingAssertion;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import utils.JsonUtils;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class BaseTest {

    static final String ENVPATH = "src/test/resources/env.json";
    protected Response response;

    //apis
    protected ListingsApi listingsApi = new ListingsApi();
    protected SellingApi sellingApi = new SellingApi();

    //assertions
    protected ListingsAssertion listingsAssert = new ListingsAssertion();
    protected SellingAssertion sellingAssertion = new SellingAssertion();

    @BeforeAll
    static void globalSetup() throws Exception {
        //parse env.json
        Map<String, Object> envMap = JsonUtils.readJsonFile(ENVPATH);
        Map<String, String> authCred =  (Map<String, String>)envMap.get("oauth_creds");
        AuthBuilder authBuilder = AuthBuilder.builder()
                .consumer_key(authCred.get("oauth_consumer_key"))
                .token(authCred.get("oauth_token"))
                .signature_method(authCred.get("oauth_signature_method"))
                .signature(authCred.get("oauth_signature"))
                .build();

        //setup request
        RestAssured.baseURI = (String) envMap.get("baseURL");
        RestAssured.requestSpecification = given()
                .headers("Authorization",authBuilder.toString())
                .relaxedHTTPSValidation()
                .contentType(ContentType.JSON)
                .log().uri();;
    }
}
