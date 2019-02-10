package calculator.exceptions;

import calculator.MyException;

public class StackIsFullException extends MyException {
    public StackIsFullException(){
        msg = "Stack is full";
    }
}
