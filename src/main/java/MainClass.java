import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import controller.Controller;
import model.Monomial;
import model.Operations;
import model.Polynomial;
import view.View;

public class MainClass {

    public static void main(String[] args) {
        View view = new View();
        Polynomial polynomial1 = new Polynomial();
        Polynomial polynomial2 = new Polynomial();
        Controller controller = new Controller(view, polynomial1, polynomial2);
        view.setVisible(true);
    }

}
