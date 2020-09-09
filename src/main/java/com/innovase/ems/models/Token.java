package com.innovase.ems.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "api_token")
public class Token {
    @Id
    private long id;
    private long expiry;
    private String token;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getExpiry() {
        return expiry;
    }

    public void setExpiry(long expiry) {
        this.expiry = expiry;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
