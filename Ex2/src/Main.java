import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<String[]> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String text="";
        while (sc.hasNext()) {

            String [] data = new String[3];
            int G = sc.nextInt();
            if(G==-1){
                break;
            }
            double weight = sc.nextDouble();
            double height = sc.nextDouble();

            data[0] = String.valueOf(G);
            data[1] = String.valueOf(weight);
            data[2] = String.valueOf(height);
            list.add(data);
        }

        for(String[] d:list){
            switch (Integer.parseInt(d[0])){
                case 1: //male
                    text = BMISorter(1,calcBMI(Double.parseDouble(d[2]),Double.parseDouble(d[1])));

                    break;
                case 0: //female
                    text = BMISorter(0,calcBMI(Double.parseDouble(d[2]),Double.parseDouble(d[1])));

                    break;
            }

            System.out.println(text);
            text="";
        }
    }

    public static double calcBMI(double height,double weight){
        double BMI=0.0;
        BMI = weight / (Math.pow(height,2));
        return BMI;
    }

    public static String BMISorter(int gender,double BMI){
        String bodyTypes="";
        switch (gender){
            case 1:
                if(BMI<=20){//underweight
                    bodyTypes = "You are underweight. Stuff yourself with more food!";
                }else if(BMI>20 && BMI<=25) { //20 < BMI ≤ 25 //acceptable
                    bodyTypes = "Your weight is perfect. Maintain it!";
                }else if(BMI>25){//overweight BMI > 25
                    bodyTypes = "You are overweight, time to join the gym!";
                }
                break;
            case 0:
                if(BMI<=19){//underweight
                    bodyTypes = "You are underweight. Stuff yourself with more food!";
                }else if(BMI>19 && BMI<=24) { //19 < BMI ≤ 24 //acceptable
                    bodyTypes = "Your weight is perfect. Maintain it!";
                }else if(BMI>24){//overweight BMI > 24
                    bodyTypes = "You are overweight, time to join the gym!";
                }
                break;

        }

        return bodyTypes;
    }


}
