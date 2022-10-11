package com.sdmotos.sdmotosRecords.utils.Enums;

public enum StateRecords {
    PENDING("0"),
    OK("1"),
    REJECTED("2");
    private String cod;
    StateRecords(String cod) {this.cod = cod;}

    public String getCod() { return cod; }

    public void setCod(String cod) { this.cod = cod; }
}
