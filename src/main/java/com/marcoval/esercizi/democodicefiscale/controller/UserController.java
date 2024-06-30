package com.marcoval.esercizi.democodicefiscale.controller;

import com.marcoval.esercizi.democodicefiscale.bean.UserBirthBean;
import com.marcoval.esercizi.democodicefiscale.model.User;
import com.marcoval.esercizi.democodicefiscale.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private UserService userService;
    @GetMapping("birth")
    //CF = Codice fiscale
    public UserBirthBean getBirthData(@RequestParam(name = "cf") String cf){

        User userData = userService.getUserBirthInfo(cf);

        UserBirthBean birthData = new UserBirthBean();
        birthData.setBirthDate(userData.getBirthDate());
        birthData.setAge(userData.getAge());

        return birthData;
    }

}
