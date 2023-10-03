package Sequence;
import java.util.Stack;

public class Valid_Parenthesis {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (typeOfBracket(ch).equalsIgnoreCase("open"))
                stack.add(ch);
            else {
                if (stack.isEmpty())
                    return false;
                char popped = stack.pop();
                if (levelOfBracket(popped) != levelOfBracket(ch))
                    return false;
            }
        }

        if (!stack.isEmpty())
            return false;

        return true;
    }

    private String typeOfBracket(char ch) {
        if (ch == '(' || ch == '{' || ch == '[')
            return "open";
        else
            return "close";
    }

    private int levelOfBracket(char ch) {
        if (ch == '(' || ch == ')')
            return 1;

        if (ch == '{' || ch == '}')
            return 2;

        if (ch == '[' || ch == ']')
            return 3;

        return 3;
    }

}

// Note
// 1. Use stack > O(n) + O(n)
// a. Stack is empty while trying pop out
// b. Popped out char != Inserted Char
// c. Stack is not empty which means inserted != popped