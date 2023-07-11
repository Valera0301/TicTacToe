package Controller;

import View.View;
import Model.Model;
import View.DialogWindow;

import java.awt.*;

public class Controller{
    private final View view;
    private final Model model;
    private Symbol currentSymbol;
    private DialogWindow currentWindow;

    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;
        currentSymbol = Symbol.X;
    }

    public void start(){
        view.showMenu();
        setActionOnCell();
    }

    private void checkWin(){
        if (model.checkWin()){
            view.showWinMenu();
            currentWindow = view.getWinWindow();
            setActionOnRestartGame();
            currentSymbol = null;
        }
        else if(model.checkDraw()){
            view.showDrawMenu();
            currentWindow = view.getDrawWindow();
            setActionOnRestartGame();
            currentSymbol = null;
        }
    }

    private void setActionOnCell(){
        var cells = view.getCells();
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                int positionX = i;
                int positionY = j;
                cells[i][j].addActionListener(e -> putSymbolInCell(positionX, positionY, currentSymbol));
            }
        }
    }

    private void setActionOnRestartGame(){
        currentWindow.getButton().addActionListener(e -> restartGame());
    }

    private void restartGame(){
        currentWindow.closeWindow();
        currentSymbol = Symbol.X;
        model.restart();
        view.restart();
        setActionOnCell();
    }

    private void putSymbolInCell(int positionX, int positionY, Symbol symbol){
        var cell = view.getCells()[positionX][positionY];

        if (cell.isFull() || symbol == null){
            return;
        }

        cell.setForeground(setColorCell(symbol));
        cell.setText(symbol.toString());
        cell.setFull(true);

        model.makeMove(positionX, positionY, symbol.toString().toCharArray()[0]);

        checkWin();
        currentSymbol = changeSymbol();
    }

    private Color setColorCell(Symbol symbol){
        return switch (symbol) {
            case X -> Color.RED;
            case O -> Color.BLUE;
        };
    }

    private Symbol changeSymbol(){
        if (currentSymbol == Symbol.X) {
            return Symbol.O;
        } else if (currentSymbol == Symbol.O) {
            return Symbol.X;
        }
        return null;
    }
}
