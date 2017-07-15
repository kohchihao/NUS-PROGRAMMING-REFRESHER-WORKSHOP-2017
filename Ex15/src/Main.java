import java.util.Scanner;

public class Main {

    public static int MAX_SIZE = 10;

    public static void main(String[] args) {

        int[] list = readArray();
        printArray(list);
        System.out.println("Sum = " + sumArray(list));
    }

    // Read values into array.
    // Return number of elements read.
    public static int[] readArray() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int size = sc.nextInt();
        int[] arr = new int[size];
        System.out.print("Enter " + size + " values: ");
        for (int i=0; i<size; i++)
            arr[i] = sc.nextInt();

        return arr;
    }

    // Print values in array
    public static void printArray(int[] arr) {
        System.out.print("Array read: ");
        for (int i=0; i<arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver method to call recursive sumArray
    public static int sumArray(int[] arr) {
        return sumArray(arr, arr.length);
    }

    // Sum all the values in the array arr
    // Pre-cond: size >= 0
    public static int sumArray(int[] arr, int size) {

        if (size>1){
            return arr[size-1]+sumArray(arr,size-1);
        }else {
            return arr[0];
        }


    }
}
