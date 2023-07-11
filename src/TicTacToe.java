import Controller.Controller;
import View.View;
import Model.Model;

public class TicTacToe {
    public static void main(String[] args) {
        var model = new Model();
        var view = new View();
        var controller = new Controller(view, model);

        controller.start();
    }
}
