package thirtyDaysofCode;

/**
@author rahulrao
  
Given a string containing only three types of characters: '(', ')' and '*', 
write a function to check whether this string is valid. We define the validity of a string by these rules:

Any left parenthesis '(' must have a corresponding right parenthesis ')'.
Any right parenthesis ')' must have a corresponding left parenthesis '('.
Left parenthesis '(' must go before the corresponding right parenthesis ')'.
'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
An empty string is also valid.


Example 1:

Input: "()"
Output: True

Example 2:
Input: "(*)"
Output: True

Example 3:
Input: "(*))"
Output: True

Note:
The string size will be in the range [1, 100].

*/

import java.util.*;

public class ValidParenthesisString {

	public boolean checkValidString(String s) {

		if (s.length() == 0)
			return true;
		Stack<Integer> stack = new Stack<>();
		Stack<Integer> stack_star = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.push(i);
			} else if (s.charAt(i) == ')') {
				if (!stack.isEmpty()) {
					stack.pop();
				} else if (!stack_star.isEmpty()) {
					stack_star.pop();
				} else
					return false;
			} else if (s.charAt(i) == '*') {
				stack_star.push(i);
			}
		}
		while (!stack.isEmpty() && !stack_star.isEmpty()) {
			if (stack.pop() > stack_star.pop()) {
				return false;
			}
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		String s = "(())((())()()(*)(*";
		Boolean result = new ValidParenthesisString().checkValidString(s);
		System.out.println(result);
	}
}
