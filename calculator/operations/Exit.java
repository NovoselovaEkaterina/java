package calculator.operations;

import calculator.*;
import java.util.HashMap;

public class Exit implements Operation {

    public void execute(Stack stack, HashMap<String, Double> param) {
        System.exit(0);
    }
}
