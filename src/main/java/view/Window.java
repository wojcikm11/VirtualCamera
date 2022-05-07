package view;

import model.VirtualObject;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

public class Window extends JFrame implements KeyListener {
    private CameraPanel cameraPanel;
    private static final List<Integer> AVAILABLE_KEYS = List.of(KeyEvent.VK_W, KeyEvent.VK_A, KeyEvent.VK_S, KeyEvent.VK_D,
                                                                KeyEvent.VK_E, KeyEvent.VK_Q, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT,
                                                                KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_X, KeyEvent.VK_Z,
                                                                KeyEvent.VK_EQUALS, KeyEvent.VK_MINUS);

     public Window(VirtualObject virtualObject) {
        cameraPanel = new CameraPanel(virtualObject);
        this.setContentPane(cameraPanel);
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
            case KeyEvent.VK_UP:
                cameraPanel.rotateYRight();
                break;
            case KeyEvent.VK_DOWN:
                cameraPanel.rotateYLeft();
                break;
            case KeyEvent.VK_Z:
                cameraPanel.rotateZRight();
                break;
            case KeyEvent.VK_X:
                cameraPanel.rotateZLeft();
                break;
            case KeyEvent.VK_EQUALS:
                cameraPanel.zoomIn();
                break;
            case KeyEvent.VK_MINUS:
                cameraPanel.zoomOut();
                break;
        }
        if (AVAILABLE_KEYS.contains(e.getKeyCode())) {
            cameraPanel.paint(getGraphics());
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
