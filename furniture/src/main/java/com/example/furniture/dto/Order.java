package com.example.furniture.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "order_table")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer order_id;
    @Column(name = "user_id")
    private int user_id;
    @Column(name = "product_id")
    private int product_id;
    @Column(name = "shipment_id")
    private int shipment_id;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "date")
    private String date;
    @Column(name = "state")
    private int state;
}
