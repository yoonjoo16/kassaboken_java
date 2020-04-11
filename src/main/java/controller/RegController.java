package controller;

import com.google.api.services.sheets.v4.model.AppendValuesResponse;
import com.google.api.services.sheets.v4.model.ValueRange;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;

public class RegController extends Controller{
    private static String[] resultFromView;

    protected static void parseFile(String[] result) throws IOException, GeneralSecurityException, ParseException {
        parseForReg(result);
        ValueRange response = sheets.spreadsheets().values()
                .get(yearlySheet, month)
                .execute();
        List<List<Object>> values = response.getValues();
        if (values == null || values.isEmpty()) {
            System.out.println("No data found.");
        } else {
            for (List row : values) {
                // Print columns A and E, which correspond to indices 0 and 4.
                System.out.printf("%s, %s, %s, %s\n", row.get(0), row.get(1), row.get(2), row.get(3));
            }
        }
    }

    public static void appendFile(String[] result) throws IOException, GeneralSecurityException, ParseException {
        parseForReg(result);
        ValueRange appendBody = new ValueRange();
        if(user.equals("Erik")) {
            //appendBody.setValues(Arrays.asList(Arrays.asList("this","is","from","the","code")));
            appendBody.setValues(Arrays.asList(Arrays.asList(sdf2.format(date),place,belopp,"0","")));

        } else {
            appendBody.setValues(Arrays.asList(Arrays.asList(sdf2.format(date),place,"0",belopp,"")));
        }
        AppendValuesResponse appendResult = sheets.spreadsheets().values()
                .append(yearlySheet, month,appendBody)
                .setValueInputOption("USER_ENTERED")
                .setInsertDataOption("INSERT_ROWS")
                .setIncludeValuesInResponse(true)
                .execute();
    }

    private static void parseForReg(String[] result) throws IOException, GeneralSecurityException, ParseException {
        sheets = getSheets();
        resultFromView = result;
        month = result[0];
        yearlySheet = chooseYear(result[1]);
        user = result[2];
        date = sdf1.parse(result[3]);
        place = result[4];
        belopp = result[5];
    }
}
