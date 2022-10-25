package com.sdmotos.sdmotosRecords.services;


import com.sdmotos.sdmotosRecords.model.User;
import com.sdmotos.sdmotosRecords.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> getAllRecords(){
        log.info("Metodo: getAllRecords, Obteniendo todos los usuarios");
        return userRepository.findAll();
    }

    public User getUser(Long id) {
        log.info("Metodo: getUser, Obteniendo al usuario: {}", id );
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.orElseGet(User::new);
    }

    public boolean deleteUser(Long id) {
        try {
            log.info("Metodo: deleteUser , borrando al usuario {}",id);
            userRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            log.error("Ocurrio un error al borrar el usuario {}", id);
            return false;
        }
    }

    public User saveUser(User user) {
        try {
            log.info("Metodo: saveUser, Guardando usuario {} ", user.getDocumento());
            return userRepository.save(user);
        } catch (Exception e) {
            log.error("Ocurrio un error al guardar el usuario {}",user.getDocumento());
            return new User();
        }
    }

    public User updateUser(User updateUser, Long id) {
        log.info("Metodo: updateUser, Actualizando usuario {}", id);
        Long updateUserId = updateUser.getDocumento() == null ? id : updateUser.getDocumento();
        return userRepository.findById(updateUserId).map(
                user -> {
                    user.setName(updateUser.getName());
                    user.setEmail(updateUser.getEmail());
                    user.setContactNumber(updateUser.getContactNumber());
                    user.setLastName(updateUser.getLastName());
                    return userRepository.save(user);
                }
        ).orElseGet(() -> {
            log.info("Metodo: updateUser, No se encontro el usuario asi que se creo {}",id);
            updateUser.setDocumento(id);
            return userRepository.save(updateUser);
        });
    }
}
