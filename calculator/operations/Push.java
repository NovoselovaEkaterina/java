package calculator.operations;

import calculator.*;
import calculator.exceptions.InvalidVariableException;
import calculator.exceptions.StackIsFullException;

import java.util.HashMap;

public class Push implements Operation{

    public Push(String v){
        val = v;
    }
    public void execute(Stack stack, HashMap<String, Double> param)
            throws InvalidVariableException, StackIsFullException {
        if (!val.matches("-?\\d+(.\\d+)?") && !param.containsKey(val)) {
            throw new InvalidVariableException();
        }
        if(param.containsKey(val)){
            stack.push(param.get(val));
        }
        else {
            Double x = Double.parseDouble(val);
            stack.push(x);
        }
    }

    public String val;
}
