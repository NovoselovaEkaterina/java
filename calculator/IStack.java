package calculator;

import calculator.exceptions.StackIsFullException;

interface IStack {
    boolean empty();
    Double pop() throws MyException;
    void push(Double a) throws StackIsFullException;
}
