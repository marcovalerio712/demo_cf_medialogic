package com.marcoval.esercizi.democodicefiscale.service.implementation;
import com.marcoval.esercizi.democodicefiscale.model.User;
import com.marcoval.esercizi.democodicefiscale.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImpl implements UserService {

    private String CFMonthMapping = "ABCDEHLMPRST";

    @Override
    public User getUserBirthInfo(String cf) {

        User result = new User();

        int year = Integer.parseInt(cf.substring(6,8)) + 1900;
        int month = CFMonthMapping.indexOf(cf.substring(8,9));
        int day = Integer.parseInt(cf.substring(9,11));

        if (day > 40)
            day -= 40;

        Date birthDate = new GregorianCalendar(year, month, day).getTime();
        long ageInMillis = new Date().getTime() - birthDate.getTime();
        int age = (int) TimeUnit.DAYS.convert(ageInMillis, TimeUnit.MILLISECONDS) / 365;

        result.setBirthDate(birthDate);
        result.setAge(age);

        return result;

    }
}
