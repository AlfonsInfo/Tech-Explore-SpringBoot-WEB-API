package restfulAPI.restful.dto.response;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisResponse {
    private String username;
    private String email;
    private String role;
    private byte[] fotoProfil;
}
