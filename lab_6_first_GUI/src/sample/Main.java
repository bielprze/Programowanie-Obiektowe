package sample;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Tooltip;
import javafx.scene.control.CheckBox;

import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Main extends Application {

    @Override
    public void start(Stage stage) {

        initUI(stage);
    }
    private void initUI(Stage stage) {


        VBox root = new VBox();
        Scene scene = new Scene(root, 600, 600);

        Label lbl = new Label("First JavaFX app");
        lbl.setFont(Font.font("Serif", FontWeight.NORMAL, 55));

        CheckBox cbox = new CheckBox("Are you sure you want to quit?");
        cbox.setSelected(true);

        Button btn = new Button();
        btn.setText("Quit");
        btn.setOnAction((ActionEvent event) -> {
            if(cbox.isSelected())
                Platform.exit();
            else
                lbl.setText("Cannot quit while checbox is unchecked");
        });
        Tooltip tooltip = new Tooltip("Click to quit");
        Tooltip.install(btn, tooltip);

        lbl.setId("text");
        root.setId("root");

        root.setPadding(new Insets(25));
        root.getChildren().addAll(lbl);
        root.getChildren().addAll(cbox);
        root.getChildren().addAll(btn);


        scene.getStylesheets().add(this.getClass().getResource("text.css")
                .toExternalForm());

        stage.setTitle("Lab 6 - GUI");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
