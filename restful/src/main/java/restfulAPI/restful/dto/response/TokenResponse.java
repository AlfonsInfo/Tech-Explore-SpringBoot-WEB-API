package restfulAPI.restful.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder // builder untuk apa etah
public class TokenResponse {
    private String token;
    private Long expiredAt;
}
