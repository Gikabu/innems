package com.innovase.ems.models;

import javax.persistence.*;

@Entity
@Table(name = "tenants")
public class Tenant {

    @Id
    @GeneratedValue(generator = "tenant_generator")
    @SequenceGenerator(
            name = "tenant_generator",
            sequenceName = "tenant_sequence",
            initialValue = 300000000
    )
    private long id;
    private String phone;
    private String national_id;
    private String first_name;
    private String last_name;

    public long getId() {
        return id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNational_id() {
        return national_id;
    }

    public void setNational_id(String national_id) {
        this.national_id = national_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
}
