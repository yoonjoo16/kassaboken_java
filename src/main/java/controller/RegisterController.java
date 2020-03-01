package controller;

import view.Pane;
import view.RegisterView;

public class RegisterController {
    private RegisterView registerView;
    private String month, year, user, date, place, belopp,s;

    public void getResultFromView(String[] result) {
        month = result[0];
        year = result[1];
        user = result[2];
        date = result[3];
        place = result[4];
        belopp = result[5];
        s = "; ";

        System.out.println(month + s + year +s + user + s + date + s + place + s + belopp);
    }

}
