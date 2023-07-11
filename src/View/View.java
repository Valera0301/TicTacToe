package View;


public class View {
    private final MenuWindow menuWindow = new MenuWindow();
    private final GameWindow gameWindow = new GameWindow();
    private final WinWindow winWindow = new WinWindow("WIN");
    private final DrawWindow drawWindow = new DrawWindow("DRAW");
    private DialogWindow currentWindow;

    public WinWindow getWinWindow() {
        return winWindow;
    }

    public DrawWindow getDrawWindow() {
        return drawWindow;
    }

    public Cell[][] getCells() {
        return gameWindow.getCells();
    }

    public void restart(){
        currentWindow.restart();
        currentWindow.closeWindow();
        gameWindow.restart();
    }

    public void showWinMenu(){
        winWindow.init(200, 250);
        currentWindow = winWindow;
    }

    public void showDrawMenu(){
        drawWindow.init(200, 250);
        currentWindow = drawWindow;
    }

    private void setStartGame(){
        menuWindow.getButton().addActionListener(e -> showGameWindow());
    }

    private void showGameWindow() {
        menuWindow.closeWindow();
        gameWindow.init(200, 150);
    }

    public void showMenu() {
        menuWindow.init(250, 150);
        setStartGame();
    }
}
