import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class Algorithms extends Application {
    private static XYChart.Series insertionSortSeries = new XYChart.Series();
    private static XYChart.Series quickSortSeries = new XYChart.Series();
    private static XYChart.Series countingSortSeries = new XYChart.Series();
    private static XYChart.Series mergeSortSeries = new XYChart.Series();
    private static XYChart.Series introSortSeries = new XYChart.Series();


    public static void main(String args[]) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)  {
        primaryStage.setTitle("Algorithm Performance");
        //defining the axes
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Input size n");
        yAxis.setLabel("Run time in ms");

        //creating the chart
        final LineChart<Number, Number> lineChart =
                new LineChart<>(xAxis, yAxis);

        lineChart.setTitle("Algorithm Performance");
        //defining a series
        insertionSortSeries.setName("Insertion Sort");
        quickSortSeries.setName("Quick Sort");
        countingSortSeries.setName("Counting Sort");
        mergeSortSeries.setName("Merge Sort");
        introSortSeries.setName("Intro Sort");

        System.out.println("Performance results:\n");
        int[] keyValues = new int[]{100, 500, 1000, 1500, 3000, 5000, 7000, 10000, 12500, 15000, 17500,20000, 25000, 30000};
        for (int key : keyValues) {
            insertionSortSeries.getData().add(new XYChart.Data(key, Utils.getAverageTimeFor(Utils.INSERTION_SORT, Utils.getRandomArray(key))));
            quickSortSeries.getData().add(new XYChart.Data(key, Utils.getAverageTimeFor(Utils.QUICK_SORT, Utils.getRandomArray(key))));
            countingSortSeries.getData().add(new XYChart.Data(key, Utils.getAverageTimeFor(Utils.COUNTING_SORT, Utils.getRandomArray(key))));
            mergeSortSeries.getData().add(new XYChart.Data(key, Utils.getAverageTimeFor(Utils.MERGE_SORT, Utils.getRandomArray(key))));
            introSortSeries.getData().add(new XYChart.Data(key, Utils.getAverageTimeFor(Utils.INTRO_SORT, Utils.getRandomArray(key))));

        }
        Scene scene = new Scene(lineChart, 800, 600);
        lineChart.getData().add(insertionSortSeries);
        lineChart.getData().add(quickSortSeries);
        lineChart.getData().add(countingSortSeries);
        lineChart.getData().add(mergeSortSeries);
        lineChart.getData().add(introSortSeries);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}


