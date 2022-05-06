package model;


public class Edge {
    private Point pointA;
    private Point pointB;

    public Edge(Point pointA, Point pointB) {
        this.pointA = pointA;
        this.pointB = pointB;
    }

    public Point getPointA() {
        return pointA;
    }

    public void setPointA(Point pointA) {
        this.pointA = pointA;
    }

    public Point getPointB() {
        return pointB;
    }

    public void setPointB(Point pointB) {
        this.pointB = pointB;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "pointA=" + pointA +
                ", pointB=" + pointB +
                '}';
    }
}
