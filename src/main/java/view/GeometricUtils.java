package view;

import model.Point2D;
import model.Point3D;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GeometricUtils {
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

    public void rotateX(Point3D coordinateToTransform, double rotationStep) {
        double cosine = Math.cos(rotationStep);
        double sine = Math.sin(rotationStep);
        double Y = coordinateToTransform.getY();
        double Z = coordinateToTransform.getZ();
        coordinateToTransform.setY(Y * cosine - Z * sine);
        coordinateToTransform.setZ(Y * sine + Z * cosine);
    }

    public void rotateY(Point3D coordinateToTransform, double rotationStep) {
        double cosine = Math.cos(rotationStep);
        double sine = Math.sin(rotationStep);
        double X = coordinateToTransform.getX();
        double Z = coordinateToTransform.getZ();
        coordinateToTransform.setX(X * cosine + Z * sine);
        coordinateToTransform.setZ(-X * sine + Z * cosine);
    }

    public void rotateZ(Point3D coordinateToTransform, double rotationStep) {
        double cosine = Math.cos(rotationStep);
        double sine = Math.sin(rotationStep);
        double X = coordinateToTransform.getX();
        double Y = coordinateToTransform.getY();
        coordinateToTransform.setX(X * cosine - Y * sine);
        coordinateToTransform.setY(X * sine + Y * cosine);
    }
}
