package api;

import io.restassured.response.Response;

public class ListingsApi extends BaseApi{

    private String latestListingsUri = "/v1/listings/latest.json";

    public Response getLatestListings(){

        return getAPI(latestListingsUri);
    }
}
