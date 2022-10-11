package com.sdmotos.sdmotosRecords.services;

import com.sdmotos.sdmotosRecords.model.Repair;
import com.sdmotos.sdmotosRecords.repository.RepairRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RepairServices {

    @Autowired
    RepairRepository repairRepository;

    public Repair createReapir(Repair repair){
        return this.repairRepository.save(repair);
    }
}
