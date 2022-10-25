package com.sdmotos.sdmotosRecords.services;

import com.sdmotos.sdmotosRecords.model.Vehicle;
import com.sdmotos.sdmotosRecords.repository.VehiclesRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class VehiclesService {

    @Autowired
    VehiclesRepository repairsRepository;

    public Vehicle createVehicle(Vehicle vehicles){
        try {
            log.info("Metodo: createVehicle, Guardando Vehiculo: {} ", vehicles.toString());
            return this.repairsRepository.save(vehicles);
        } catch (Exception e) {
            log.error("Ocurrio un error al guardar el vehiculo del usuario {}", vehicles.getUser().toString());
            return new Vehicle();
        }
    }
    public boolean deleteVehicle(String id){
        try {
            log.info("Metodo: deleteVehicle - Ejecutando el eliminado del registro: " + id);
            this.repairsRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            log.error("Metodo: deleteVehicle - Ocurrio un error al eliminar el registro de la reparacion");
            return false;
        }
    }

    public List<Vehicle> getAllVehicle() {
        log.info("Metodo: getAllVehicle, Obteniendo todos los vehiculos");
        return repairsRepository.findAll();
    }

    public Vehicle getVehicle(Long id) {
        log.info("Metodo: getVehicle, Obteniendo Vehiculo con el id: {} ",id);
        Optional<Vehicle> optionalVehicle = repairsRepository.findById(String.valueOf(id));
        return optionalVehicle.orElseGet(Vehicle::new);
    }

    public Vehicle updateVehicle(Vehicle vehicle, Long id) {
        log.info("Metodo: updateVehicle, Actualizando vehiculo: {}", id);
        Long updateVehicle = vehicle.getIdVehicles() == null ? id : vehicle.getIdVehicles();
        return repairsRepository.findById(String.valueOf(updateVehicle)).map(
                vehicleUser -> {
                    vehicleUser.setRepair(vehicle.getRepair());
                    vehicleUser.setTypeVehicle(vehicle.getTypeVehicle());
                    vehicleUser.setModel(vehicle.getModel());
                    return repairsRepository.save(vehicleUser);
                }
        ).orElseGet(() -> {
            log.info("Metodo: updateVehicle, No se encontrar el vehiculo con el id {} ", id);
            vehicle.setIdVehicles(id);
            return  repairsRepository.save(vehicle);
        });
    }
}
