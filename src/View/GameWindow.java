package View;

import javax.swing.*;
import java.awt.*;

public class GameWindow implements Viewable {
    private JFrame window;
    private Cell[][] cells = new Cell[3][3];

    public GameWindow(){
        window = new JFrame("TicTacToe");
        setButton();
    }

    public Cell[][] getCells() {
        return cells;
    }

    public void restart(){
        window.setVisible(false);
        window = new JFrame("Game");
        cells = new Cell[3][3];
        setButton();
        init(200, 150);
    }

    @Override
    public void init(int width, int height) {
        window.setSize(new Dimension(width, height));
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        window.setResizable(false);
        putButtonOnWindow();
    }

    @Override
    public void closeWindow() {
        window.setVisible(false);
    }

    private void setButton() {
        for (int row = 0; row < cells.length; row++) {
            for (int column = 0; column < cells[row].length; column++) {
                cells[row][column] = new Cell();
                cells[row][column].setPreferredSize(new Dimension(75, 75));
                cells[row][column].setText("");
            }
        }
    }

    private void putButtonOnWindow() {
        JPanel panel = new JPanel(new GridLayout(3, 3));

        for (Cell[] cell : cells) {
            for (Cell value : cell) {
                panel.add(value);
            }
        }

        window.add(panel);
    }
}
