package view;

import model.Edge;
import model.Point2D;
import model.Point3D;
import model.VirtualObject;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Map;

public class CameraPanel extends JPanel {
    private static final double START_DISTANCE = 300;
    private static final int ZOOM_STEP = 5;

    private static final int STEP = 1;
    private static final double ROTATION_STEP = Math.toRadians(1.0);

    private double distance;
    private List<Point3D> transformedCoordinates;
    private Map<Integer, Point2D> projectedCoordinates;
    private List<Edge> connections;

    private GeometricUtils geometricUtils;

    public CameraPanel(VirtualObject virtualObject) {
        this.distance = START_DISTANCE;
        this.connections = virtualObject.getConnections();
        this.transformedCoordinates = virtualObject.getPoints();
        this.geometricUtils = new GeometricUtils();

        this.setBackground(Color.BLACK);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        g2D.setPaint(Color.WHITE);

        projectedCoordinates = geometricUtils.getPerspectiveProjection(transformedCoordinates, distance);
        System.out.println(distance);
        for (Edge lineToDraw : connections) {
            Integer pointAId = lineToDraw.getPointA().getId();
            Integer pointBId = lineToDraw.getPointB().getId();
            if (geometricUtils.edgeVisible(findPoint3DById(pointAId), findPoint3DById(pointBId))) {
                Point2D pointA = projectedCoordinates.get(pointAId);
                Point2D pointB = projectedCoordinates.get(pointBId);
                g2D.drawLine(getRoundedInt(pointA.getX()), getRoundedInt(pointA.getY()),
                        getRoundedInt(pointB.getX()), getRoundedInt(pointB.getY()));
            }
        }
    }

    private Point3D findPoint3DById(Integer id) {
        return transformedCoordinates.stream().filter(point3D -> point3D.getId().equals(id)).findFirst().orElseThrow();
    }

    private int getRoundedInt(double number) {
        return (int) Math.ceil(number);
    }

    public void moveBackwards() {
        for (Point3D coordinateToTransform : transformedCoordinates) {
            coordinateToTransform.setZ(coordinateToTransform.getZ() + STEP);
        }
    }

    public void moveForward() {
        for (Point3D coordinateToTransform : transformedCoordinates) {
            coordinateToTransform.setZ(coordinateToTransform.getZ() - STEP);
        }
    }

    public void moveRight() {
        for (Point3D coordinateToTransform : transformedCoordinates) {
            coordinateToTransform.setX(coordinateToTransform.getX() - STEP);
        }
    }

    public void moveLeft() {
        for (Point3D coordinateToTransform : transformedCoordinates) {
            coordinateToTransform.setX(coordinateToTransform.getX() + STEP);
        }
    }

    public void moveUp() {
        for (Point3D coordinateToTransform : transformedCoordinates) {
            coordinateToTransform.setY(coordinateToTransform.getY() + STEP);
        }
    }

    public void moveDown() {
        for (Point3D coordinateToTransform : transformedCoordinates) {
            coordinateToTransform.setY(coordinateToTransform.getY() - STEP);
        }
    }

    public void lookDown() {
        for (Point3D coordinateToTransform : transformedCoordinates) {
            rotateXLeft(coordinateToTransform);
        }
    }

    private void rotateXLeft(Point3D coordinateToTransform) {
        geometricUtils.rotateX(coordinateToTransform, ROTATION_STEP);
    }

    public void lookUp() {
        for (Point3D coordinateToTransform : transformedCoordinates) {
            rotateXRight(coordinateToTransform);
        }
    }

    private void rotateXRight(Point3D coordinateToTransform) {
        geometricUtils.rotateX(coordinateToTransform, -ROTATION_STEP);
    }

    public void lookLeft() {
        for (Point3D coordinateToTransform : transformedCoordinates) {
            rotateYLeft(coordinateToTransform);
        }
    }

    private void rotateYLeft(Point3D coordinateToTransform) {
        geometricUtils.rotateY(coordinateToTransform, ROTATION_STEP);
    }

    public void lookRight() {
        for (Point3D coordinateToTransform : transformedCoordinates) {
            rotateYRight(coordinateToTransform);
        }
    }

    private void rotateYRight(Point3D coordinateToTransform) {
        geometricUtils.rotateY(coordinateToTransform, -ROTATION_STEP);
    }

    public void rotateLeft() {
        for (Point3D coordinateToTransform : transformedCoordinates) {
            rotateZLeft(coordinateToTransform);
        }
    }

    private void rotateZLeft(Point3D coordinateToTransform) {
        geometricUtils.rotateZ(coordinateToTransform, ROTATION_STEP);
    }

    public void rotateRight() {
        for (Point3D coordinateToTransform : transformedCoordinates) {
            rotateZRight(coordinateToTransform);
        }
    }

    private void rotateZRight(Point3D coordinateToTransform) {
        geometricUtils.rotateZ(coordinateToTransform, -ROTATION_STEP);
    }

    public void zoomIn() {
        distance += ZOOM_STEP;
    }

    public void zoomOut() {
        distance -= ZOOM_STEP;
    }
}
