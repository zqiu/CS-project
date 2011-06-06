package WallStreet;

import javax.swing.*;
import java.awt.*;

public class Human extends JPanel {

    public void paintComponent(Graphics g) {
        Image img = new ImageIcon("Human.jpg").getImage();
        g.drawImage(img, 3, 4, this);
    }
}
