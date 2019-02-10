package calculator;

import calculator.exceptions.StackIsEmptyException;
import calculator.exceptions.StackIsFullException;

public class Stack implements IStack {
    Double[] arr;
    private int size;

    public Stack(){
        arr = new Double[100];
        size = 0;
    }

    public boolean empty(){
        return size==0;
    }

    public int getSize(){
        return size;
    }

    public Double pop() throws StackIsEmptyException{
        if(this.empty()) {
            throw new StackIsEmptyException();
        }
        size--;
        return arr[size];
    }

    public void push(Double a) throws StackIsFullException{
        if(size==100)
            throw new StackIsFullException();
        arr[size]=a;
        size++;
    }

    public Double peak() throws StackIsEmptyException{
        if(this.empty()) {
            throw new StackIsEmptyException();
        }
        return arr[size - 1];
    }
}
