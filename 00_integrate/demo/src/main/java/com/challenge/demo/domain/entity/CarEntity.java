package com.challenge.demo.domain.entity;

import com.challenge.demo.domain.TransmissionType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "car")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarEntity {

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String id;
    private String name;
    private String description;
    private Long price;
    @ManyToOne
    @JoinColumn(name = "brand_id")
    private BrandEntity brandEntity;
    private Integer year;
    private String color;
    private String mileage;
    @Enumerated(EnumType.STRING)
    private TransmissionType status;
    private Integer seatingCapacity;

}
