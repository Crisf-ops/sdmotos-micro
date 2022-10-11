package com.sdmotos.sdmotosRecords.controller;


import com.sdmotos.sdmotosRecords.model.Vehicle;
import com.sdmotos.sdmotosRecords.services.VehiclesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/vehicle")
public class VehiclesController {

    @Autowired
    VehiclesService vehiclesService;

    @PostMapping(path = "/post")
    public Vehicle createRepair(@RequestBody Vehicle vehicle){
        try {
            return vehiclesService.createReapirs(vehicle);
        } catch (Exception e) {
            log.error("Metodo: createRepair - Ocurrio un error al crear el registro de reparacion, body: " + vehicle);
            log.error("Metodo: createRepair - Tipo de error: " + e);
            return vehicle;
        }
    }

    @DeleteMapping(path = "deleteRepair/{id}")
    public String deleteRepairById(@PathVariable("id") String id){
        log.info("Metodo: deleteRepairById - Ejecutando el eliminado del registro: " + id);
        boolean ok = this.vehiclesService.deleteRepairs(id);
        return ok ? "Se elimino el registro con el id: " + id : "Ocurrio un error al eliminar el registro con el id: " + id;
    }

    @GetMapping(path = "/all")
    public List<Vehicle> getAllVehicles() {
        return  vehiclesService.getAllVehicle();
    }
}
