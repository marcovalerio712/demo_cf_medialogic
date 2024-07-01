package com.marcoval.esercizi.democodicefiscale.service.implementation;
import com.marcoval.esercizi.democodicefiscale.model.User;
import com.marcoval.esercizi.democodicefiscale.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImpl implements UserService {


    /*
        Utilizzata per ricavare il valore numerico del mese in base a quanto codificato nel codice fiscale.
        A = Gennaio     (0)
        B = Febbraio    (1)
        C = Marzo       (2)
        D = Aprile      (3)
        E = Maggio      (4)
        H = Giugno      (5)
        L = Luglio      (6)
        M = Agosto      (7)
        P = Settembre   (8)
        R = Ottobre     (9)
        S = Novembre    (10)
        T = Dicembre    (11)
     */
    private static final String CFMonthMapping = "ABCDEHLMPRST";

    @Override
    public User getUserBirthInfo(String cf) {

        User result = new User();

        //Prelevo le ultime due cifre dell'anno di nascita dal CF
        int year = Integer.parseInt(cf.substring(6,8));

        //verifico su ultime due cifre anno corrente per sommare offset a anno nascita
        if(year < Calendar.getInstance().get(Calendar.YEAR) % 100)
            year += 2000;
        else
            year += 1900;

        //Prelevo il codice del mese dal CF e lo uso per ricavarne la posizione in CFMonthMapping, ottenendo un indice da 0 a 11
        int month = CFMonthMapping.indexOf(cf.substring(8,9));

        //Prelevo il giorno di nascita dal CF
        int day = Integer.parseInt(cf.substring(9,11));

        //se CF appartenente a donna -> Giorno nel CF = Giorno effettivo + 40
        if (day > 40)
            day -= 40;

        Date birthDate = new GregorianCalendar(year, month, day).getTime();

        //tempo passato dalla data di nascita ad ora in millisecondi
        long ageInMillis = new Date().getTime() - birthDate.getTime();

        //Converto ageInMIllis in giorni e poi in anni dividendo per 365.25 (per considerare i bisestili)
        int age = (int) (TimeUnit.DAYS.convert(ageInMillis, TimeUnit.MILLISECONDS) / 365.25f);

        result.setBirthDate(birthDate);
        result.setAge(age);

        return result;

    }
}
