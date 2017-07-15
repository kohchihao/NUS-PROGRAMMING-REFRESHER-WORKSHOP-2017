package com.company;
import java.util.Scanner;

public class Ex4 {

    public static void main(String[] args) {

        System.out.print("Enter data:\n");
        System.out.println("Number of up-slopes = " + compute_upslopes());

    }

    public static int compute_upslopes() {

        double current= 0.0 ;
        double prev;
        int currentGradient = 0 ;
        int prevGradient;
        boolean beginWithUpSlope=false;
        int totalUpSlope = 0;

        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()){
            prev = current;
            current = sc.nextDouble();
            if(current <0){
                break;
            }

            if(prev!=0){
                prevGradient = currentGradient;
                currentGradient= getGradient(current,prev);
                if(isUpSlope(currentGradient,prevGradient)){
                    //started off with a upslope
                    beginWithUpSlope=true;
                }else if(prevGradient!=0){
                    if(isUpSlope(currentGradient,prevGradient)){
                        totalUpSlope++;
                    }
                }

            }
            if(beginWithUpSlope){
                totalUpSlope++;
                beginWithUpSlope=false;
            }




        }


        return totalUpSlope;
    }

    public static int getGradient(double current, double previous){
        if(current > previous){ //increasing
            return 1;
        }else if(current < previous){ //decreasing
            return -1;
        }else {//neutral
            return 0;
        }
    }

    public static boolean isUpSlope(int currentGradient, int previousGradient){
        if(currentGradient==1 && previousGradient==0){//from neutral to upslope
            return true;
        }else if(currentGradient==1 && previousGradient==-1){//from downslope to upslope
            return true;
        }else {//down //if still upslope dont add.
            return false;
        }
    }
}
