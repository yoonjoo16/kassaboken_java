package view;

import controller.CalController;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class CalculatorPane extends Pane{
    private Button calButton;

    public CalculatorPane() {
        makePane();
        makeCalButton();
        makeGrid();
    }

    private void makeCalButton() {
        calButton = new Button("Calculate!");
        calButton.setOnAction(event -> {
            System.out.println("Done!");
        });
    }

    @Override
    protected void makeGrid() {
        grid.setVgap(4);
        grid.setHgap(10);
        grid.setPadding(new Insets(5, 5, 5, 5));
        grid.addRow(0, new Label("År: "), selectYear,calButton);
        grid.addRow(1, new Label("Vem har swishat? "), erik, yoonjoo);
        grid.addRow(2, new Label("Datum (YYMMDD)"), date);
        grid.addRow(5, new Label("Belopp"), belopp);
    }
}
