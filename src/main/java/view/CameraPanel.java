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
    private static final int VIEW_WIDTH = 1280;
    private static final int VIEW_HEIGHT = 800;

    private double distance;
    private List<Point3D> realCoordinates;
    private Map<Integer, Point2D> transformedCoordinates;
    private List<Edge> connections;

    private ProjectionUtils projectionUtils;

    public CameraPanel(VirtualObject virtualObject) {
        this.distance = START_DISTANCE;
        this.connections = virtualObject.getConnections();
        this.realCoordinates = virtualObject.getPoints();
        this.projectionUtils = new ProjectionUtils();

        this.setPreferredSize(new Dimension(VIEW_WIDTH, VIEW_HEIGHT));
        this.setBackground(Color.BLACK);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2D = (Graphics2D) g;
        g2D.setPaint(Color.WHITE);

        transformedCoordinates = projectionUtils.getPerspectiveProjection(realCoordinates, distance);

        for (Edge lineToDraw : connections) {
            Point2D pointA = transformedCoordinates.get(lineToDraw.getPointA().getId());
            Point2D pointB = transformedCoordinates.get(lineToDraw.getPointB().getId());
            g2D.drawLine(getRoundedInt(pointA.getX()), getRoundedInt(pointA.getY()),
                         getRoundedInt(pointB.getX()), getRoundedInt(pointB.getY()));
        }
    }

    private int getRoundedInt(double number) {
        return (int) Math.ceil(number);
    }
}
