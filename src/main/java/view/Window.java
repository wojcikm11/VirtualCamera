package view;

import model.Edge;

import javax.swing.*;
import java.util.List;

public class Window extends JFrame {
    private CameraPanel cameraPanel;


     public Window(List<Edge> connections) {
        cameraPanel = new CameraPanel(connections);
        this.add(cameraPanel);
        this.pack();

        this.setTitle("Virtual Camera");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setVisible(true);
    }
}
