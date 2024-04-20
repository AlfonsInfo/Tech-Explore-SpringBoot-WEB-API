package group.bootcamp.technicaltest.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@MappedSuperclass
public class BaseEntity
implements Serializable
{
    @JsonIgnore
    private Date createdDate;
    @JsonIgnore
    private Date updatedDate;
    @JsonIgnore
    private Date updatedBy;
    @JsonIgnore
    private Date createdBy;
}
