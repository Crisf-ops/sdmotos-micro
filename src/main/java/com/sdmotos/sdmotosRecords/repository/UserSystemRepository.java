package com.sdmotos.sdmotosRecords.repository;

import com.sdmotos.sdmotosRecords.model.UserSystem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSystemRepository extends CrudRepository<UserSystem, Long> {
    UserSystem findByEmail(String email);
}
