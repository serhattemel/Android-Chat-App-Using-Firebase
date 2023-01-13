package com.example.a201913709048;

public class MessageModel {
    String mesajBaslik;
    String mesajIcerik;

    public MessageModel()
    {}

    public MessageModel(String mesajBaslik, String mesajIcerik) {
        this.mesajBaslik = mesajBaslik;
        this.mesajIcerik = mesajIcerik;
    }

    public String getMesajBaslik() {
        return mesajBaslik;
    }

    public void setMesajBaslik(String mesajBaslik) {
        this.mesajBaslik = mesajBaslik;
    }

    public String getMesajIcerik() {
        return mesajIcerik;
    }

    public void setMesajIcerik(String mesajIcerik) {
        this.mesajIcerik = mesajIcerik;
    }
}
