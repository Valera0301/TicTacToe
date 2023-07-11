package View;

import javax.swing.*;
import java.awt.*;


public class MenuWindow implements Viewable {
    private JFrame window;
    private JButton startGame;

    public JButton getButton() {
        return startGame;
    }

    @Override
    public void init(int width, int height) {
        window = new JFrame("Menu");
        startGame = new JButton("Start Game");
        JPanel panel = new JPanel();
        panel.add(startGame);
        panel.setForeground(Color.DARK_GRAY);
        panel.setBackground(Color.lightGray);
        window.add(panel);
        window.setSize(new Dimension(width, height));
        window.setResizable(false);
        window.setLocationRelativeTo(null);

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }

    @Override
    public void closeWindow() {
        window.setVisible(false);
    }
}
