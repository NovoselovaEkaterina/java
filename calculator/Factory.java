package calculator;

import calculator.exceptions.WrongOperationException;
import calculator.operations.*;

import java.lang.reflect.InvocationTargetException;

public class Factory {

    public Factory(){}

    public static Operation getOperation(String[] str) {
        Operation op = null;
        try {
            if (str[0].charAt(0) == '#') {
                Class clazz = Class.forName(Comment.class.getName());
                op = (Comment) clazz.newInstance();
            } else if (str[0].equals("EXIT")) {
                Class clazz = Class.forName(Exit.class.getName());
                op = (Exit) clazz.newInstance();
            } else if (str[0].equals("PRINT")) {
                Class clazz = Class.forName(Print.class.getName());
                op = (Print) clazz.newInstance();
            } else if (str[0].equals("PUSH")) {
                Class clazz = Class.forName(Push.class.getName());
                Class[] params = {String.class};
                op = (Push) clazz.getConstructor(params).newInstance(str[1]);
            } else if (str[0].equals("POP")) {
                Class clazz = Class.forName(Pop.class.getName());
                op = (Pop) clazz.newInstance();
            } else if (str[0].equals("+")) {
                Class clazz = Class.forName(Plus.class.getName());
                op = (Plus) clazz.newInstance();
            } else if (str[0].equals("-")) {
                Class clazz = Class.forName(Minus.class.getName());
                op = (Minus) clazz.newInstance();
            } else if (str[0].equals("*")) {
                Class clazz = Class.forName(Multiply.class.getName());
                op = (Multiply) clazz.newInstance();
            } else if (str[0].equals("/")) {
                Class clazz = Class.forName(Division.class.getName());
                op = (Division) clazz.newInstance();
            } else if (str[0].equals("SQRT")) {
                Class clazz = Class.forName(Squarer.class.getName());
                op = (Squarer) clazz.newInstance();
            } else if (str[0].equals("DEFINE")) {
                if(str.length != 3){
                    throw new WrongOperationException();
                }
                Class clazz = Class.forName(Define.class.getName());
                Class[] params = {String.class, String.class};
                op = (Define) clazz.getConstructor(params).newInstance(str[1], str[2]);
            } else if (str[0].equals("EXP")) {
                if(str.length != 2){
                    throw new WrongOperationException();
                }
                Class clazz = Class.forName(Expression.class.getName());
                Class[] params = {String.class};
                op = (Expression) clazz.getConstructor(params).newInstance(str[1]);
            } else {
                throw new WrongOperationException();
            }
        }
        catch (MyException | ClassNotFoundException | InstantiationException |
                IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            System.out.println(e.getMessage());
            Calculator.run();
        }
        return op;
    }
}
