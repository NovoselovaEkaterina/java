package calculator.exceptions;

import calculator.MyException;

public class StackIsEmptyException extends MyException {
    public StackIsEmptyException(){
        msg = "Stack is empty";
    }
}
