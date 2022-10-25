package com.sdmotos.sdmotosRecords.controller;

import com.sdmotos.sdmotosRecords.model.User;
import com.sdmotos.sdmotosRecords.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Slf4j
@RestController
@RequestMapping("/records")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping()
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> userList = userService.getAllRecords();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @GetMapping(path = "/id")
    public ResponseEntity<User> getUser(@RequestParam("document") Long document) {
        User user = userService.getUser(document);
        return user.getDocumento() == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping(path = "deleteUser/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable("id") Long id) {
        boolean okDelete = userService.deleteUser(id);
        return okDelete ? new ResponseEntity<>(true, HttpStatus.ACCEPTED)
                : new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }

    @PostMapping(path = "saveUser")
    public ResponseEntity<User> saveUser(@RequestBody User newUser) {
        User userSave = userService.saveUser(newUser);
        return userSave.getDocumento() == null ? new ResponseEntity<>(userSave, HttpStatus.INTERNAL_SERVER_ERROR)
                : new ResponseEntity<>(userSave, HttpStatus.CREATED);
    }

    @PutMapping(path = "updateUser/{id}")
    public ResponseEntity<User> updateUsers(@RequestBody User updateUser, @PathVariable Long id) {
        User upDateUser = userService.updateUser(updateUser, id);
        return upDateUser == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(updateUser, HttpStatus.OK);
    }
}
