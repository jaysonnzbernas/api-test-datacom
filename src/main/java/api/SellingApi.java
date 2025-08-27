package api;

import io.restassured.response.Response;

public class SellingApi extends BaseApi{

    private String sellingUri = "/v1/Selling.json";

    public Response listAnItem(String itemJson){

        return postAPI(sellingUri, itemJson);
    }
}
