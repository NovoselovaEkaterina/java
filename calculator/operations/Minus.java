package calculator.operations;

import calculator.*;
import calculator.exceptions.StackIsEmptyException;
import calculator.exceptions.StackIsFullException;

import java.util.HashMap;

public class Minus implements Operation{

    public void execute(Stack stack, HashMap<String, Double> param)
            throws StackIsEmptyException, StackIsFullException {
        Double val;
        if(stack.getSize() >= 2) {
            Double a = stack.pop();
            Double b = stack.pop();

            val = b - a;
        }
        else{
            throw new StackIsEmptyException();
        }

        stack.push(val);
    }
}
