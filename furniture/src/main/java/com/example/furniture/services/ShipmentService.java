package com.example.furniture.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.furniture.core.exception.ShipmentNotFoundException;
import com.example.furniture.core.exception.UnknowException;
import com.example.furniture.dto.Shipment;
import com.example.furniture.repositories.ShipmentRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ShipmentService {
    @Autowired
    private ShipmentRepository repository;

    public void insertShipment(Shipment shipment) throws UnknowException {
        Shipment shipment_address = repository.save(shipment);
        if (shipment_address.getShipment_id() == null) {
            throw new UnknowException("Transaction cannot complete!");
        }
    }

    public List<Shipment> getAllListData() {
        return repository.findAll();
    }

    public void deleteShipment(int shipment_id) throws ShipmentNotFoundException{
        Optional<Shipment> shipment = repository.findById(shipment_id);
        if(shipment == null){
            throw new ShipmentNotFoundException("Shipment not found");
        }
        repository.deleteById(shipment_id);   
    }

    public Shipment getAnShipmentById(int shipment_id) throws ShipmentNotFoundException {
        return repository.findById(shipment_id)
            .orElseThrow(() -> new ShipmentNotFoundException("Shipment not found"));
    }

    public void updateShipment(int shipment_id, Shipment shipment) throws ShipmentNotFoundException, UnknowException {
        Shipment foundShipment = repository.findById(shipment_id).orElseThrow(() -> new ShipmentNotFoundException("Shipment not found"));
        
        if (foundShipment.getUser_id() != shipment.getUser_id()) {
            throw new UnknowException("User ID error");
        }
        
        foundShipment.setFull_name(shipment.getFull_name());
        foundShipment.setDistrict(shipment.getDistrict());
        foundShipment.setAddress(shipment.getAddress());
        foundShipment.setProvince(shipment.getProvince());
        foundShipment.setZipcode(shipment.getZipcode());
        foundShipment.setWard(shipment.getWard());
    
        repository.save(foundShipment);
    }
}
