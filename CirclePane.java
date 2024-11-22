import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class CirclePane extends StackPane {
    private Circle circle = new Circle(50);  // Circle with an initial radius of 50

    public CirclePane() {
        getChildren().add(circle);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.WHITE);

        // Set the preferred size of the pane to ensure the circle is within visible bounds
        setPrefSize(300, 300);
    }

    // Get X coordinate of the circle's translation
    public double getX() {
        return circle.getTranslateX();
    }

    // Set X coordinate of the circle's translation
    public void setX(double x) {
        circle.setTranslateX(x);
    }

    // Get Y coordinate of the circle's translation
    public double getY() {
        return circle.getTranslateY();
    }

    // Set Y coordinate of the circle's translation
    public void setY(double y) {
        circle.setTranslateY(y);
    }
    
    // Return the radius of the circle
    public double getCircleRadius() {
        return circle.getRadius();
    }
}






/*

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class CirclePane extends StackPane {
    private Circle circle = new Circle(50);  // Circle with initial radius of 50

    public CirclePane() {
        getChildren().add(circle);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.WHITE);
    }

    public void enlarge() {
        circle.setRadius(circle.getRadius() + 2);  // Increase the radius
    }

    public void shrink() {
        circle.setRadius(circle.getRadius() > 2 ? circle.getRadius() - 2 : circle.getRadius());  // Decrease the radius, but not below 2
    }
}

 */