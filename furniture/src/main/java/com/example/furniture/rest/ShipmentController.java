package com.example.furniture.rest;

import org.springframework.web.bind.annotation.RestController;

import com.example.furniture.core.validation.ResponseObject;
import com.example.furniture.dto.Shipment;
import com.example.furniture.dto.User;
import com.example.furniture.services.ShipmentService;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/shipment")
public class ShipmentController {

    @Autowired
    private ShipmentService service;

    @GetMapping("")
    public ResponseEntity<ResponseObject> getAllListData() {
        List<Shipment> list = service.getAllListData();
        ResponseObject result = new ResponseObject();
        result.setStatus("ok");
        result.setMessage("get all list data successfully");
        result.setData(list);
        return new ResponseEntity<ResponseObject>(result, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<ResponseObject> insertShipment(@RequestBody @Valid Shipment shipment) {
        service.insertShipment(shipment);
        ResponseObject result = new ResponseObject();
        result.setStatus("ok");
        result.setMessage("Create a new shipment successfully");
        return new ResponseEntity<ResponseObject>(result, HttpStatus.OK);
    }

    @DeleteMapping("/{shipment_id}")
    public ResponseEntity<ResponseObject> deleteShipment(@PathVariable("shipment_id") int shipment_id) {
        service.deleteShipment(shipment_id);
        ResponseObject result = new ResponseObject();
        result.setStatus("ok");
        result.setMessage("Delete shipment successfully");
        return new ResponseEntity<ResponseObject>(result, HttpStatus.OK);
    }

    @GetMapping("/{shipment_id}")
    public ResponseEntity<ResponseObject> getAnShipmentById(@PathVariable("shipment_id") int shipment_id) {
        Shipment shipment = service.getAnShipmentById(shipment_id);
        ResponseObject result = new ResponseObject();
        result.setStatus("ok");
        result.setMessage("Get an shipment successfully");
        result.setData(shipment);
        return new ResponseEntity<ResponseObject>(result, HttpStatus.OK);
    }

    @PutMapping("/{shipment_id}")
    public ResponseEntity<ResponseObject> updateShipment(@PathVariable("shipment_id") int shipment_id,
            @RequestBody Shipment shipment) {
        service.updateShipment(shipment_id, shipment);
        ResponseObject result = new ResponseObject();
        result.setStatus("ok");
        result.setMessage("Update shipment successfully");
        return new ResponseEntity<ResponseObject>(result, HttpStatus.OK);
    }
}
