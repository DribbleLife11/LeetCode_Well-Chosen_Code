/**
 * LeetCode 20.有效的括号
 */
class Solution {
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if ('(' == c) {
                stack.push(')');
            } else if ('[' == c) {
                stack.push(']');
            } else if ('{' == c) {
                stack.push('}');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }

        return stack.empty();
    }
}
