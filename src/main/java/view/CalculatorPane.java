package view;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.shape.HLineTo;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class CalculatorPane extends Pane{
    private Button calButton;
    private Button swishButton;

    public CalculatorPane() {
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
        grid.setPadding(new Insets(5, 5, 5, 5));
        Text rakna = new Text("Räkna ut din skuld!");
        Text swish = new Text("Betala tillbaka!");
        rakna.setStyle("-fx-font-weight: bold");
        swish.setStyle("-fx-font-weight: bold");
        grid.addRow(0, rakna);
        grid.addRow(1, new Label("År: "), selectYear,calButton);
        grid.addRow(2, new Label(""));
        grid.addRow(3, swish);
        grid.addRow(4, new Label("Vem har swishat? "), erik, yoonjoo);
        grid.addRow(5, new Label("Datum (YYMMDD)"), date);
        grid.addRow(6, new Label("Belopp"), belopp, swishButton);
    }

    @Override
    protected String[] getResult() {
        return new String[0];
    }
}
