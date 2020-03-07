package controller;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.text.ParseException;

public class RegController extends Controller{
    public void appendLine(String[] result) throws ParseException, IOException, GeneralSecurityException {
        SheetParser.parseFile(result);
        SheetParser.appendFile(result);
    }

    public void readSheetAndGetSum() {

    }
}
