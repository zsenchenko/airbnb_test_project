package tests.api.model.get;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class DataTest {

    @JsonProperty("data")
    private Presentation presentation;
}

//import lombok.Data;
//@Data
//public class Extensions {
//
//    private String traceId;
//
//}


//import lombok.Data;
//@Data
//public class WishlistUser {
//
//    private String firstName;
//    private String __typename;
//    private String thumbnailUrl;
//
//}


//import lombok.Data;
//@Data
//public class Description {
//
//    private String localizedString;
//    private String __typename;
//
//}


//import lombok.Data;
//@Data
//public class GuestDetails {
//
//    private Integer numberOfInfants;
//    private Integer numberOfChildren;
//    private Integer numberOfAdults;
//    private String __typename;
//    private Description description;
//
//}


//import lombok.Data;
//@Data
//public class Wishlists {
//
//    private String xlImageUrl;
//    private List<String> pictureUrls;
//    private String __typename;
//    private String pictureUrl;
//    private Boolean isPrivate;
//    private Integer userId;
//    private String checkInDate;
//    private WishlistUser wishlistUser;
//    private String checkOutDate;
//    private String createdBy;
//    private String inviteUrl;
//    private String name;
//    private Integer guestCount;
//    private GuestDetails guestDetails;
//    private String id;
//
//}


//import lombok.Data;
//@Data
//public class WishlistIndexPage {
//
//    private String __typename;
//    private List<Wishlists> wishlists;
//
//}


//import lombok.Data;
//@Data
//public class Presentation {
//
//    private WishlistIndexPage wishlistIndexPage;
//    private String __typename;
//
//}


//import lombok.Data;
//@Data
//public class Data {
//
//    private Presentation presentation;
//
//}
//
//
//import lombok.Data;
//@Data
//public class Root {
//
//    private Extensions extensions;
//    private Data data;
//
//}

//package cloud.autotests.model;
//
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import com.fasterxml.jackson.annotation.JsonProperty;
//import lombok.Data;
//
//import java.util.List;
//
//@Data
//@JsonIgnoreProperties(ignoreUnknown = true)
//public class WishLists {
////    @JsonProperty("userId")
////    private Integer userId;
//    @JsonProperty("wishlists")
////    private String name;
//    private List<WishlistsL> l;
//}


