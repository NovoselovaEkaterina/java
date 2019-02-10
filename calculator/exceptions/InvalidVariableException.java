package calculator.exceptions;

import calculator.MyException;

public class InvalidVariableException extends MyException {
    public InvalidVariableException(){
        msg = "Variable with this name is not exists";
    }
}