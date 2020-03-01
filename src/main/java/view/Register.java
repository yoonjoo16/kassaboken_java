package view;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

@SuppressWarnings("checkstyle:Indentation")
public class Register extends Application {
    private ComboBox selectMonth, selectYear;
    private ToggleGroup radioButtonGroup;
    private RadioButton erik, yoonjoo;
    private TextField date = new TextField();
    private TextField place = new TextField();
    private TextField belopp = new TextField();
    private Button regButton = new Button("Register");

    @Override
    public void start(Stage stage) {
        stage.setTitle("Registrering");
        Scene scene = new Scene(new Group(), 550, 300);
        makeSelectBoxMonthAndYear();
        makeRadioButtons();
        GridPane grid = new GridPane();
        grid.setVgap(4);
        grid.setHgap(10);
        grid.setPadding(new Insets(5, 5, 5, 5));
        grid.add(new Label("Månad: "), 0, 0);
        grid.add(selectMonth, 1, 0);
        grid.add(new Label("År: "), 2, 0);
        grid.add(selectYear, 3, 0);
        grid.add(new Label("Vem har betalat? "), 0, 1);
        grid.add(erik, 1,2);
        grid.add(yoonjoo,2,2);
        grid.add(new Label("Datum (ÅÅMMDD)"), 0, 3);
        grid.add(date,1,3);
        grid.add(new Label("Plats"), 0, 4);
        grid.add(place,1,4);
        grid.add(new Label("Belopp"), 0, 5);
        grid.add(belopp,1,5);
        grid.add(regButton,1,7);
        Group root = (Group)scene.getRoot();
        root.getChildren().add(grid);
        stage.setScene(scene);
        stage.show();
    }

    private void makeSelectBoxMonthAndYear() {
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

    private void makeRadioButtons() {
        radioButtonGroup = new ToggleGroup();

        erik = new RadioButton("Erik");
        erik.setToggleGroup(radioButtonGroup);
        erik.setSelected(true);

        yoonjoo = new RadioButton("Yoonjoo");
        yoonjoo.setToggleGroup(radioButtonGroup);
    }
}
