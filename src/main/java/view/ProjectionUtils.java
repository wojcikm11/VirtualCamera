package view;

import model.Edge;
import model.Point;

import java.util.ArrayList;
import java.util.List;

public class ProjectionUtils {
    public List<Edge> getPerspectiveProjection(List<Edge> realCoordinates, double distance) {
        List<Edge> perspectiveCoordinates = new ArrayList<>();
        for (Edge realConnection : realCoordinates) {
            Point pointA = realConnection.getPointA();
            Point pointB = realConnection.getPointB();

            Point transformedA = getTransformedPoint(pointA, distance);
            Point transformedB = getTransformedPoint(pointB, distance);
            perspectiveCoordinates.add(new Edge(transformedA, transformedB));
        }
        return perspectiveCoordinates;
    }

    private Point getTransformedPoint(Point point, double distance) {
        double x_Transformed;
        double y_Transformed;
        double z_Transformed;

        x_Transformed = point.getX() * distance / point.getZ();
        y_Transformed = point.getY() * distance / point.getZ();
        z_Transformed = distance;

        return new Point(point.getId(), x_Transformed, y_Transformed, z_Transformed);
    }
}
