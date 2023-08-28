package restfulAPI.restful.dto.request.register;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisRequest {



    @NotNull
    private String username;

    @NotNull
    private String password;

    @NotNull
    private String email;

    @NotNull
    private String role;

    // coba ganti multipart file
    private byte[] fotoProfil;

}
