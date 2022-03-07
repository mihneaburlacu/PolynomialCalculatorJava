package model;

import java.util.ArrayList;

public class Operations {
    private Polynomial firstPolynomial;

    public Operations() {
        super();
    }

    public Operations(Polynomial pol) {
        this.firstPolynomial = pol;
    }

    public Polynomial getFirstPolynomial() {
        return firstPolynomial;
    }

    public void setFirstPolynomial(Polynomial firstPolynomial) {
        this.firstPolynomial = firstPolynomial;
    }

    public Polynomial addOp(Polynomial secondPolynomial) {
        Polynomial newPolynomial= new Polynomial();
        ArrayList<Monomial> newList = new ArrayList<Monomial>();

        for(Monomial m1 : firstPolynomial.getMonomialList()) {
            boolean found = false;
            for(Monomial m2 : secondPolynomial.getMonomialList()) {
                if (m1.getPower() == m2.getPower()) {
                    double result = m1.getCoefficient() + m2.getCoefficient();
                    Monomial rez = new Monomial(m1.getPower(), result);

                    newList.add(rez);
                    found = true;
                }
            }
            if(found == false) {
                Monomial rez = new Monomial(m1.getPower(), m1.getCoefficient());
                newList.add(rez);
            }
        }


        for(Monomial m2 : secondPolynomial.getMonomialList()) {
            boolean found = false;
            for(Monomial m3 : newList) {
                if(m2.getPower() == m3.getPower()) {
                    found = true;
                }
            }
            if(found == false) {
                Monomial rez = new Monomial(m2.getPower(), m2.getCoefficient());
                newList.add(rez);
            }
        }


        newPolynomial.setMonomialList(newList);

        return newPolynomial;
    }

    public Polynomial subtractOp(Polynomial secondPolynomial) {
        Polynomial newPolynomial= new Polynomial();
        ArrayList<Monomial> newList = new ArrayList<Monomial>();

        for(Monomial m1 : firstPolynomial.getMonomialList()) {
            boolean found = false;
            for(Monomial m2 : secondPolynomial.getMonomialList()) {
                if (m1.getPower() == m2.getPower()) {
                    double result = m1.getCoefficient() - m2.getCoefficient();
                    Monomial rez = new Monomial(m1.getPower(), result);

                    newList.add(rez);
                    found = true;
                }
            }
            if(found == false) {
                Monomial rez = new Monomial(m1.getPower(), m1.getCoefficient());
                newList.add(rez);
            }
        }

        for(Monomial m2 : secondPolynomial.getMonomialList()) {
            boolean found = false;
            for(Monomial m3 : newList) {
                if(m2.getPower() == m3.getPower()) {
                    found = true;
                }
            }
            if(found == false) {
                Monomial rez = new Monomial(m2.getPower(), m2.getCoefficient());
                newList.add(rez);
            }
        }

        newPolynomial.setMonomialList(newList);

        return newPolynomial;
    }

    public Polynomial integrateOp() {
        Polynomial newPolynomial= new Polynomial();
        ArrayList<Monomial> newList = new ArrayList<Monomial>();

        for(Monomial m1: firstPolynomial.getMonomialList()) {
            if(m1.getPower() != 0) {
                Monomial rez = new Monomial(m1.getPower() + 1, (1 / (double)(m1.getPower() + 1)) * m1.getCoefficient());
                newList.add(rez);
            }
            else {
                Monomial rez = new Monomial(1, m1.getCoefficient());
                newList.add(rez);
            }
        }

        newPolynomial.setMonomialList(newList);
        return newPolynomial;
    }

    public Polynomial derivateOp() {
        Polynomial newPolynomial= new Polynomial();
        ArrayList<Monomial> newList = new ArrayList<Monomial>();

        for(Monomial m1: firstPolynomial.getMonomialList()) {
            if(m1.getPower() != 0) {
                Monomial rez = new Monomial(m1.getPower() - 1, (double)m1.getPower() * m1.getCoefficient());
                newList.add(rez);
            }
        }

        newPolynomial.setMonomialList(newList);
        return newPolynomial;
    }

    public Polynomial multiplyOp(Polynomial secondPolynomial) {
        Polynomial newPolynomial= new Polynomial();
        ArrayList<Monomial> newList = new ArrayList<Monomial>();

        for(Monomial m1 : firstPolynomial.getMonomialList()) {
            for(Monomial m2 : secondPolynomial.getMonomialList()) {
                Monomial rez = new Monomial(m1.getPower() + m2.getPower(), m1.getCoefficient() * m2.getCoefficient());

                boolean found = false;
                for(int i = 0; i < newList.size(); i++) {
                    Monomial m3 = newList.get(i);

                    if(m3.getPower() == rez.getPower()) {
                        found = true;
                        newList.get(i).setCoefficient(newList.get(i).getCoefficient() + rez.getCoefficient());
                    }
                }
                if(!found) {
                    newList.add(rez);
                }
            }
        }

        newPolynomial.setMonomialList(newList);
        return newPolynomial;
    }

    public Polynomial multiplyWithMonOp(Monomial x) {
        Polynomial newPolynomial= new Polynomial();
        ArrayList<Monomial> newList = new ArrayList<Monomial>();

        for(Monomial m1 : firstPolynomial.getMonomialList()) {
            Monomial rez = new Monomial(m1.getPower() + x.getPower(), m1.getCoefficient() * x.getCoefficient());
            newList.add(rez);
        }

        newPolynomial.setMonomialList(newList);
        return newPolynomial;
    }

    public ArrayList<Polynomial> divideOp(Polynomial secondPolynomial) {
        ArrayList<Polynomial> result = new ArrayList<Polynomial>();

        Polynomial quotient = new Polynomial();
        ArrayList<Monomial> newListQu = new ArrayList<Monomial>();
        Polynomial remainder = new Polynomial();

        if(firstPolynomial.getMonomialList().get(0).getPower() < secondPolynomial.getMonomialList().get(0).getPower()) {
            Polynomial auxPol = new Polynomial();
            auxPol.setMonomialList(firstPolynomial.getMonomialList());
            firstPolynomial.setMonomialList(secondPolynomial.getMonomialList());
            secondPolynomial.setMonomialList(auxPol.getMonomialList());
        }

        Polynomial rezPol = new Polynomial();
        rezPol.setMonomialList(firstPolynomial.getMonomialList());

        Operations operation = new Operations(rezPol);
        int nr = 0;

        while(rezPol.getMonomialList().get(0).getPower() >= secondPolynomial.getMonomialList().get(0).getPower()) {
            Monomial rez = new Monomial(rezPol.getMonomialList().get(0).getPower() - secondPolynomial.getMonomialList().get(0).getPower(), rezPol.getMonomialList().get(0).getCoefficient() / secondPolynomial.getMonomialList().get(0).getCoefficient());
            newListQu.add(rez);
            Operations operationNew = new Operations(secondPolynomial);
            Polynomial rezOp1 = operationNew.multiplyWithMonOp(new Monomial(rez.getPower(), - rez.getCoefficient()));
            Polynomial rezOp2 = operation.addOp(rezOp1);
            rezPol.setMonomialList(rezOp2.getMonomialList());
            rezPol.checkForZero();

            nr++;
            remainder.setMonomialList(rezPol.getMonomialList());

        }

        quotient.setMonomialList(newListQu);

        result.add(quotient);
        result.add(remainder);

        return result;
    }
}
