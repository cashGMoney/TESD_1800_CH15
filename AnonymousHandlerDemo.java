import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class AnonymousHandlerDemo extends Application {
    // Use this CirclePane in the layout
    private CirclePane circlePane = new CirclePane();  

    @Override
    public void start(Stage primaryStage) {
        // Use circlePane directly in the center of the BorderPane
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(circlePane);

        // Hold four buttons in an HBox 
        Button btUp = new Button("Up");
        Button btDown = new Button("Down");
        Button btLeft = new Button("Left");
        Button btRight = new Button("Right");
        HBox hBox = new HBox(btUp, btDown, btLeft, btRight);
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER);

        borderPane.setBottom(hBox);

        // Create and register the handlers
        btUp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                // Check if moving up is going off scene
                if (circlePane.getY() - 5 >= -circlePane.getHeight() / 2 + circlePane.getCircleRadius()) {
                    circlePane.setY(circlePane.getY() - 5);
                }
            }
        });

        btDown.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                // Check if moving down is going off scene
                if (circlePane.getY() + 5 <= circlePane.getHeight() / 2 - circlePane.getCircleRadius()) {
                    circlePane.setY(circlePane.getY() + 5);
                }
            }
        });

        btLeft.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                // Check if moving left is going off scene
                if (circlePane.getX() - 5 >= -circlePane.getWidth() / 2 + circlePane.getCircleRadius()) {
                    circlePane.setX(circlePane.getX() - 5);
                }
            }
        });

        btRight.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                // Check if moving right is going off scene
                if (circlePane.getX() + 5 <= circlePane.getWidth() / 2 - circlePane.getCircleRadius()) {
                    circlePane.setX(circlePane.getX() + 5);
                }
            }
        });

        // Create a scene and place it in the stage
        Scene scene = new Scene(borderPane, 300, 300);
        primaryStage.setTitle("Exercise15_Listeners");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args); // Launch the application
    }
}



/* 
--------------------- UNUSED CODE -----------------------------
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ControlCircleWithoutEventHandling extends Application {
    // Use this CirclePane in the layout
    private CirclePane circlePane = new CirclePane();  

    @Override
    public void start(Stage primaryStage) {
        // Use circlePane directly in the center of the BorderPane
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(circlePane);

        // Create buttons and set their actions
        HBox hBox = new HBox(10);  // 10px spacing
        hBox.setAlignment(Pos.CENTER);
        Button btEnlarge = new Button("Enlarge");
        Button btShrink = new Button("Shrink");
        hBox.getChildren().addAll(btEnlarge, btShrink);

        // Add handlers to the buttons
        btEnlarge.setOnAction(e -> circlePane.enlarge());
        btShrink.setOnAction(e -> circlePane.shrink());

        borderPane.setBottom(hBox);
        BorderPane.setAlignment(hBox, Pos.CENTER);

        // Create a scene and place it in the stage
        Scene scene = new Scene(borderPane, 300, 250);
        primaryStage.setTitle("Control Circle"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    public static void main(String[] args) {
        launch(args); // Launch the application
    }
}

// (Move the ball) You will write a program that moves the ball in a pane. 
// You should define a pane class for displaying the ball
// provide the methods for moving the ball left, right, up, and down, as shown below. 
// Check the boundary to prevent the ball from moving out of sight completely.

 */