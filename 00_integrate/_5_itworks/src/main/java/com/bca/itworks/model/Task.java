package com.bca.itworks.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcType;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;
//import lombok.EqualsAndHashCode;
//import lombok.ToString;

@Entity
@Table(name = "task")
@Data
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(generator = "UUID")
    @JdbcTypeCode(SqlTypes.UUID)
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false , nullable = false)
    private UUID id;


    @Column
    private String title;


    @Column(name = "is_done")
    @ColumnDefault("false")
    private Boolean isDone;


    @Column(name = "created_date")
    @ColumnDefault("NOW()")
    private Date createdDate;



    @Column(name = "modified_date")
    private Date modifiedDate;

    public Task(String title) {
        this.title = title;
        this.isDone = false;
        this.createdDate = Calendar.getInstance().getTime();
    }
}
