package com.sdmotos.sdmotosRecords.controller;


import com.sdmotos.sdmotosRecords.model.Vehicle;
import com.sdmotos.sdmotosRecords.services.VehiclesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/vehicle")
public class VehiclesController {

    @Autowired
    VehiclesService vehiclesService;

    @PostMapping(path = "/createVehicle")
    public ResponseEntity<Vehicle> createRepair(@RequestBody Vehicle vehicle){
        Vehicle saveVehicle = vehiclesService.createVehicle(vehicle);
        return saveVehicle == null ? new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR)
                : new ResponseEntity<>(saveVehicle, HttpStatus.CREATED);
    }

    @DeleteMapping(path = "deleteRepair/{id}")
    public ResponseEntity<Boolean> deleteRepairById(@PathVariable("id") Long id){
        boolean ok = this.vehiclesService.deleteVehicle(id);
        return ok ? new ResponseEntity<>(true, HttpStatus.ACCEPTED)
                : new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<Vehicle>> getAllVehicles() {
        List<Vehicle> vehicleList = vehiclesService.getAllVehicle();
        return new ResponseEntity<>(vehicleList,HttpStatus.OK);
    }

    @GetMapping(path = "/getVehicle")
    public ResponseEntity<Vehicle> getVehicle(@RequestParam("id") Long id){
        Vehicle vehicle = vehiclesService.getVehicle(id);
        return vehicle.getIdVehicles() == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(vehicle, HttpStatus.OK);
    }
}
