package model;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polynomial {
    private ArrayList<Monomial> monomialList;

    public Polynomial() {
        this.monomialList = new ArrayList<Monomial>();
    }

    public ArrayList<Monomial> getMonomialList() {
        return monomialList;
    }

    public void setMonomialList(ArrayList<Monomial> monomialList) {
        this.monomialList = monomialList;
    }

    public void addInList(String exp) {
        Pattern pattern = Pattern.compile("([+-]?[^-+]+)");
        Matcher matcher = pattern.matcher(exp);
        int nr = 0;
        monomialList = new ArrayList<Monomial>();

        while (matcher.find()) {
            Monomial mon = new Monomial();

            String s = matcher.group(1);
            int lungime = s.length();

            double coef = 0;
            int pow = 0;

            int i = s.indexOf("x");

            if(i == -1) {
                coef = Double.parseDouble(s);
                pow = 0;
            }
	    	/*
	    	else if(s.charAt(i + 1) != '^') {
	    		coef = Double.parseDouble(s.substring(0, i));
				pow = 1;
				//System.out.println(coef);
				//System.out.println(pow);
	    	}
	    	*/
            else {
                if(i == 0) {
                    coef = 1;
                    pow = Integer.parseInt(s.substring(i + 2, lungime));
                }
                else {
                    coef = Double.parseDouble(s.substring(0, i));
                    pow = Integer.parseInt(s.substring(i + 2, lungime));
                }
            }

            //System.out.println("Group "+nr+": " + matcher.group(1));
            mon.setCoefficient(coef);
            mon.setPower(pow);
            monomialList.add(mon);
            nr++;
        }
    }

    public void checkForZero() {
        int i = 0;
        while(i < monomialList.size()) {
            if(monomialList.get(i).getCoefficient() == 0) {
                monomialList.remove(i);
            }
            else {
                i++;
            }
        }
    }

    public String toString() {
        String result = "";

        for(Monomial m : monomialList) {
            if (m.toString().charAt(0) == '-') {
                result += m.toString();
            }
            else {
                if(result != "") {
                    result += "+" + m.toString();
                }
                else {
                    result += m.toString();
                }
            }
        }

        return result;
    }
}
