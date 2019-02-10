package calculator;

public class MyException extends Exception{

    protected String msg;

    public String getMessage(){
        return msg;
    }
}
