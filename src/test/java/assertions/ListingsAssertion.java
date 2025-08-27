package assertions;

import model.Item;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListingsAssertion extends BaseAssertion{

    public ListingsAssertion assertTotalCount(int expectedCount){
        assertEquals(expectedCount, response.body().jsonPath().getInt("TotalCount"));
        return this;
    }

    public ListingsAssertion assertNumberOfItemsInList(int expectedNumberOfItems){
        List<Item> actualItemList = response.body().jsonPath().getList("List", Item.class);
        assertEquals(expectedNumberOfItems, actualItemList.size());
        return this;
    }
}
