package restfulAPI.restful.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateAddressRequest {

    @JsonIgnore
    @NotBlank
    private String contactId;


//    Jika ingin menambahkan custom alamatnya
//    @JsonProperty
    @Size(max = 200)
    private String street;
    @Size(max = 100)
    private String city;
    @Size(max = 100)
    private String province;
    @Size(max = 100)
    @NotBlank
    private String country;
    @Size(max = 100)
    private String postalCode;

}

//{
//        "street" : "Jalan apa",
//        "city" : "kota",
//        "province" : "provinsi",
//        "country" : "Indonesia",
//        "postalCode" : "55281"
//        }
