package com.sdmotos.sdmotosRecords.utils.Enums;

import lombok.Getter;

@Getter
public enum StateRecords {
    PENDING("0"),
    OK("1"),
    REJECTED("2");
    private String cod;
    StateRecords(String cod) {this.cod = cod;}
}
