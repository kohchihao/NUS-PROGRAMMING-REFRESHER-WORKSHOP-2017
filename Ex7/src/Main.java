import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // read sorted, rotated sequence of values and key value k
        System.out.println("Enter data:");
        List<Integer> list = new ArrayList<Integer>();
        while (sc.hasNextInt()) {
            int data = sc.nextInt();
            list.add(data);
        }

        int[] x = new int[list.size()-1];

        for (int i = 0; i < list.size()-1; i++){
            x[i] = list.get(i);
        }

        int k = list.get(list.size()-1); //fuck this need minus 1
        //System.out.println("K="+k);


        // perform non-linear search
        int pivot = compare(list);
        //System.out.println(pivot);
        int low=0;
        int high=x.length-1;
        int idx;
        if(k>=x[0]){
            high = pivot - 1 ;
        }else {
            low = pivot  ;
        }
        idx = binarySearch(x, k,low,high);

        // output the search result
        if (idx == -1)
            System.out.println("Not found");
        else
            System.out.println(idx);
    }

    public static int binarySearch(int[] x, int k,int low,int high) {
        int mid = (low+high)/2;
        while((low<=high) && x[mid] !=k){
            if (k < x[mid]){
                high = mid - 1 ;
            }else {
                low = mid + 1 ;
            }
            mid = (low+high)/2;

        }
        if(low>high){
            return -1;
        }else {
            return mid;
        }
    }

    public static int compare(List<Integer>list){
        int max = Collections.max(list);
        int k = list.indexOf(max);
        return k+1;
    }
}
