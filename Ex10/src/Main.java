import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();

        int[][] table = new int[rows][];

        for (int i=0; i<rows; i++) {
            table[i] = new int[i+1];
        }

        System.out.println("Enter values for array: ");
        for (int r=0; r<table.length; r++) {
            for (int c=0; c<table[r].length; c++) {
                table[r][c] = sc.nextInt();
            }
        }

          // for checking

        System.out.println("Maximum path value = " + maxPathValue(table));
    }

    // Compute the path that gives the maximum value
    public static int maxPathValue(int[][] arr) {
        int maxRow = arr.length-1;

        for (int r = maxRow-1; r >=0; r--) {
            for (int c = 0; c < r+1 ; c++) {
                //System.out.println(r+","+c);
                if (arr[r+1][c] > arr[r+1][c+1])
                    arr[r][c] += arr[r+1][c];
                else
                    arr[r][c] += arr[r+1][c+1];
            }
        }


        return arr[0][0];

    }

    // Print elements in the 2-dimensional triangular array arr.
    // For checking purpose.
    public static void printTriangularArray(int[][] arr) {

        for (int r=0; r<arr.length; r++) {
            for (int c=0; c<arr[r].length; c++) {
                System.out.print(arr[r][c] + "\t");
            }
            System.out.println();
        }
    }

}
