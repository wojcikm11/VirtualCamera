package model;

import java.util.List;

public class VirtualObject {
    private List<Edge> connections;
    private List<Point3D> points;

    public VirtualObject(List<Edge> connections, List<Point3D> points) {
        this.connections = connections;
        this.points = points;
    }

    public List<Edge> getConnections() {
        return connections;
    }

    public void setConnections(List<Edge> connections) {
        this.connections = connections;
    }

    public List<Point3D> getPoints() {
        return points;
    }

    public void setPoints(List<Point3D> points) {
        this.points = points;
    }
}
