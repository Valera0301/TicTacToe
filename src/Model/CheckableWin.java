package Model;

public interface CheckableWin {
    boolean checkHorizontalWin();
    boolean checkVerticalWin();
    boolean checkDiagonalWin() ;
    boolean checkWin();
    boolean checkDraw();
}
