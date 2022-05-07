package model;

public class Edge {
    private Point3D pointA;
    private Point3D pointB;

    public Edge(Point3D pointA, Point3D pointB) {
        this.pointA = pointA;
        this.pointB = pointB;
    }

    public Point3D getPointA() {
        return pointA;
    }

    public void setPointA(Point3D pointA) {
        this.pointA = pointA;
    }

    public Point3D getPointB() {
        return pointB;
    }

    public void setPointB(Point3D pointB) {
        this.pointB = pointB;
    }
}
