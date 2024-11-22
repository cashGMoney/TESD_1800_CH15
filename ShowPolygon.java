import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class ShowPolygon extends Application {

    @Override 
    public void start(Stage primaryStage) {

        // Create a parent Pane
        Pane root = new Pane();

        // Add a rectangle to the pane
        Rectangle rectangle = new Rectangle(40, 30, 40, 30);
        rectangle.setFill(Color.GREY);
        rectangle.setStroke(Color.BLACK);

        // Position the rectangle


        // Add the MyPolygon element to the same pane
        MyPolygon polygonPane = new MyPolygon();
        polygonPane.setPrefSize(400, 400); // Ensure it matches the scene size

        // Add both elements to the root Pane
        root.getChildren().addAll(polygonPane, rectangle);

        // Apply a fade transition to ellipse
        FadeTransition ft = new FadeTransition(Duration.seconds(8), rectangle);
        ft.setFromValue(1.0);
        ft.setToValue(0.1);
        ft.setCycleCount(Timeline.INDEFINITE);
        ft.setAutoReverse(true);
        ft.play();

        // Create polygon path for rectangle
        Polygon polygon2 = new Polygon();
        ObservableList<Double> list = polygon2.getPoints();

        double centerX = 195;
        double centerY = 195;
        double radius = 150;

        // Add points to the polygon list
        for (int i = 0; i < 5; i++) {
            list.add(centerX + radius * Math.cos(2 * i * Math.PI / 5));
            list.add(centerY - radius * Math.sin(2 * i * Math.PI / 5));
        }

        // Make the path for the rectangle follow the polygonPane
        PathTransition pt = new PathTransition(Duration.seconds(8), polygon2, rectangle);
        pt.setCycleCount(Timeline.INDEFINITE);
        pt.setAutoReverse(true);
        pt.play();

        // Toggle animation on mouse click
        rectangle.setOnMouseClicked(e -> {
            if (ft.getStatus() == Timeline.Status.RUNNING) {
                ft.pause();
                pt.pause();
            } else {
                ft.play();
                pt.play();
            }
        });

        // Create a scene and place it in the stage
        Scene scene = new Scene(root, 400, 400);
        primaryStage.setTitle("Pentagon with Rectangle"); 
        primaryStage.setScene(scene); 
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}

/* --- Unused Code ----

        // Create a path transition
        PathTransition pt = new PathTransition();
        pt.setDuration(Duration.millis(4000));
        pt.setPath();
        pt.setNode(rectangle);
        pt.setOrientation(
        PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pt.setCycleCount(Timeline.INDEFINITE);
        pt.setAutoReverse(true);
        pt.play();

 */