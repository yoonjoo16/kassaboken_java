package view;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

@SuppressWarnings("checkstyle:Indentation")
public class RegisterView extends Application {
    private GridPane grid;
    private ComboBox selectMonth, selectYear;
    private ToggleGroup userButtonGroup, placeButtonGroup;
    private RadioButton erik, yoonjoo, ica, lidl, systemet, pizza, pub, annat;
    private TextField date, place, belopp;
    private Button regButton;

    @Override
    public void start(Stage stage) {
        stage.setTitle("Registrering");
        Scene scene = new Scene(new Group(), 550, 300);
        grid = new Pane().getGrid();
        Group root = (Group)scene.getRoot();
        root.getChildren().add(grid);
        stage.setScene(scene);
        stage.show();
    }
}
