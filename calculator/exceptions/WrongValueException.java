package calculator.exceptions;

import calculator.MyException;

public class WrongValueException extends MyException {
    public WrongValueException(){
        msg = "Value is not number";
    }
}
