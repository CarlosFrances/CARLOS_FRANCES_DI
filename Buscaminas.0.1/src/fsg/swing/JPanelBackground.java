package fsg.swing;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

import java.io.Serializable;

public class JPanelBackground extends JPanel implements Serializable {
    private Image image;

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        this.repaint();
    }
    
    
}
