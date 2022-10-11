package com.sdmotos.sdmotosRecords.controller;

import com.sdmotos.sdmotosRecords.model.User;
import com.sdmotos.sdmotosRecords.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/records")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping()
    public List<User> getAllUsers(){
        log.info("Ejecutando getAllRecords");
        return userService.getAllRecords();
    }

    @GetMapping(path = "/id")
    public User getUser(@RequestParam("document") Long document) {
            return userService.getUser(document);
    }

    @DeleteMapping(path = "deleteUser/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        boolean okDelete = userService.deleteUser(id);
        return okDelete ? "Se elimino el usuario con el id "+id : "No se pudo eliminar el usuario con el id"+id;
    }

    @PostMapping(path = "saveUser")
    public User saveUser(@RequestBody User newUser) {
        return userService.saveUser(newUser);
    }

    @PutMapping(path = "updateUser/{id}")
    public User updateUser(@RequestBody User updateUser, @PathVariable Long id) {
        return userService.updateUser(updateUser, id);
    }
}
