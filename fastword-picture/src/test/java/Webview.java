import javafx.application.Application;
import javafx.beans.binding.ObjectExpression;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Webview extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        NumberAxis xAxis = new NumberAxis();
        xAxis.setLabel("Years");
        //Defining the y axis
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("No.of schools");
        LineChart chart = new LineChart<>(xAxis, yAxis);
        chart.setTitle("测试测试");
        Series<Number, Number> series = new Series<>();
        series.setName("No of schools in an year");
        series.setData(createData());
        chart.getData().add(series);
        Series<Number, Number> series2 = new Series<>();
        series2.setName("No ");
        series2.setData(createData());
        chart.getData().add(series2);
        primaryStage.setScene(new Scene(chart, 600, 400));
        primaryStage.show();
    }

    private static ObservableList<Data<Number,Number>> createData() {
        ObservableList<Data<Number,Number>> list = FXCollections.observableArrayList();
        for (int x = 0; x < 10; x++) {
            Data data = new Data<Number,Number>(Math.pow(x, 2),Math.pow(x, 2),"lllllllllllll");
            data.setNode(createDataNode(data.YValueProperty()));
            list.add(data);
        }
        return list;
    }

    private static Node createDataNode(ObjectExpression<Number> value) {
        Label label = new Label();
        label.textProperty().bind(value.asString("%,.2f"));
        Pane pane = new Pane(label);
        pane.setShape(new Circle(1.0));
        pane.setScaleShape(false);
        label.translateYProperty().bind(label.heightProperty().divide(-1.5));
        return pane;
    }
}
