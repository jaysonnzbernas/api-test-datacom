package testcases;

import org.junit.jupiter.api.Test;

public class TestListings extends BaseTest {

    @Test
    void testLatestListings(){
        //call
        response = listingsApi.getLatestListings();

        //assert
        listingsAssert.getResponse(response)
                .assertResponseCode(200);
        listingsAssert.assertTotalCount(250)
                .assertNumberOfItemsInList(50);
    }
}
