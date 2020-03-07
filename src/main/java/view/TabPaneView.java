package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.control.Tab;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TabPaneView extends Application {
    private GridPane regGrid, calGrid, hisGrid;

    public void start(Stage primaryStage) {
        regGrid = new RegisterPane().getGrid();
        calGrid = new CalculatorPane().getGrid();
      //  hisGrid = new HistoryPane().getGrid();

        TabPane tabPane = new TabPane();

        Tab tab1 = new Tab("Registrering",regGrid);
        Tab tab2 = new Tab("Räkna ut din skuld",calGrid);
        Tab tab3 = new Tab("Senaste inköp");

        tabPane.getTabs().add(tab1);
        tabPane.getTabs().add(tab2);
        tabPane.getTabs().add(tab3);

        VBox vBox = new VBox(tabPane);
        Scene scene = new Scene(vBox);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Kassaboken 1.0v");

        primaryStage.show();
    }
}
