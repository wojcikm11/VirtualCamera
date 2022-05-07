import input.DataReader;
import model.Edge;
import view.Window;

import java.util.List;

public class Main {
    public static void main(String[] args) {
//        DataReader dataReader = new DataReader();
//        List<Edge> edgeList = dataReader.readData("data.json");
//        edgeList.forEach(System.out::println);
        DataReader dataReader = new DataReader();
        List<Edge> data = dataReader.readData("data.json");
        Window window = new Window(data);
    }
}
