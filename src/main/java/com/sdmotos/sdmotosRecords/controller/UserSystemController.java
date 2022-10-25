package com.sdmotos.sdmotosRecords.controller;


import com.sdmotos.sdmotosRecords.exception.SDMotosException;
import com.sdmotos.sdmotosRecords.model.UserSystem;
import com.sdmotos.sdmotosRecords.services.UserSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loginSdmotos")
public class UserSystemController {

    @Autowired
    UserSystemService systemService;

    @PostMapping
    public ResponseEntity<String> login(@RequestBody UserSystem user) {
        UserSystem login = systemService.getUserSytem(user);
        return login.getPwd() == null || login.getEmail() == null ?
                new ResponseEntity<>("Credenciales no validas", HttpStatus.UNAUTHORIZED)
                : new ResponseEntity<>("Ok", HttpStatus.OK);
    }
}
