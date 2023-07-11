package View;


import javax.swing.*;
import java.awt.*;


public abstract class DialogWindow implements Viewable{
    protected JDialog window = new JDialog();
    protected final JButton button = new JButton("Restart game");
    protected JPanel panel = new JPanel();

    public DialogWindow(String titleWindow) {
        window.setTitle(titleWindow);
    }

    protected abstract void setImage();

    public void restart(){
        window.remove(panel);
        panel = new JPanel();
        closeWindow();
    }

    public JButton getButton() {
        return button;
    }

    @Override
    public void closeWindow() {
        window.setVisible(false);
    }

    @Override
    public void init(int width, int height) {
        window.setSize(new Dimension(width, height));
        window.setLocation(820, 400);
        panel.add(button);
        setImage();
        window.add(panel);

        window.setResizable(false);
        window.setVisible(true);
    }
}
