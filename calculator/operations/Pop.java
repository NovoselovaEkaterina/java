package calculator.operations;

import calculator.*;
import calculator.exceptions.StackIsEmptyException;

import java.util.HashMap;

public class Pop implements Operation {

    public void execute(Stack stack, HashMap<String, Double> param) throws StackIsEmptyException {
        stack.pop();
    }
}
