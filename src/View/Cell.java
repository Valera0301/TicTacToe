package View;

import javax.swing.*;

public class Cell extends JButton {
    private boolean isFull = false;

    public boolean isFull() {
        return isFull;
    }

    public void setFull(boolean full) {
        isFull = full;
    }
}
