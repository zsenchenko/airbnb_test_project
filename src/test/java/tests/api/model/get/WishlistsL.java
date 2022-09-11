package tests.api.model.get;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WishlistsL {
    @JsonProperty("__typename")
    private String typename;

    @JsonProperty("name")
    private String name;
}
