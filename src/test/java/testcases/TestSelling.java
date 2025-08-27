package testcases;

import model.Item;
import model.PaymentMethods;
import model.ShippingOption;
import org.junit.jupiter.api.Test;

public class TestSelling extends BaseTest{

    @Test
    void listAnItem(){
        //prepare
        Item item = new Item();
        item.setCategory("3849");
        item.setTitle("_My ART_");
        item.setDescription(new String[]{"All true art lovers will buy this", "Art art art..."});
        item.setStartPrice(10.40);
        item.setBuyNowPrice(20.00);
        item.setDuration("Seven");
        item.setPickUp("Allow");
        item.setIsBrandNew(true);
        item.setPhotoIds(new String[]{"1234567", "90123456"});
        ShippingOption shippingOption = new ShippingOption();
        shippingOption.setType("Free");
        item.setShippingOptions(new ShippingOption[]{shippingOption});
        item.setPaymentMethods(new String[]{PaymentMethods.CreditCard.toString(),PaymentMethods.Cash.toString()});

        //call
        response = sellingApi.listAnItem(item.toString());

        //assert
        sellingAssertion.getResponse(response)
                .assertResponseCode(200);
        sellingAssertion.assertSuccess(true)
                .assertNewlyCreatedItemShouldBeInLatestListings();
    }
}
