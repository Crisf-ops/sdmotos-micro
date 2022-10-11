package com.sdmotos.sdmotosRecords.repository;

import com.sdmotos.sdmotosRecords.model.Repair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepairRepository extends JpaRepository<Repair, String> { }
