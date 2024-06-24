package com.example.furniture.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Entity;

@Entity()
@Table(name = "shipment")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class Shipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "shipment_id")
    private Integer shipment_id;
    @Column(name = "full_name")
    private String full_name;
    @Column(name = "address")
    private String address;
    @Column(name = "zipcode")
    private String zipcode;
    @Column(name = "province")
    private String province;
    @Column(name = "district")
    private String district;
    @Column(name = "ward")
    private String ward;
    @Column(name = "user_id")
    private int user_id;
}