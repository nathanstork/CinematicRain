import java.awt.*;
import java.util.Random;

public class RainDrop {
    Random random = new Random();
    private int x;
    private int y;
    private int width;
    private int height;
    private double speed;

    public RainDrop() {
        this.x = random.nextInt(CinematicRain.getPanelWidth() - width);
        this.y = random.nextInt(CinematicRain.getPanelHeight() - height);
        this.width = 3;
        this.height = 20;
        this.speed = random.nextInt(29) + 1;
    }

    public void draw(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(x, y, width, height);
    }

    public void move() {
        if (y >= CinematicRain.getPanelHeight()) { // if the drop is out of bounds on the panel that is being drawn on
            this.y = 0 - height; // resets the RainDrop outside the panel, so that it reappears smoothly
        } else {
            this.y += speed;
        }
    }
}

