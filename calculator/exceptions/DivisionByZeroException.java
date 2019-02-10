package calculator.exceptions;
import calculator.*;

public class DivisionByZeroException extends MyException{
    public DivisionByZeroException(){
        msg = "Divisor is equal to zero";
    }
}
