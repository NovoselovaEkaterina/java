package calculator.operations;

import calculator.*;
import calculator.exceptions.SquaringNegativeException;
import calculator.exceptions.StackIsEmptyException;
import calculator.exceptions.StackIsFullException;

import java.util.HashMap;

public class Squarer implements Operation {

    public void execute(Stack stack, HashMap<String, Double> param)
            throws SquaringNegativeException, StackIsFullException, StackIsEmptyException {
        Double a = stack.peak();
        if(a < 0){
            throw new SquaringNegativeException();
        }
        stack.pop();
        Double val = Math.sqrt(a);

        stack.push(val);
    }
}