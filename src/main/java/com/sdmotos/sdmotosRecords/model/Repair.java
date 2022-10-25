package com.sdmotos.sdmotosRecords.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sdmotos.sdmotosRecords.utils.Enums.StateRecords;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "repairs")
public class Repair implements Serializable {

    @Serial
    private static final long serialVersionUID = -2113274973878410008L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_repair")
    private Long idRepair;

    @Column
    private String remarks;

    @Column
    private String trouble;

    @Column
    private float amount;

    @Column
    private StateRecords stateRecords;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_vehicles")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Vehicle vehicle;

}
