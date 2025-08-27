package api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class BaseApi {

    protected RequestSpecification request = given();
    public Response postAPI(String uri, String body){

        return request
                .body(body)
                .post(uri);
    }

    public Response getAPI(String uri){

        return request
                .get(uri);
    }
}
