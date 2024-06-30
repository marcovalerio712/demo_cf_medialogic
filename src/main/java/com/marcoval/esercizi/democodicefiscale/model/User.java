package com.marcoval.esercizi.democodicefiscale.model;

import java.util.Date;

public class User {
    private String CF;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private Integer age;

    public String getCF() {
        return CF;
    }

    public void setCF(String CF) {
        this.CF = CF;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


}
