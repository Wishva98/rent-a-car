package com.rentacar.util;

public enum PayMethod {
    VISA("visa"),CASH("cash"),BANK("bank");
    private String method;

    PayMethod(String method) {
        this.method = method;
    }

    public String getMethod(){
        return method;
    }
}
