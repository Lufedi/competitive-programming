import java.util.*;

public class ValidParenthesis {
    public static void main(String[] args) {
        Solution s = new Solution();
        String cad = "[]";
        System.out.println(s.isValid(cad));
        
    }
}

class Solution {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        Map<Character, Character> pairs = new Hashtable<>();
        pairs.put('}', '{');
        pairs.put(')', '(');
        pairs.put(']', '[');

        for (Character c : s.toCharArray()) {


            if (!pairs.containsKey(c)) {
                stack.add(c);
            } else {
                if(stack.isEmpty()){
                    return false;
                }
                char top = stack.pop();
                if (top != pairs.get(c)) {
                    return false;
                }
            }
        }
        if(!stack.isEmpty()){
            return false;
        }
        return true;
    }
}