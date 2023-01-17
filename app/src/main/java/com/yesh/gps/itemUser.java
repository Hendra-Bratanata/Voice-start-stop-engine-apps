package com.yesh.gps;

import org.json.JSONException;
import org.json.JSONObject;

public class itemUser {
    String idUser;
    String nama;
    String username;
    String password;

    public itemUser(JSONObject object) {
        try {
            String idUser = object.getString("ID_USER");
            String nama = object.getString("NAMA");
            String username =  object.getString("USERNAME");
            String password = object.getString("PASSWORD");

        this.idUser = idUser;
        this.nama = nama;
        this.username = username;
        this.password = password;
    }catch (JSONException e){
            e.printStackTrace();
        }
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
