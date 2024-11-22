
import javafx.collections.ObservableList;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

class MyPolygon extends Pane {
    private void paint() {
        // Create a polygon and place polygon to pane
        Polygon polygon = new Polygon();
        polygon.setFill(Color.WHITE);
        polygon.setStroke(Color.BLACK);
        ObservableList<Double> list = polygon.getPoints();

        double centerX = getWidth() / 2;
        double centerY = getHeight() / 2;
        double radius = Math.min(getWidth(), getHeight()) * 0.4;

        // Add points to the polygon list
        for (int i = 0; i < 5; i++) {
            list.add(centerX + radius * Math.cos(2 * i * Math.PI / 5));
            list.add(centerY - radius * Math.sin(2 * i * Math.PI / 5));
        }

        getChildren().clear();
        getChildren().add(polygon);
    }

    @Override
    public void setWidth(double width) {
        super.setWidth(width);
        paint();
    }

    @Override
    public void setHeight(double height) {
    super.setHeight(height);
    paint();
    }
}