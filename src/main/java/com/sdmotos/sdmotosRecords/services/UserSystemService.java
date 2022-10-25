package com.sdmotos.sdmotosRecords.services;

import com.sdmotos.sdmotosRecords.model.UserSystem;
import com.sdmotos.sdmotosRecords.repository.UserSystemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSystemService {

    @Autowired
    UserSystemRepository userSystemRepository;

    public UserSystem getUserSytem(UserSystem userSystem) {
        if (userSystem.getEmail().isEmpty()) { return new UserSystem(); }
        UserSystem userSystemOptional = userSystemRepository.findByEmail(userSystem.getEmail());
        return userSystemOptional != null && userSystemOptional.getEmail().equals(userSystem.getEmail()) &&
                userSystemOptional.getPwd().equals(userSystem.getPwd())
                ? userSystemOptional
                : new UserSystem();
    }
}
