package com.sdmotos.sdmotosRecords.utils.Enums;

public enum TypeVehicle {
    CARS(1),
    MOTORCYCLE(2);
    private Integer cod;

    TypeVehicle(Integer cod) {this.cod = cod;}

    public Integer getCod() { return cod; }

    public void setCod(Integer cod) { this.cod = cod; }
}
