package View;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class WinWindow extends DialogWindow {
    public WinWindow(String title) {
        super(title);
    }

    @Override
    protected void setImage() {
        BufferedImage image;
        try {
            image = ImageIO.read(new File("/Users/denys/IdeaProjects/TicTacToe/src/View/Assets/trophy.png" ));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        JLabel label = new JLabel(new ImageIcon(image));
        panel.add(label);
    }

    @Override
    public void init(int width, int height) {
        super.init(width, height);
        window.add(panel);
    }
}
