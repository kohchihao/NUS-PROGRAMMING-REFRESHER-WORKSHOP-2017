import java.util.Scanner;

public class Main {

    public static final String MINE = "*";
    public static final int L1_ROWS = 8;
    public static final int L1_COLS = 8;
    public static final int L2_ROWS = 12;
    public static final int L2_COLS = 16;
    public static final int L3_ROWS = 16;
    public static final int L3_COLS = 30;

    public static void main(String[] args) {

        int[] rowsLimit = {L1_ROWS, L2_ROWS, L3_ROWS};
        int[] colsLimit = {L1_COLS, L2_COLS, L3_COLS};

        Scanner sc = new Scanner(System.in);

        int level = sc.nextInt();
        int rows = rowsLimit[level-1];
        int cols = colsLimit[level-1];

        String[] minefield = new String[rows];
        int[][] values = new int[rows+2][cols+2];

        // read grid data
        sc.nextLine(); // skip newline after the first line of input (level)
        for (int r=0; r<minefield.length; r++)
            minefield[r] = sc.nextLine();

        // printMinefield(minefield); // For checking

        fillValues(minefield, values,rows,cols);
        //printValues(values);
        //printMinefield(minefield);
    }

    // To print the minefield
    // For checking purpose only
    public static void printMinefield(String[] grid) {
        for (int r=0; r<grid.length; r++)
            System.out.println(grid[r]);
    }

    // Fill numeric array arr with values 0-9.
    // 9: mine-filled sqaure
    // 0-8: number of mines surrounding that square
    public static void fillValues(String grid[], int[][] arr, int row, int cols) {

        String [][] data = new String[row+2][cols+2];
        for (int i = 0; i < grid.length; i++) {
            char[] d = grid[i].toCharArray();
            for (int j = 0; j <grid.length ; j++) {
                data[i+1][j+1]= String.valueOf(d[j]);
            }
        }

        for (int i = 0; i < data.length; i++) {
            data[0][i]="0";
            data[9][i]="0";
            data[i][0]="0";
            data[i][9]="0";
        }

        for (int i = 1; i < data.length-1; i++) {
            for (int j = 1; j < data.length-1; j++) {
                //System.out.println(i+","+j);
                if (data[i][j].equals(MINE)){
                    arr[i][j] = 9;
                }else {
                    arr[i][j]= countBomb(data,i,j);
                }



            }
        }

        printValues(arr);
        // complete the code

    }

    public static int countBomb(String[][] data,int i , int j){
        int count=0;

        try{
            if(data[i-1][j-1].equals(MINE)){
                count++;
            }
            if(data[i-1][j].equals(MINE)){
                count++;
            }
            if(data[i-1][j+1].equals(MINE)){
                count++;
            }

            if(data[i][j-1].equals(MINE)){
                count++;
            }
            if(data[i][j+1].equals(MINE)){
                count++;
            }

            if(data[i+1][j-1].equals(MINE)){
                count++;
            }
            if(data[i+1][j].equals(MINE)){
                count++;
            }
            if(data[i+1][j+1].equals(MINE)){
                count++;
            }
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e);
        }




        return count;
    }

    // To print the numeric array
    public static void printValues(int[][] arr) {

        for(int r=0; r<arr.length; r++) {
            for(int c=0; c<arr[r].length; c++)
                System.out.print(arr[r][c] + " ");
            System.out.println();
        }

    }
}

