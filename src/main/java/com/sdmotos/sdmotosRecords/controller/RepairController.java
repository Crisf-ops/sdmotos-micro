package com.sdmotos.sdmotosRecords.controller;

import com.sdmotos.sdmotosRecords.model.Repair;
import com.sdmotos.sdmotosRecords.services.RepairServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/repair")
public class RepairController {

    @Autowired
    RepairServices repairServices;

    @GetMapping(path = "/getRepair")
    public ResponseEntity<Repair> getRepair(@RequestParam("id") Long id) {
        Repair repair = repairServices.getReapir(id);
        return  repair.getIdRepair() == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(repair, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<Repair>> getAllRepairs() {
        List<Repair> repairList = repairServices.getAllRepair();
        return new ResponseEntity<>(repairList, HttpStatus.OK);
    }
    @DeleteMapping(path = "/deleteRepair")
    public ResponseEntity<Boolean> deleteRepair(@PathVariable("id") Long id) {
        boolean ok = repairServices.deleteRepair(id);
        return ok ? new ResponseEntity<>(true,HttpStatus.ACCEPTED)
                : new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }

    @PostMapping(path = "/createdRepair")
    public ResponseEntity<Repair> createRepair(@RequestBody Repair repair){
        Repair saveRepair = repairServices.createReapir(repair);
        return saveRepair.getIdRepair() == null ? new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR)
                : new ResponseEntity<>(saveRepair, HttpStatus.CREATED);
    }

    @PutMapping(path = "updateRepair/{id}")
    public ResponseEntity<Repair> updateRepair(@RequestBody Repair repair, @PathVariable Long id) {
        Repair putRepair = repairServices.updateRepair(repair, id);
        return putRepair == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(HttpStatus.OK);
    }
}
