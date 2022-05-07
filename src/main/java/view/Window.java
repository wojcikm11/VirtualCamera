package view;

import model.VirtualObject;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Window extends JFrame implements KeyListener {
    private CameraPanel cameraPanel;


     public Window(VirtualObject virtualObject) {
        cameraPanel = new CameraPanel(virtualObject);
        this.add(cameraPanel);
        this.pack();
        this.addKeyListener(this);
        this.setTitle("Virtual Camera");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode())
        {
            case KeyEvent.VK_W:
                cameraPanel.moveForward();
                break;
            case KeyEvent.VK_S:
                cameraPanel.moveBackwards();
                break;
            case KeyEvent.VK_D:
                cameraPanel.moveRight();
                break;
            case KeyEvent.VK_A:
                cameraPanel.moveLeft();
                break;
            case KeyEvent.VK_E:
                cameraPanel.moveUp();
                break;
            case KeyEvent.VK_Q:
                cameraPanel.moveDown();
                break;
            case KeyEvent.VK_LEFT:
                cameraPanel.rotateXLeft();
                break;
            case KeyEvent.VK_RIGHT:
                cameraPanel.rotateXRight();
                break;
        }
        cameraPanel.paint(getGraphics());
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
