package com.mycompany.app;

public class Tarjeta {

    public String No_Cuenta, NIP;


    public Tarjeta(String no_Cuenta, String NIP) {
        No_Cuenta = no_Cuenta;
        this.NIP = NIP;
    }

    public String getNo_Cuenta() {
        return No_Cuenta;
    }

    public void setNo_Cuenta(String no_Cuenta) {
        No_Cuenta = no_Cuenta;
    }

    public String getNIP() {
        return NIP;
    }

    public void setNIP(String NIP) {
        this.NIP = NIP;
    }
}