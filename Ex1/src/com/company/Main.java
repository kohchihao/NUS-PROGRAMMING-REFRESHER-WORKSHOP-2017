package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        ArrayList<int[]> list = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()){
            int[] entry = new int[3];

            entry[0] = sc.nextInt();

            if(entry[0]==-1){
                break;
            }

            entry[1] = sc.nextInt();
            entry[2] = sc.nextInt();

            list.add(entry);



        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(findHiddenNumber(list.get(i)));
        }

    }

    public static int findHiddenNumber(int... numbers){
        int digitalRoot = 0 ;
        for(int i=0;i<numbers.length;i++ ){
            digitalRoot = digitalRoot + numbers[i];
        }

        if(digitalRoot<10){
            if(digitalRoot==9){
                return 9;
            }
            return (9- digitalRoot);
        }else {
            return findHiddenNumber(convert2IntArray(digitalRoot));
        }
    }

    public static int[] convert2IntArray(int num){
        char[] numChar = String.valueOf(num).toCharArray();
        int[] number = new int[numChar.length];

        for(int i=0;i<numChar.length;i++){
            number[i] = Integer.parseInt(Character.toString(numChar[i]));
        }

        return number;

    }
}
