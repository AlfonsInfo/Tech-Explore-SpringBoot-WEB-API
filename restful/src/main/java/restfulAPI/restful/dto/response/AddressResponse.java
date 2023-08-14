package restfulAPI.restful.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddressResponse {
//    public

    private String id;

    private String street;

    private String city;

    private String province;

    private String country;
    private String postalCode;
}
