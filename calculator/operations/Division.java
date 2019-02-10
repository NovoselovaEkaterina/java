package calculator.operations;

import calculator.*;
import calculator.exceptions.*;

import java.util.HashMap;

public class Division implements Operation {

    @Override
    public void execute(Stack stack, HashMap<String, Double> param)
            throws DivisionByZeroException, StackIsEmptyException, StackIsFullException {
        Double val;
        if(stack.getSize() >= 2) {
            Double a = stack.pop();
            Double b = stack.pop();

            if (a.equals(0.0)) {
                stack.push(b);
                stack.push(a);
                throw new DivisionByZeroException();
            }
            val = b / a;
        }
        else{
            throw new StackIsEmptyException();
        }
        stack.push(val);
    }
}
