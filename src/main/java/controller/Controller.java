package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import model.Operations;
import model.Polynomial;
import view.View;

public class Controller {
    private View view;
    private Polynomial polynomialFirst;
    private Polynomial polynomialSecond;

    public Controller(View view, Polynomial polFirst, Polynomial polSecond) {
        this.view = view;
        this.polynomialFirst = polFirst;
        this.polynomialSecond = polSecond;

        this.view.addAddListener(new ActionListener() {
            public void actionPerformed (ActionEvent e){
                view.setTextResult("");
                polynomialFirst.addInList(view.getTextFirstPol());
                polynomialSecond.addInList(view.getTextSecondPol());


                Operations operation = new Operations(polynomialFirst);
                Polynomial resultNew = new Polynomial();

                resultNew = operation.addOp(polynomialSecond);
                resultNew.checkForZero();
                view.setTextResult(resultNew.toString());
            }
        });

        this.view.addSubtractListener(new ActionListener() {
            public void actionPerformed (ActionEvent e){
                view.setTextResult("");
                polynomialFirst.addInList(view.getTextFirstPol());
                polynomialSecond.addInList(view.getTextSecondPol());

                Operations operation = new Operations(polynomialFirst);
                Polynomial resultNew = new Polynomial();

                resultNew = operation.subtractOp(polynomialSecond);
                resultNew.checkForZero();
                view.setTextResult(resultNew.toString());
            }
        });

        this.view.addIntegralListener(new ActionListener() {
            public void actionPerformed (ActionEvent e){
                view.setTextResult("");
                polynomialFirst.addInList(view.getTextFirstPol());

                Operations operation = new Operations(polynomialFirst);
                Polynomial resultNew = new Polynomial();

                resultNew = operation.integrateOp();
                resultNew.checkForZero();
                view.setTextResult(resultNew.toString());
            }
        });

        this.view.addDerivateListener(new ActionListener() {
            public void actionPerformed (ActionEvent e){
                view.setTextResult("");
                polynomialFirst.addInList(view.getTextFirstPol());

                Operations operation = new Operations(polynomialFirst);
                Polynomial resultNew = new Polynomial();

                resultNew = operation.derivateOp();
                resultNew.checkForZero();
                view.setTextResult(resultNew.toString());
            }
        });

        this.view.addMultiplicateListener(new ActionListener() {
            public void actionPerformed (ActionEvent e){
                view.setTextResult("");
                polynomialFirst.addInList(view.getTextFirstPol());
                polynomialSecond.addInList(view.getTextSecondPol());

                Operations operation = new Operations(polynomialFirst);
                Polynomial resultNew = new Polynomial();

                resultNew = operation.multiplyOp(polynomialSecond);
                resultNew.checkForZero();
                view.setTextResult(resultNew.toString());
            }
        });

        this.view.addDivideListener(new ActionListener() {
            public void actionPerformed (ActionEvent e){
                view.setTextResult("");
                polynomialFirst.addInList(view.getTextFirstPol());
                polynomialSecond.addInList(view.getTextSecondPol());

                Operations operation = new Operations(polynomialFirst);
                ArrayList<Polynomial> resultNew = new ArrayList<Polynomial>();

                resultNew = operation.divideOp(polynomialSecond);
                view.setTextResult("Q = " + resultNew.get(0) + "   R = " + resultNew.get(1));
            }
        });
    }


}
