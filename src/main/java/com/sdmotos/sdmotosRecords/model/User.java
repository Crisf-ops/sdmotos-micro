package com.sdmotos.sdmotosRecords.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "clients")
public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = -895110769628740521L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long documento;

    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "contact_number")
    private String contactNumber;

    private String email;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Vehicle> vehicles;

}
