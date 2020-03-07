package view;

import controller.CalController;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.shape.HLineTo;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class CalculatorPane extends Pane{
    private Button calButton;
    private Button swishButton;

    public CalculatorPane() {
        super.controller = new CalController();
        makePane();
        makeButtons();
        makeGrid();
    }

    private void makeButtons() {
        calButton = new Button("Calculate!");
        calButton.setOnAction(event -> {
            System.out.println("Done!");
        });
        swishButton = new Button("Swishat!");
        swishButton.setOnAction(event -> {
            System.out.println("Done!");
        });
    }

    @Override
    protected void makeGrid() {
        grid.setVgap(4);
        grid.setHgap(10);
        grid.setPadding(new Insets(10, 10, 10, 10));
        Text rakna = new Text("Räkna ut din skuld!");
        Text swish = new Text("Betala tillbaka!");
        rakna.setStyle("-fx-font-weight: bold");
        swish.setStyle("-fx-font-weight: bold");
        grid.addRow(0, rakna);
        grid.addRow(1, new Label("Månad: "),selectMonth, new Label("År: "), selectYear);
        grid.addRow(2, calButton);
        grid.addRow(3, swish);
        grid.addRow(4, new Label("Vem har swishat? "), erik, yoonjoo);
        grid.addRow(5, new Label("Datum (YYMMDD)"), date);
        grid.addRow(6, new Label("Belopp"), belopp, swishButton);
    }

    private String[] getValuesToCalculate() {
        String[] result = new String[2];
        result[0] = selectMonth.getValue().toString().substring(0,3);
        result[1] = selectYear.getValue().toString();
        return result;
    }

    private String[] getValuesToSwish() {
        String[] result = new String[5];
        result[0] = selectMonth.getValue().toString().substring(0,3);
        result[1] = selectYear.getValue().toString();
        result[2] = ((RadioButton) userButtonGroup.getSelectedToggle()).getText();
        if(!date.getText().trim().isEmpty()) {
            result[3] = date.getText();
        }else {
            throw new NullPointerException("Skriv ett datum");
        }
        result[4] = "Swish";
        if(!belopp.getText().trim().isEmpty()) {
            result[5] = belopp.getText();
        }else {
            throw new NullPointerException("Skriv rätt belopp!");
        }
        return result;
    }

}
