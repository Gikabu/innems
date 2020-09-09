package com.innovase.ems.models;

import javax.persistence.*;

@Entity
@Table(name = "units")
public class Unit {

    @Id
    @GeneratedValue(generator = "unit_generator")
    @SequenceGenerator(
            name = "unit_generator",
            sequenceName = "unit_sequence",
            initialValue = 200000000
    )
    private long id;
    private String name;
    private long tenant_id;
    private String property_name;
    private String property_short_code;
    private long rent;
    private long rent_balance;
    private long last_payment_date;
    private int status;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getTenantId() {
        return tenant_id;
    }

    public void setTenantId(long tenantId) {
        this.tenant_id = tenantId;
    }

    public String getProperty_name() {
        return property_name;
    }

    public void setProperty_name(String property_name) {
        this.property_name = property_name;
    }

    public String getProperty_short_code() {
        return property_short_code;
    }

    public void setProperty_short_code(String property_short_code) {
        this.property_short_code = property_short_code;
    }

    public long getRent() {
        return rent;
    }

    public void setRent(long rent) {
        this.rent = rent;
    }

    public long getRent_balance() {
        return rent_balance;
    }

    public void setRent_balance(long rent_balance) {
        this.rent_balance = rent_balance;
    }

    public long getLast_payment_date() {
        return last_payment_date;
    }

    
    public void setLast_payment_date(long last_payment_date) {
        this.last_payment_date = last_payment_date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


}
