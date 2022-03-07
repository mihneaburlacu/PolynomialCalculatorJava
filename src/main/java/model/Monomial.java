package model;

import java.text.DecimalFormat;

public class Monomial {
    private int power;
    private double coefficient;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public Monomial() {
        super();
    }

    public Monomial(int power, double coefficient) {
        this.power = power;
        this.coefficient = coefficient;
    }

    public int getPower() {

        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

    public String toString() {
        if(this.coefficient % 1 == 0) {

            int newCoefficient = (int) (this.coefficient);

            if(this.power == 0) {
                String result = "";
                result = result + newCoefficient;
                return result;
            }
            if(newCoefficient == 1) {
                return "x^" + this.power;
            }

            return newCoefficient + "x^" + this.power;
        }

        if(this.power == 0) {
            String result = "";
            result = result + df.format(this.coefficient);
            return result;
        }

        return df.format(this.coefficient) + "x^" + this.power;
    }
}
