package view;

import controller.RegisterController;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Pane {
    private GridPane grid;
    private ComboBox selectMonth, selectYear;
    private ToggleGroup userButtonGroup, placeButtonGroup;
    private RadioButton erik, yoonjoo, ica, lidl, systemet, pizza, pub, annat;
    private TextField date, place, belopp;
    private Button regButton;
    private RegisterController regController;

    public Pane() {
        grid = new GridPane();
        regController = new RegisterController();
        makeTextFields();
        makeSelectBoxMonthAndYear();
        makeButtonsSelectingUser();
        makeButtonsSelectingPlace();
        makeRegisterButton();
        makeGrid();
    }

    public GridPane getGrid() {
        return grid;
    }

    private void makeTextFields() {
        date = new TextField();
        place = new TextField();
        belopp = new TextField();

        date.setPrefWidth(10);
        place.setMinWidth(15);
        belopp.setPrefWidth(10);

        date.setOnKeyTyped(event -> {
            int maxCharacters = 6;
            if(date.getText().length() > maxCharacters) event.consume();
        });

        place.setDisable(true);

    }

    private void makeSelectBoxMonthAndYear() {
        selectMonth = new ComboBox();
        selectMonth.getItems().addAll(
                "januari",
                "februari",
                "mars",
                "april",
                "maj",
                "juni",
                "juli",
                "augusti",
                "september",
                "oktober",
                "november",
                "december"
        );
        selectMonth.setValue("mars");

        selectYear = new ComboBox();
        selectYear.getItems().addAll(
                "2020",
                "2019",
                "2018",
                "2017",
                "2016"
        );
        selectYear.setValue("2020");
    }

    private void makeButtonsSelectingUser() {
        userButtonGroup = new ToggleGroup();

        erik = new RadioButton("Erik");
        erik.setToggleGroup(userButtonGroup);
        erik.setSelected(true);

        yoonjoo = new RadioButton("Yoonjoo");
        yoonjoo.setToggleGroup(userButtonGroup);
    }

    private void makeButtonsSelectingPlace() {
        placeButtonGroup = new ToggleGroup();

        lidl = new RadioButton("Lidl");
        ica = new RadioButton("ICA");
        systemet = new RadioButton("Systemet");
        pizza = new RadioButton("Pizza");
        pub = new RadioButton("Pub");
        annat = new RadioButton("Annat");

        lidl.setToggleGroup(placeButtonGroup);
        ica.setToggleGroup(placeButtonGroup);
        systemet.setToggleGroup(placeButtonGroup);
        pizza.setToggleGroup(placeButtonGroup);
        pub.setToggleGroup(placeButtonGroup);
        annat.setToggleGroup(placeButtonGroup);

        lidl.setOnAction(event -> {
            if (lidl.isSelected()) {
                place.setDisable(true);
            }
        });

        ica.setOnAction(event -> {
            if (ica.isSelected()) {
                place.setDisable(true);
            }
        });

        systemet.setOnAction(event -> {
            if (systemet.isSelected()) {
                place.setDisable(true);
            }
        });

        pizza.setOnAction(event -> {
            if (pizza.isSelected()) {
                place.setDisable(true);
            }
        });

        pub.setOnAction(event -> {
            if (pub.isSelected()) {
                place.setDisable(true);
            }
        });

        annat.setOnAction(event -> {
            if (annat.isSelected()) {
                place.setDisable(false);
            }
        });

        lidl.setSelected(true);
    }

    private void makeRegisterButton() {
        regButton = new Button("Register");
        regButton.setOnAction(event -> {
            try {
                regController.getResultFromView(getResult());
            } catch (NullPointerException | ParseException e) {
                System.out.println(e.toString());
            } catch (GeneralSecurityException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void makeGrid() {
        grid.setVgap(4);
        grid.setHgap(10);
        grid.setPadding(new Insets(5, 5, 5, 5));
        grid.addRow(0, new Label("Månad: "), selectMonth, new Label("År: "), selectYear);
        grid.addRow(1, new Label("Vem har betalat? "), erik, yoonjoo);
        grid.addRow(2, new Label("Datum (YYMMDD)"), date);
        grid.addRow(3, lidl, ica, systemet);
        grid.addRow(4, pizza, pub,annat, place);
        grid.addRow(5, new Label("Belopp"), belopp);
        grid.addRow(8,regButton);
    }

    private String[] getResult() {
        String[] result = new String[6];
        result[0] = selectMonth.getValue().toString().substring(0,3);
        result[1] = selectYear.getValue().toString();
        result[2] = ((RadioButton) userButtonGroup.getSelectedToggle()).getText();
        if(!date.getText().trim().isEmpty()) {
            result[3] = date.getText();
        }else {
            throw new NullPointerException("Skriv ett datum");
        }
        String getPlats = ((RadioButton) placeButtonGroup.getSelectedToggle()).getText();
        if(getPlats.equals("Annat") && !place.getText().trim().isEmpty()) {
                result[4] = place.getText();
        }else {
            result[4] = getPlats;
        }
        if(!belopp.getText().trim().isEmpty()) {
            result[5] = belopp.getText();
        }else {
            throw new NullPointerException("Skriv rätt belopp!");
        }
        return result;
    }
}
