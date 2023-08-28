package restfulAPI.restful.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Null;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.sql.Timestamp;
@Data
@Entity
public class Events {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String pkId;

    private Timestamp createdDate;
    private String idUser;
    private String activity;
    @Nullable
    private String errorMessage;
    @Nullable
    private String freeText;
    @Nullable
    private String method;

}
