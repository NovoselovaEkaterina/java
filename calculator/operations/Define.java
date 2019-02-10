package calculator.operations;

import calculator.*;
import calculator.exceptions.*;

import java.util.HashMap;

public class Define implements Operation {

    private String str1, str2;
    public Define(String s1, String s2){
        str1 = s1;
        str2 = s2;
    }
    public void execute(Stack stack, HashMap<String, Double> param)
            throws InvalidVariableException, WrongValueException {
        String key = str1;
        if(key.length() != 1){
            throw new InvalidVariableException();
        }
        String val = str2;
        if (!val.matches("-?\\d+(.\\d+)?")) {
            throw new WrongValueException();
        }
        Double x = Double.parseDouble(val);
        param.put(key, x);
    }
}
