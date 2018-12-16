package hist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Histogram extends Application {

    Label lbl_xseries;
    Label lbl_yseries;
    TextField tfield_xseries;
    TextField tfield_yseries;
    Button btn_draw;

    BorderPane layout;
    VBox fields;

    private BarChart<String, Number> chart(String[] xs, float[] ys) {
        CategoryAxis new_xAxis = new CategoryAxis();
        new_xAxis.setCategories(FXCollections.observableArrayList(Arrays.asList(xs)));

        //new_xAxis.setLabel("xAxis");
        NumberAxis new_yAxis = new NumberAxis();

        //new_yAxis.setLabel("yAxis");

        BarChart<String, Number> newBarChart = new BarChart<>(new_xAxis, new_yAxis);

        newBarChart.setLegendVisible(false);

        XYChart.Series<String, Number> series = new XYChart.Series<>();

        for (int i=0; i < ys.length; ++i) {
            series.getData().add(new XYChart.Data(xs[i], ys[i]));
        }

        newBarChart.getData().addAll(series);

        return newBarChart;

    }


    @Override
    public void start(Stage stage) {

        layout = new BorderPane();
        fields = new VBox(5);


        //Defining the axes
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setCategories(FXCollections.<String>observableArrayList(Arrays.asList
                ("a", "b", "c", "d", "e","f","g","h","i")));

        //xAxis.setLabel("xAxis");
        NumberAxis yAxis = new NumberAxis();

        //yAxis.setLabel("yAxis");

        //Creating the Bar chart
        BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
        //barChart.setTitle("Histogram");

        //Prepare XYChart.Series objects by setting data
        XYChart.Series<String, Number> series1 = new XYChart.Series<>();
        barChart.setLegendVisible(false);
        //series1.setName("1800");
        series1.getData().add(new XYChart.Data<>("a", 5));
        series1.getData().add(new XYChart.Data<>("b", 1));
        series1.getData().add(new XYChart.Data<>("c", 4));
        series1.getData().add(new XYChart.Data<>("d", 3));
        series1.getData().add(new XYChart.Data<>("e", 9));
        series1.getData().add(new XYChart.Data<>("f", 6));
        series1.getData().add(new XYChart.Data<>("g", 2));
        series1.getData().add(new XYChart.Data<>("h", 8));
        series1.getData().add(new XYChart.Data<>("i", 7));

        //Setting the data to bar chart
        barChart.getData().addAll(series1);
        layout.setLeft(barChart);

        lbl_xseries = new Label("Wprowadź x");
        tfield_xseries = new TextField();
        tfield_xseries.setPromptText("a,b,c,d,e,f,g,h,i");
        tfield_xseries.setFocusTraversable(false);

        lbl_yseries = new Label("Wprowadź y");
        tfield_yseries = new TextField();
        tfield_yseries.setPromptText("5,1,4,3,9,0,2,8,7");
        tfield_yseries.setFocusTraversable(false);

        btn_draw = new Button("Rysuj");
        //btn_draw.setFocusTraversable(false);
        btn_draw.setOnAction(actionEvent -> {
            //int count = tfield_xseries.getText().length() - tfield_xseries.getText().replace(",", "").length();//tyle jest przecinków

            //layout.getChildren().remove(barChart);

            String tfx = tfield_xseries.getText();
            String tfy = tfield_yseries.getText();

            String[] xs = tfx.split(",");
            String[] ys = tfy.split(",");
            float[] ys_= new float[ys.length];
            for (int i = 0; i < ys.length; ++i)
                ys_[i] = Float.valueOf(ys[i]);

            //for (int i = 0; i < ys.length; ++i)
            //    System.out.println(xs[i]+" "+ys_[i]);


            BarChart newbarChart = chart(xs, ys_);
            layout.setLeft(newbarChart);

        });

        fields.getChildren().addAll(lbl_xseries,tfield_xseries,lbl_yseries,tfield_yseries,btn_draw);

        layout.setRight(fields);


        Group root = new Group(layout);
        Scene scene = new Scene(root, 675, 400);
        stage.setTitle("Histogram");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String args[]){
        launch(args);
    }
}