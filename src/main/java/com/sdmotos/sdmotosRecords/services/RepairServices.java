package com.sdmotos.sdmotosRecords.services;

import com.sdmotos.sdmotosRecords.model.Repair;
import com.sdmotos.sdmotosRecords.repository.RepairRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class RepairServices {

    @Autowired
    RepairRepository repairRepository;

    public List<Repair> getAllRepair() {
        log.info("Obteniendo todas las reparaciones");
        return repairRepository.findAll();
    }

    public Repair getReapir(Long id) {
        Optional<Repair> optionalRepair = repairRepository.findById(id);
        return optionalRepair.orElseGet(Repair::new);
    }

    public Repair createReapir(Repair repair){
        try {
            log.info("Metodo: createReapir, Guardando reparacion");
            return this.repairRepository.save(repair);
        } catch (Exception e) {
            log.error("Metodo: createReapir, Ocurrio un error al guardar la reparacion");
            return new Repair();
        }
    }

    public boolean deleteRepair(Long id) {
        try {
            log.info("Metodo: deleteRepair, borrando la reparacion {}", id);
            repairRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            log.error("Metodo: deleteRepair, Ocurrio un error al borrar la reparacione");
            return false;
        }
    }

    public Repair updateRepair(Repair repair, Long id) {
        log.info("Metodo: updateRepair, Actualizacion reparacion");
        Long repairId = repair.getIdRepair() == null ? id : repair.getIdRepair();
        return repairRepository.findById(repairId).map(
                resulRepair -> {
                    resulRepair.setAmount(repair.getAmount());
                    resulRepair.setRemarks(repair.getRemarks());
                    resulRepair.setTrouble(repair.getTrouble());
                    return repairRepository.save(resulRepair);
                }
        ).orElseGet(() -> {
            log.info("Metodo: updateRepair, No se encontro la reparacion asi que se creo una nueva");
            repair.setIdRepair(id);
            return repairRepository.save(repair);
        });
    }
}
