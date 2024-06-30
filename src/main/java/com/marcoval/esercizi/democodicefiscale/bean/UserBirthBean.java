package com.marcoval.esercizi.democodicefiscale.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class UserBirthBean {

    @JsonFormat(pattern = "dd-MM-yyyy", timezone = "Europe/Rome")
    private Date birthDate;
    private Integer age;

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
