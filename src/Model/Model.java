package Model;

public class Model implements CheckableWin {
    private char[][] gameField;
    private int moveCounter = 0;

    public Model() {
        gameField = new char[][] {
                {'1', '2', '3'},
                {'4', '5', '6'},
                {'7', '8','9'}
        };
    }

    public void makeMove(int positionX, int positionY, char symbol){
        gameField[positionX][positionY] = symbol;
        moveCounter++;
    }

    @Override
    public boolean checkHorizontalWin() {
        for (char[] chars : gameField) {
            if (chars[0] == chars[1] && chars[0] == chars[2]) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean checkVerticalWin() {
        for (int j = 0; j < gameField[1].length; j++)
        {
            if (gameField[0][j] == gameField[1][j] && gameField[0][j] == gameField[2][j])
            {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean checkDiagonalWin() {
        if (gameField[0][0] == gameField[1][1] && gameField[0][0] == gameField[2][2])
        {
            return true;
        }
        return gameField[2][0] == gameField[1][1] && gameField[2][0] == gameField[0][2];
    }

    @Override
    public boolean checkWin() {
        return checkDiagonalWin() || checkHorizontalWin() || checkVerticalWin();
    }

    @Override
    public boolean checkDraw() {
        return moveCounter == 9;
    }

    public void restart() {
        gameField = new char[][] {
                {'1', '2', '3'},
                {'4', '5', '6'},
                {'7', '8','9'}
        };

        moveCounter = 0;
    }
}
