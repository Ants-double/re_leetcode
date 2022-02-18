package leetcode.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author ants_
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 *
 *
 * Example 1:
 *
 * Input: s = "()"
 * Output: true
 *
 * Example 2:
 *
 * Input: s = "()[]{}"
 * Output: true
 * Example 3:
 *
 * Input: s = "(]"
 * Output: false
 */
public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValid("]"));
    }
    public static boolean isValid(String s) {
        boolean result=false;
        if (s==null){
            return false;
        }
        if (s.length()<=0){
            return  true;
        }
        Map<Character,Character> map=new HashMap<>(6);
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');

        Stack<Character> stack=new Stack<>();

        for (int i=0;i<s.length();i++){
            Character c = s.charAt(i);
            if (map.keySet().contains(c)){
                stack.push(c);
            }
            else {
                // compare
                if (stack.isEmpty()){
                    return false;
                }
                Character pop = stack.pop();
                Character character = map.get(pop);
                if (character.compareTo(c)==0){
                    continue;
                }
                else {
                    return false;
                }
            }
        }
        if (stack.size()<=0){
            return  true;
        }


        return  result;

    }
}
