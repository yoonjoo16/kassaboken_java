package controller;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.AppendValuesResponse;
import com.google.api.services.sheets.v4.model.ValueRange;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public abstract class Controller {
        private static final String APPLICATION_NAME = "Google Sheets API Java Quickstart";
        private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
        private static final String TOKENS_DIRECTORY_PATH = "tokens";
        protected static String yearlySheet;
        protected static String month;
        protected static String user;
        protected static Date date;
        protected static SimpleDateFormat sdf1 = new SimpleDateFormat("yyMMdd");
        protected static SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
        protected static String place;
        protected static String belopp;
        protected static Sheets sheets;
        private static final List<String> SCOPES = Arrays.asList(SheetsScopes.SPREADSHEETS);
        private static final String CREDENTIALS_FILE_PATH = "/credentials.json";


        private static Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT) throws IOException {
            // Load client secrets.
            InputStream in = controller.Controller.class.getResourceAsStream(CREDENTIALS_FILE_PATH);
            if (in == null) {
                throw new FileNotFoundException("Resource not found: " + CREDENTIALS_FILE_PATH);
            }
            GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

            // Build flow and trigger user authorization request.
            GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                    HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                    .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
                    .setAccessType("offline")
                    .build();
            LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8888).build();
            return new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
        }

        public static Sheets getSheets() throws IOException, GeneralSecurityException {
            // Build a new authorized API client service.
            final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
            return new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                    .setApplicationName(APPLICATION_NAME)
                    .build();
        }

        protected static String chooseYear(String s) {
            switch (s) {
                case "2020": return "1QXKm1Owr4q3sVJDp7gMPETepOwVVL7TwGkBPkE215BM";
                case "2019": return "19gRMtfevqq6RTOnpFNjsa-b-JU6SQ4e0083sYSwf9aI";
                case "2018": return "1KCW3T41h8bI2bjrc8K5D-izx65w31ujzAnN42HgAc6k";
                case "2017": return "1zsYahagz95MG5m9SfvAmWWWLDD4pP4xWJC_ckPVQa3w";
                case "2016": return "1RzPcE6fYP76f3dQwVRtsKS0nKoBshKo-kFp5gWPgt7E";
                default:
                    throw new IllegalStateException("Unexpected value: " + s);
            }
        }
}
