package restfulAPI.restful.dto.request;

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
public class CreateContactRequest {

    @NotBlank
    @Size(max = 100)
    private String firstName;
    @Size(max = 100)
    private String lastName;

    @Size(max = 100)
    private String email;
    @Size(max = 100)
    private String phone;
}
