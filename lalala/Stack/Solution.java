package DS_Java.lalala.Stack;

import java.util.Stack;

class Solution {
    public static boolean isValid(String s) {
        //leetcode 20括号匹配
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (c.equals('(') || c.equals('[') || c.equals('{')) {
                stack.push(c);
            } else if (c.equals(')') || c.equals('}') || c.equals(']')) {
                if (stack.empty())
                    return false;
                Character character = stack.pop();
                if(c.equals(')')&&!character.equals('('))
                    return false;
                if(c.equals(']')&&!character.equals('['))
                    return false;
                if(c.equals('}')&&!character.equals('{'))
                    return false;
            }
        }
        if (!stack.empty())
            return false;
        else
            return true;
    }

    public static void main(String[] args) {
        System.out.println(isValid("()[]{}[[{}]]"));
    }
}