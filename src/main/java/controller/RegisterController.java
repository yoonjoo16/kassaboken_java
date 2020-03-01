package controller;

import view.Pane;
import view.RegisterView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RegisterController {
    private RegisterView registerView;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
    private String month, year, user, place, belopp,s;
    private Date date;

    public void getResultFromView(String[] result) throws ParseException {
        month = result[0];
        year = result[1];
        user = result[2];
        date = sdf.parse(result[3]);
        place = result[4];
        belopp = result[5];
        s = "; ";
        System.out.println(month + s + year +s + user + s + sdf.format(date) + s + place + s + belopp);
    }

}
