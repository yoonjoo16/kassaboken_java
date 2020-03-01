package view;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Register extends Application {
        private Scene scene;
        private Button regButton;
        private TextField nbrField;
        private VBox vbox;
        private HBox hbox, hbox2;
        private ComboBox selectMonth, selectYear;

        @Override
        public void start(Stage stage) {
            stage.setTitle("Registrering");
            Scene scene = new Scene(new Group(), 450, 250);

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
            selectMonth.setValue("januari");

            selectYear = new ComboBox();
            selectYear.getItems().addAll(
                    "2020",
                    "2019",
                    "2018",
                    "2017",
                    "2016"
            );
            selectYear.setValue("2020");

            GridPane grid = new GridPane();
            grid.setVgap(4);
            grid.setHgap(10);
            grid.setPadding(new Insets(5, 5, 5, 5));
            grid.add(new Label("Month: "), 0, 0);
            grid.add(selectMonth, 1, 0);
            grid.add(new Label("Year: "), 2, 0);
            grid.add(selectYear, 3, 0);
            grid.add(new Label("Subject: "), 0, 1);
            grid.add(new Label("Subject: "), 0, 1);

            Group root = (Group)scene.getRoot();
            root.getChildren().add(grid);
            stage.setScene(scene);
            stage.show();

        }
    }
