import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int n = sc.nextInt();
        int[][] matrix = new int[n+2][2];

        System.out.println("Enter vertices: ");

        for(int i = 0; i< n; i++){
            matrix[i][0]=sc.nextInt();
            matrix[i][1]=sc.nextInt();
        }

        //assign first 2 points to the last 2
        matrix[n][0] = matrix[0][0];
        matrix[n][1] = matrix[0][1];
        matrix[n+1][0] = matrix[1][0];
        matrix[n+1][1] = matrix[1][1];

        if (isConvex(matrix))
            System.out.println("Yes");
        else
            System.out.println("No");
    }

    // Returns true if polygon is convex, else returns false.
    // A polygon is convex if walking along its boundary,
    // we always encounter right turns (or left turns).
    public static boolean isConvex(int[][] matrix) {

        int length = matrix.length;
        int[] result = new int[length];
        int sample = 0;
        boolean isConvex = false ;
        try {
            for (int i = 0; i < length; i++) {
                if(i>length-3){
                    break;
                }
                //System.out.println(i);
                int det = matrix[i][0]*matrix[i+1][1]
                        - matrix[i][0]*matrix[i+2][1]
                        - matrix[i][1]*matrix[i+1][0]
                        + matrix[i][1]*matrix[i+2][0]
                        + matrix[i+1][0]*matrix[i+2][1]
                        - matrix[i+1][1]*matrix[i+2][0];
                if(i==0){
                    sample = det;
                }
                result[i] = det;

                if(result[i]>0 && sample>0){//left
                    isConvex = true;
                }else if(result[i]<0 && sample<0){//right
                    isConvex = true;
                }else {
                    isConvex=false;
                    break;
                }
            }
        }catch (ArrayIndexOutOfBoundsException ex){
            //do nothing
            //System.out.println(ex);
        }

        return isConvex;
    }
}
