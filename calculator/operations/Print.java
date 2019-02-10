package calculator.operations;

import calculator.*;
import calculator.exceptions.StackIsEmptyException;

import java.util.HashMap;

public class Print implements Operation {

    public void execute(Stack stack, HashMap<String, Double> param) throws StackIsEmptyException {
        System.out.println(stack.peak());
    }
}
