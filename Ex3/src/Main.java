import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int N, num, i;
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        for (i = 0; i < N; i++) {
            num = sc.nextInt();
            int sq = (int) sqrt1(num);

            //System.out.println(sq);
            double squared = sq * sq;
            //System.out.println(squared);
            if(squared == num){
                System.out.println(num+" is a perfect square.");
            }else {
                System.out.println(num+" is not a perfect square.");
            }
        }


    }

    public static double sqrt1(int num){
        // read in the command-line argument
        double c = num;
        double epsilon = 1e-15;    // relative error tolerance
        double t = c;              // estimate of the square root of c

        // repeatedly apply Newton update step until desired precision is achieved
        while (Math.abs(t - c/t) > epsilon*t) {
            t = (c/t + t) / 2.0;
        }

        return t;
    }
}
