package com.sdmotos.sdmotosRecords.services;

import com.sdmotos.sdmotosRecords.model.Vehicle;
import com.sdmotos.sdmotosRecords.repository.VehiclesRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class VehiclesService {

    @Autowired
    VehiclesRepository repairsRepository;

    public Vehicle createReapirs(Vehicle vehicles){
        return this.repairsRepository.save(vehicles);
    }
    public boolean deleteRepairs(String id){
        try {
            log.info("Metodo: deleteRepairs - Ingreso a eliminar registro de reparacion");
            this.repairsRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            log.error("Metodo: deleteRepairs - Ocurrio un error al eliminar el registro de la reparacion");
            return false;
        }
    }

    public List<Vehicle> getAllVehicle() {
        return repairsRepository.findAll();
    }
}
