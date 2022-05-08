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
    public static final int VIEW_WIDTH = 1280;
    public static final int VIEW_HEIGHT = 800;

    public Window(VirtualObject virtualObject) {
        cameraPanel = new CameraPanel(virtualObject);
        this.setSize(VIEW_WIDTH, VIEW_HEIGHT);
        this.addKeyListener(this);
        this.setTitle("Virtual Camera");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(cameraPanel);
        this.setVisible(true);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W -> cameraPanel.moveForward();
            case KeyEvent.VK_S -> cameraPanel.moveBackwards();
            case KeyEvent.VK_D -> cameraPanel.moveRight();
            case KeyEvent.VK_A -> cameraPanel.moveLeft();
            case KeyEvent.VK_E -> cameraPanel.moveUp();
            case KeyEvent.VK_Q -> cameraPanel.moveDown();
            case KeyEvent.VK_LEFT -> cameraPanel.lookLeft();
            case KeyEvent.VK_RIGHT -> cameraPanel.lookRight();
            case KeyEvent.VK_UP -> cameraPanel.lookUp();
            case KeyEvent.VK_DOWN -> cameraPanel.lookDown();
            case KeyEvent.VK_Z -> cameraPanel.rotateLeft();
            case KeyEvent.VK_X -> cameraPanel.rotateRight();
            case KeyEvent.VK_EQUALS -> cameraPanel.zoomIn();
            case KeyEvent.VK_MINUS -> cameraPanel.zoomOut();
        }
        if (AVAILABLE_KEYS.contains(e.getKeyCode())) {
            cameraPanel.repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}
}
