import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // read n numbers and fill the array
        int n = sc.nextInt();
        int[] array = new int[n];

        //to store all the sum
        int[] sumArray = new int[n];

        for (int i = 0; i < n; i++){
            array[i] = sc.nextInt();
            if(i==0){
                sumArray[0]=array[0];
            }else {
                sumArray[i]= array[i]+sumArray[i-1];
            }

        }

        // read queries and perform efficient addition
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            System.out.println(sum(sumArray,start,end));
        }
    }


    public static int add(int[] array, int start, int end) {
        int total=0;
        for (int i = start; i <= end; i++) {
            total = total + array[i];
        }

        return total;
    }

    public static int sum(int[] array, int start,int end){
        int total = 0;
        if(start==0){
            total = array[end];
        }else {
            total = array[end]-array[start-1];
        }

        return total;
    }
}
