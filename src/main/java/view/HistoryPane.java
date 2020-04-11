package view;

import controller.CalController;
import controller.Controller;
import controller.HistoryController;
import controller.RegController;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.text.ParseException;

public class HistoryPane extends Pane {

    public HistoryPane() {
        //super.controller = new HistoryController();
    }


    public GridPane getGrid() {
        return grid;
    }

    @Override
    protected void makeGrid() {

    }


}
