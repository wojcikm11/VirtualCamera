package view;

import model.Edge;
import model.Point;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class CameraPanel extends JPanel {
    private static final double START_DISTANCE = 300;
    private static final int VIEW_WIDTH = 1280;
    private static final int VIEW_HEIGHT = 800;


    private double distance;
    private List<Edge> realCoordinates;
    private List<Edge> transformedCoordinates;
    private ProjectionUtils projectionUtils;


    public CameraPanel(List<Edge> realCoordinates) {
        this.realCoordinates = realCoordinates;
        this.distance = START_DISTANCE;
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
        for (Edge lineToDraw : transformedCoordinates) {
            Point pointA = lineToDraw.getPointA();
            Point pointB = lineToDraw.getPointB();
            g2D.drawLine(getRoundedInt(pointA.getX()), getRoundedInt(pointA.getY()),
                         getRoundedInt(pointB.getX()), getRoundedInt(pointB.getY()));
        }
    }

    private int getRoundedInt(double number) {
        return (int) Math.ceil(number);
    }
}
