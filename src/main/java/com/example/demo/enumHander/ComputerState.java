package com.example.demo.enumHander;

import org.omg.CORBA.UNKNOWN;

public enum ComputerState implements BaseCodeEnum {
    OPEN(10),
    CLOSE(11),
    OFF_LINE(12),
    FAULT(200),
    UNKNOWN(255);

    private  int code;
    ComputerState(int code){
        this.code = code;
    }

    @Override
    public int getCode() {
        return code;
    }
}
