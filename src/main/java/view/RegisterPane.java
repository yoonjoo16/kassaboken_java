package view;

import controller.Controller;
import controller.RegController;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.text.ParseException;

public class RegisterPane extends Pane {
    private ComboBox selectMonth;
    private ToggleGroup placeButtonGroup;
    private RadioButton ica, lidl, systemet, pizza, pub, annat;
    private TextField place;
    private Button regButton;
    private Controller controller;
    private RegController regController;

    public RegisterPane() {
        controller = new RegController();
        makePane();
        makeTextForPlace();
        makeMonthList();
        makeButtonsSelectingPlace();
        makeRegisterButton();
        makeGrid();
    }



    private void makeTextForPlace() {
        place = new TextField();
        place.setMinWidth(15);
        place.setDisable(true);
    }

    private void makeMonthList(){
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
                regController.appendLine(getResult());
            } catch (NullPointerException | ParseException e) {
                System.out.println(e.toString());
            } catch (GeneralSecurityException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    protected void makeGrid() {
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
