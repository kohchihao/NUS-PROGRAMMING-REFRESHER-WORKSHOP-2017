import java.util.Scanner;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class Main {

    public static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Set<Integer> in1, in2;
        String operator;

        // read two sets of integer values into s1, s2
        in1 = readSet();
        in2 = readSet();

        // read the set operation
        String op = sc.next();

        // perform the set operation on the two sets of values
        Set<Integer> out = operate(in1, in2, op);

        // output resulting set
        System.out.println(print(out));
    }

    public static Set<Integer> readSet() {
        Set<Integer> s = new TreeSet<Integer>();
        while (sc.hasNext()) {
            int current = sc.nextInt();
            if (current == -1)
                break;
            s.add(current);
        }
        return s;
    }

    public static Set<Integer> operate(Set<Integer> in1, Set<Integer> in2, String op) {
        SortedSet<Integer> ss = new TreeSet<>();

        switch (op){
            case "+"://union
                ss.addAll(in1);
                ss.addAll(in2);
                return ss;

            case "*"://intersection
                in1.retainAll(in2);
                ss.addAll(in1);
                return ss;


            case "-"://differences
                in1.removeAll(in2);
                ss.addAll(in1);
                return ss;

        }




        return ss;
    }

    public static String print(Set<Integer> s) {
        String text = "";
        for (int data : s){
            text = text+data+" ";
        }
        String trimmed = text.trim();
        return trimmed;
    }
}
