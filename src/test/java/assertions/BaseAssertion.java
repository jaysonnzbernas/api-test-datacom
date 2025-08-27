package assertions;

import io.restassured.response.Response;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BaseAssertion {

    protected Response response;

    public BaseAssertion getResponse(Response resp){
        response = resp;
        return this;
    }
    public BaseAssertion assertResponseCode(int expectedResponseCode){
        assertEquals(expectedResponseCode, response.getStatusCode());
        return this;
    }
}
