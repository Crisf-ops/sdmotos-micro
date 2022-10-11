package com.sdmotos.sdmotosRecords.repository;


import com.sdmotos.sdmotosRecords.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiclesRepository extends JpaRepository<Vehicle,String> { }