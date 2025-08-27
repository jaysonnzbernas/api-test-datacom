package assertions;

import api.ListingsApi;
import model.Item;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SellingAssertion extends BaseAssertion{

    private ListingsApi listingsApi = new ListingsApi();

    public SellingAssertion assertSuccess(boolean expected){
        boolean isSuccess = response.body().jsonPath().getBoolean("Success");
        assertEquals(expected, isSuccess);
        return this;
    }
    public SellingAssertion assertNewlyCreatedItemShouldBeInLatestListings(){
        Long listingId = response.body().jsonPath().getLong("ListingId");
        List<Item> actualItemList = listingsApi.getLatestListings()
                .andReturn().body().jsonPath().getList("List", Item.class);

       assertTrue(actualItemList.stream()
               .map(Item::getListingId)
               .collect(Collectors.toSet())
               .contains(listingId));
        return this;
    }
}
