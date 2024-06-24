package com.example.furniture.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.furniture.dto.Shipment;

public interface ShipmentRepository extends JpaRepository<Shipment , Integer>{
    
}
