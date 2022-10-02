package tests.api.model.post.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddToWishListRequest {

    @JsonProperty("wishlist_id")
    private String wishlistId;

    @JsonProperty("listing_id")
    private String listingId;

    @JsonProperty("entity_type")
    private String entityType;

    @JsonProperty("_format")
    private String format;
}
