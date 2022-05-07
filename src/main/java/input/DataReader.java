package input;

import model.Edge;
import model.Point3D;
import model.VirtualObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataReader {
    public VirtualObject readData(String fileName) {
        JSONParser jsonParser = new JSONParser();
        List<Edge> edgeList = null;
        List<Point3D> pointList = null;
        try(FileReader fileReader = new FileReader(fileName)) {

            JSONObject inputData = (JSONObject) jsonParser.parse(fileReader);
            JSONArray points = (JSONArray) inputData.get("points");
            JSONArray edges = (JSONArray) inputData.get("edges");

            Map<Integer, Point3D> pointsMap = getPointMap(points);
            pointList = new ArrayList<>(pointsMap.values());
            edgeList = getEdgeList(edges, pointsMap);

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return new VirtualObject(edgeList, pointList);
    }

    private Map<Integer, Point3D> getPointMap(JSONArray points) {
        Map<Integer, Point3D> pointMap = new HashMap<>();

        for (Object pointObject : points) {
            JSONObject pointData = (JSONObject) pointObject;
            Integer id = ((Long) pointData.get("id")).intValue();
            double x = (double) pointData.get("x");
            double y = (double) pointData.get("y");
            double z = (double) pointData.get("z");

            Point3D point3D = new Point3D(id, x, y, z);
            pointMap.put(id, point3D);
        }

        return pointMap;
    }

    private List<Edge> getEdgeList(JSONArray edges, Map<Integer, Point3D> pointsMap) {
        List<Edge> edgeList = new ArrayList<>();

        for (Object edgeObject : edges) {
            JSONObject edgeData = (JSONObject) edgeObject;
            Integer idA = ((Long) edgeData.get("pointA")).intValue();
            Integer idB = ((Long) edgeData.get("pointB")).intValue();
            Point3D pointA = pointsMap.get(idA);
            Point3D pointB = pointsMap.get(idB);
            Edge edge = new Edge(pointA, pointB);
            edgeList.add(edge);
        }

        return edgeList;
    }
}
