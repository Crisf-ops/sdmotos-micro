package com.sdmotos.sdmotosRecords.controller;

import com.sdmotos.sdmotosRecords.model.Repair;
import com.sdmotos.sdmotosRecords.services.RepairServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/repair")
public class RepairController {

    @Autowired
    RepairServices repairServices;

    @PostMapping(path = "/post")
    public Repair createRepair(@RequestBody Repair repair){
        try {
            return repairServices.createReapir(repair);
        } catch (Exception e) {
            log.error("Metodo: createRepair - Ocurrio un error al crear el registro de reparacion, body: " + repair);
            log.error("Metodo: createRepair - Tipo de error: " + e);
            return repair;
        }
    }
}
