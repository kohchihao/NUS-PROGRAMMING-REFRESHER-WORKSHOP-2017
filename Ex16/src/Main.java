import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int n, b; //n = non-negative number, b = base b which is a number between 2 and 10
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a base b : ");
        b = sc.nextInt();

        System.out.print("Enter a base-b number : ");
        n = sc.nextInt();

        //Fill in your code for testing validity of the number

        if(isValidNumber(n, b)){
            System.out.println("The corresponding base-10 number is : "+convertToDecimal(n,b));
        }else{
            System.out.println("Error!! " + n +" is not a number of base "+b+".");
        }


    }

    public static boolean isValidNumber(int n, int b){
        while( n > 0 ){
            int lastDigit = n % 10;

            if( lastDigit >= b){
                return false;
            }

            n = n / 10;
        }

        return true;
    }

    //This function parameters are number and its base
    public static int convertToDecimal(int n, int b)
    {

        int base10 = 0;
        int decimalPos =0;
        while( n > 0 ){
            int lastDigit = n % 10;

            base10 += lastDigit * pow(b, decimalPos);

            n = n / 10;
            decimalPos++;

        }

        return base10;
        //Fill in your code for converting from base b to decimal
    }

    public static int pow(int n, int m){
        if(m>0){
            return n* pow(n, m-1);
        }else{
            return 1;
        }
    }
}
