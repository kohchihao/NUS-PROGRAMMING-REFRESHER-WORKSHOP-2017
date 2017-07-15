import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int n, input; // n = # of test inputs
        boolean valid=false;

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            input = sc.nextInt();
            int a = input % 1111 ;
            if(a==0){
                valid = false;
            }else{
                valid = true;
            }
            if (!valid)

                System.out.printf("%04d Invalid input. All four digits are the same\n", input);
            else {
                // repeatedly constuct new number and output
                sort(input);
                System.out.println("");
            }
        }
    }

    public static int sort(int input){
        DecimalFormat df = new DecimalFormat("0000");
        int max ;
        int min ;
        int [] arr = new int[4];
        int i=0;
        //System.out.println(input+" ");
        int n = input;
        while (n>0){
            int r = n%10; //get last digit
            arr[i] = r ;
            i++;
            n = n/10;
        }

        //smallest
        Arrays.sort(arr);
        min = fixBack(arr);

        //max
        arr = reverse(arr);
        max = fixBack(arr);
        //System.out.println("min:"+min+" max:"+max);

        int diff = max - min ;
        //System.out.println("diff:"+diff);

        if(input == diff){
            System.out.print(df.format(input));
            return diff;
        }else{
            System.out.print(df.format(input)+" ");
            return sort(diff);
        }




    }

    public static int fixBack(int arr[]){
        int acc =0 ;
        int p=1;
        int n = arr.length;
        while (n>0){
            acc = acc + arr[n-1]*p ;
            p = p*10;
            n--;
        }
        //System.out.println(acc);

        return acc;
    }

    public static int[] reverse(int[] data) {
        for (int left = 0, right = data.length - 1; left < right; left++, right--) {
            // swap the values at the left and right indices
            int temp = data[left];
            data[left]  = data[right];
            data[right] = temp;
        }

        return data;
    }




}
