package view;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public abstract class Pane {
    protected GridPane grid;    //
    protected ComboBox selectYear; //
    protected ToggleGroup userButtonGroup; //
    protected RadioButton erik, yoonjoo; //
    protected TextField date, belopp; //

    protected void makePane() {
        grid = new GridPane();
        makeTextForDateAndBelopp();
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

   protected abstract void makeGrid() ;


}
