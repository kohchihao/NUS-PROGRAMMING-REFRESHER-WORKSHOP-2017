package com.company;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

    public static final double EPSILON = 0.0001;

    public static void main(String[] args) {

            int c3, c2, c1, c0; // coefficients of polynomial
            double a, b;          // endpoints


            Scanner sc = new Scanner(System.in);

            // Read inputs
            System.out.print("Enter coefficients (c3,c2,c1,c0) of polynomial: ");
            c3 = sc.nextInt();
            c2 = sc.nextInt();
            c1 = sc.nextInt();
            c0 = sc.nextInt();

            System.out.print("Enter endpoints a and b: ");
            a = sc.nextDouble();
            b = sc.nextDouble();


            // Fill in the computation below

            compute(a,b,c3,c2,c1,c0);



        }

        // This method returns the value of the polynomial
        //    p(x) = c3*x^3 + c2*x^2 + c1*x + c0

    public static double polynomial(double x, int c3, int c2, int c1, int c0) {

        // Replace the return value below with the correct expression
            double px = c3 * Math.pow(x, 3) + c2 * Math.pow(x,2) + c1 * x+ c0;
        return px;
    }

    public static void compute(double a, double b, int c3, int c2, int c1, int c0){
        DecimalFormat df = new DecimalFormat("0.000000");
        double pA, pB;         // function values at endpoints
        double diff=a-b;
        double m = 0, pM = 0;// midpoint and function value at midpoint
        while(Math.abs(diff)>EPSILON ){

            //getting the midpoint value
            m = (a+b)/2 ;

            pM = polynomial(m,c3,c2,c1,c0);
            pB = polynomial(b,c3,c2,c1,c0);
            if(pM==0){
                break;
            }
           /* System.out.println("a="+df.format(a));
            System.out.println("b="+df.format(b));

            System.out.println("root = " + df.format(m));
            System.out.println("p(root) = " + df.format(pM));*/
            diff = a-b ; //get the difference of a & b

            //System.out.println("diff="+df.format(diff));
            if(pM>0&&pB>0){
                b=m;
            }else if(pM<0&&pB<0){
                b=m;
            }else {
                a=m;
            }
        }

        System.out.println("root = " + df.format(m));
        System.out.println("p(root) = " + df.format(pM));

    }


}
