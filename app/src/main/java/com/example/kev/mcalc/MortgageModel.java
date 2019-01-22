package com.example.kev.mcalc;

import java.util.Locale;

public class MortgageModel
{
    private double p;
    private double a;
    private double i;

    public MortgageModel (String p, String a, String i)
    {
        this.p = Double.parseDouble(p);
        this.a = Double.parseDouble(a);
        this.i = Double.parseDouble(i);
    }

    public String computePayment()
    {
        double r = (this.i/100) / 12;
        double n = this.a * 12;
        double mortgage = (r * this.p)/(1 - Math.pow((1+r),-n));
        return String.format(Locale.CANADA, "$%,.2f",mortgage);
    }

    public static void main(String[] args)
    {
        MortgageModel myModel = new MortgageModel("700000","25","2.75");
        System.out.println(myModel.computePayment());

        myModel = new MortgageModel("300000","20","4.50");
        System.out.println(myModel.computePayment());
    }
}
