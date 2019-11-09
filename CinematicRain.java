/*
@title Cinematic Rain
@author Nathan Stork
@date 9/11/2019
    A simple cinematic that simulates rain using SWING basics.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CinematicRain extends JPanel implements ActionListener {
    private final int SCREEN_WIDTH = 800;
    private final int SCREEN_HEIGHT = 600;
    private final int DROP_AMOUNT = 750;
    private final int FPS = 30;

    public static int panelWidth;
    public static int panelHeight;

    private Timer timer;

    private JFrame frame;

    private ArrayList<RainDrop> drops;

    private CinematicRain() {
        buildGUI();
        storePanelSize();

        timer = new Timer(1000 / FPS, this);

        drops = new ArrayList<>();
        for (int i = 0; i < DROP_AMOUNT; i++) {
            drops.add(new RainDrop());
        }
    }

    private void run() {
        timer.start();
    }

    /*
    This method stores the actual size of the panel inside two global variables, so that the size of the panel can be
    accessed from a static context using the getPanelWidth and getPanelHeight methods.
     */
    private void storePanelSize() {
        panelWidth = this.getWidth();
        panelHeight = this.getHeight();
    }

    public static int getPanelWidth() {
        return panelWidth;
    }

    public static int getPanelHeight() {
        return panelHeight;
    }

    private void buildGUI() {
        frame = new JFrame("Cinematic Rain by Nathan Stork");
        frame.setLayout(new GridLayout());
        frame.add(this);

        this.setBackground(new Color(38, 87, 137));

        frame.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (RainDrop drop : drops) {
            drop.draw(g);
            drop.move();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            repaint();
            Thread.sleep(1000 / FPS);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CinematicRain rain = new CinematicRain();
        rain.run();
    }
}
