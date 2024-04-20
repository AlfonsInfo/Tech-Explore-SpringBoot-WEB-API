package group.learn.webmvc.data;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class CreatePersonRequest {
    private String name;
    private String email;
    private String phone;
    private Address address;
    @NotNull
    private List<String> socialMedia;
}


//name:alfons
//email:email@example.com
//phone:08128312
//address.street:padang