import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter the number of days: ");
        int n = sc.nextInt();
        System.out.println("You have entered the number of days as: "+n);

        if (n == 1) {
            System.out.println("The number of presents received in 1 day is "
                    + recPresent(1) + ".");
        }
        else { // n > 1
            System.out.println("The number of presents received in "
                    + n + " days is " + recPresent(n) + ".");
        }
    }

    public static  int recPresent(int n){
        if(n>1){
            int d = ((n)*(n+1))/2; //A.P https://www.mathsisfun.com/algebra/sequences-sums-arithmetic.html
            return d+ recPresent(n-1);
        }else {
            return 1;
        }
    }
}
