package calculator.operations;

import calculator.*;
import calculator.exceptions.InvalidVariableException;

import java.util.ArrayList;
import java.util.HashMap;

public class Expression implements Operation {
    private String str;
    public Expression(String s){
        str = s;
    }

    public void execute(Stack stack, HashMap<String, Double> param) throws MyException {
        ArrayList<String> oplist = getExpression(str, param);
        ArrayList<String> postfixList = infixToPostfix(oplist);
        Double answer;
        answer = calculate(postfixList, param);
        stack.push(answer);
    }

    private ArrayList<String> getExpression( String expression,HashMap<String, Double> param ) throws MyException{
        ArrayList<String> list = new ArrayList<>();
        char[] symbols = {'(', ')', '+', '-', '*', '/'};
        for(int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            boolean b = false;
            for(int k = 0; k < symbols.length; k++) {
                if(ch == symbols[k]) {
                    b = true;
                }
            }
            if(b) {
                list.add(Character.toString(ch));
            }
            else if(Character.isLetter(ch)) {
                if(!param.containsKey(Character.toString(ch))){
                    throw new InvalidVariableException();
                }
                list.add(param.get(Character.toString(ch)).toString());
            }
            else {
                int j = i++;
                while(expression.substring(j, i).matches("-?\\d+(.\\d+)?")) {
                    i++;
                    if(i >= expression.length()) {
                        i = expression.length();
                        break;
                    }
                }
                if(i == expression.length()) {
                    if(expression.charAt(i-1) == ')'){
                        i--;
                        list.add(expression.substring(j, i--));
                    }
                    else {
                        list.add(expression.substring(j, i));
                        i++;
                    }
                }
                else {
                    list.add(expression.substring(j, --i));
                    i--;
                }

            }
        }
        return list;
    }

    private ArrayList<String> infixToPostfix(ArrayList<String> oplist) throws MyException{
        ArrayList<String> postfixList = new ArrayList<>();
        //Stack st = new Stack();
        ArrayList<String> st = new ArrayList<>();
        for(String token : oplist ) {
            if(token.matches("-?\\d+(.\\d+)?")) {
                postfixList.add(token);
            }
            else if(!token.equals("(") && !token.equals(")")) {
                while(!st.isEmpty()) {
                    String lastToken = st.get(st.size()-1);//st.peak();
                    if(!lastToken.equals("(") && !lastToken.equals(")")) {
                        if((lastToken.equals("*") || lastToken.equals("/")) || (token.equals("+") || token .equals("-"))) {
                            postfixList.add(st.remove(st.size()-1));//postfixList.add(st.pop().toString());
                        }
                        else {
                            break;
                        }
                    }
                    else {
                        break;
                    }
                }
                st.add(token);//st.push(x);
            }
            else if(token.equals("(")) {
                st.add(token);//st.push(token);
            }
            else if(token.equals(")")) {
                while(!st.isEmpty()) {
                    String lastToken = st.get(st.size()-1);//st.peak();
                    if(lastToken.equals("(")) {
                        st.remove(st.size()-1);//st.pop();
                        break;
                    }
                    postfixList.add(st.remove(st.size()-1));//st.pop());
                }
            }
        }
        while(!st.isEmpty()) {
            postfixList.add(st.remove(st.size()-1));//st.pop());
        }
        return postfixList;
    }

    private Double calculate(ArrayList<String> postfixList,HashMap<String, Double> param) throws MyException{
        Stack st = new Stack();
        for(String token : postfixList) {
            if(token.matches("-?\\d+(.\\d+)?")) {
                Double x = Double.parseDouble(token);
                st.push(x);
            }
            else {
                String s[]={token};
                Operation op = Factory.getOperation(s);
                op.execute(st, param);

            }
        }
        return st.pop();
    }

}
