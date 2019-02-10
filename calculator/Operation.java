package calculator;

import java.util.HashMap;

public interface Operation {
    void execute(Stack stack, HashMap<String, Double> param)throws MyException;
}
