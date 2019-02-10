package calculator.exceptions;

import calculator.MyException;

public class SquaringNegativeException extends MyException {
    public SquaringNegativeException(){
        msg = "Squaring a negative number";
    }
}
