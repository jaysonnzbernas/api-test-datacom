package model;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import utils.JsonUtils;

@Setter
@Getter
public class Item {

    private Long ListingId;
    private String Category;
    private String Title;
    private String[] Description;
    private Double StartPrice;
    private Double BuyNowPrice;
    private String Duration;
    private String PickUp;
    private Boolean IsBrandNew;
    private String[] PhotoIds;
    private ShippingOption[] ShippingOptions;
    private String[] PaymentMethods;

    @Override
    public String toString(){
        return JsonUtils.serialise(this);
    }
}
