package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, k; // n = no. of candles; k = residuals to roll out a new candle

        System.out.print("Enter n and k: ");
        n = sc.nextInt();
        k = sc.nextInt();
        System.out.println("Total candles burnt = "+ calculateCandlesBurnt(n,k));
    }

    public static int calculateCandlesBurnt(int n , int k){
        int totalBurnt = 0 ;
        int newCandlesCreated=0;
        int remainderCandles =0 ;

        if(n<k){
            totalBurnt = n ;
        }
        while(n>=k){
            newCandlesCreated = n/k ;
            remainderCandles = n % k ;
            totalBurnt = totalBurnt + n - remainderCandles; //98 //112
            n = newCandlesCreated+remainderCandles; //14+2 //4
        }

        totalBurnt = totalBurnt + newCandlesCreated + remainderCandles;


        return totalBurnt;
    }
}
