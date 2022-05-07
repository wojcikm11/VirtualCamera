package view;

import model.Edge;
import model.VirtualObject;

import javax.swing.*;
import java.util.List;

public class Window extends JFrame {
    private CameraPanel cameraPanel;


     public Window(VirtualObject virtualObject) {
        cameraPanel = new CameraPanel(virtualObject);
        this.add(cameraPanel);
        this.pack();

        this.setTitle("Virtual Camera");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setVisible(true);
    }
}
