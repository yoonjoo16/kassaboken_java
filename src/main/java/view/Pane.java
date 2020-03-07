package view;

import controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public abstract class Pane {
    protected GridPane grid;
    protected ComboBox selectMonth, selectYear;
    protected ToggleGroup userButtonGroup;
    protected RadioButton erik, yoonjoo;
    protected TextField date, belopp;
    protected Controller controller;

    protected void makePane() {
        grid = new GridPane();
        makeTextForDateAndBelopp();
        makeMonthList();
        makeYearList();
        makeButtonsSelectingUser();
    }

    private void makeTextForDateAndBelopp() {
        date = new TextField();
        belopp = new TextField();
        date.setPrefWidth(10);
        belopp.setPrefWidth(10);
        date.setOnKeyTyped(event -> {
            int maxCharacters = 6;
            if(date.getText().length() > maxCharacters) event.consume();
        });
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

    private void makeYearList() {
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

    public GridPane getGrid() {
        return grid;
    }

    private void makeButtonsSelectingUser() {
        userButtonGroup = new ToggleGroup();
        erik = new RadioButton("Erik");
        erik.setToggleGroup(userButtonGroup);
        erik.setSelected(true);
        yoonjoo = new RadioButton("Yoonjoo");
        yoonjoo.setToggleGroup(userButtonGroup);
    }

   protected abstract void makeGrid();



}
