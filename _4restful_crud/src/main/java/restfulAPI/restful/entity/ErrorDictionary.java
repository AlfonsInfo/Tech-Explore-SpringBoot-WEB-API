package restfulAPI.restful.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class ErrorDictionary {

    @Id
    @Column(name = "key_message")
    private String keyMessage;

    @Column(name = "error_code")
    private String errCode;

    @Column(name = "ind_error_msg")
    private String IndErrorMsg;

    @Column(name = "eng_error_msg")
    private String EngErrorMsg;

    @Column(name = "status_code")
    private String httpStatusCode;



}
