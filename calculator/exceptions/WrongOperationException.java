package calculator.exceptions;

import calculator.MyException;

public class WrongOperationException extends MyException {
    public WrongOperationException(){
        msg = "Operation is not correct";
    }
}
