package spring.template.demo.error;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Entity
@Table(name = "errors")
@Data
@Builder
@AllArgsConstructor
public class Error {
    @Id
    public String errorId;
    public String errorCode;
    public String errEngMsg;
    public String errIndMsg;
}
