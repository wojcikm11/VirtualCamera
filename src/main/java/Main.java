import input.DataReader;
import model.VirtualObject;
import view.Window;

public class Main {
    public static void main(String[] args) {
        String filePath = args[0].toLowerCase();
        DataReader dataReader = new DataReader();
        VirtualObject virtualObject = dataReader.readData(filePath);
        Window window = new Window(virtualObject);
    }
}
