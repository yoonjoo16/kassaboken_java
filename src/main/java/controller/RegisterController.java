package controller;

import com.google.api.services.sheets.v4.Sheets;
import view.Pane;
import view.RegisterView;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RegisterController {

    public void getResultFromView(String[] result) throws ParseException, IOException, GeneralSecurityException {
        SheetParser.parseFile(result);
        SheetParser.appendFile(result);
    }

}
