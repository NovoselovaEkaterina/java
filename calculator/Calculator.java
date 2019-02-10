package calculator;

import java.io.*;
import java.util.*;

public class Calculator implements Serializable {

    private static HashMap<String, Double> param = new HashMap<String, Double>();
    private static Stack stack = new Stack();
    private static Scanner sc = new Scanner(System.in);

    public static void run() {
        while (true) {
            String str = sc.nextLine();
            String[] strArr = str.split(" ");
            try {
                Operation op = Factory.getOperation(strArr);
                op.execute(stack, param);
            } catch (MyException e) {
                System.out.println(e.getMessage());
                run();
            }
        }
    }
}
