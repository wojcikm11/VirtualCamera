package view;

import model.Point2D;
import model.Point3D;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProjectionUtils {
    public Map<Integer, Point2D> getPerspectiveProjection(List<Point3D> realCoordinates, double distance) {
        Map<Integer, Point2D> perspectiveCoordinates = new HashMap<>();
        for (Point3D realPoint : realCoordinates) {
            Point2D transformedPoint = getTransformedPoint(realPoint, distance);
            perspectiveCoordinates.put(realPoint.getId(), transformedPoint);
        }
        return perspectiveCoordinates;
    }

    private Point2D getTransformedPoint(Point3D point, double distance) {
        double x_Transformed;
        double y_Transformed;

        x_Transformed = point.getX() * distance / point.getZ();
        y_Transformed = point.getY() * distance / point.getZ();

        return new Point2D(x_Transformed, y_Transformed);
    }
}
