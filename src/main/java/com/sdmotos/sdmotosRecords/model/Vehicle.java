package com.sdmotos.sdmotosRecords.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sdmotos.sdmotosRecords.utils.Enums.TypeVehicle;
import lombok.*;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "vehicles")
public class Vehicle implements Serializable {

    @Serial
    private static final long serialVersionUID = -3655582156663014432L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vehicles")
    private Long idVehicles;

    @Column(name = "type_vehicle")
    private TypeVehicle typeVehicle;

    private String model;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "documento")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private User user;


    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL)
    private List<Repair> repair;
}