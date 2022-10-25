package com.sdmotos.sdmotosRecords.model;

import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "adm")
public class UserSystem implements Serializable {

    @Serial
    private static final long serialVersionUID = 1008048015372550890L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_administrador")
    private Long idADM;

    @Column
    //TODO: Que este parametro sea unico y que no sea null
    private String email;

    @Column
    private String pwd;
}
