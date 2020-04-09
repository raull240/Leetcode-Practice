package thirtyDaysofCode;

import java.util.Stack;

/*
 * Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.

Example 1:

Input: S = "ab#c", T = "ad#c"
Output: true
Explanation: Both S and T become "ac".
Example 2:

Input: S = "ab##", T = "c#d#"
Output: true
Explanation: Both S and T become "".

Note:

1 <= S.length <= 200
1 <= T.length <= 200
S and T only contain lowercase letters and '#' characters.
Follow up:

 * */

public class BackSpaceStringCompare {

	    public boolean backspaceCompare(String S, String T) {
	        
	        return getParsed(S).equals(getParsed(T));
	    }
	    
	    public String getParsed(String S) {
	        Stack<Character> stack = new Stack<>();
	        char[] char_s = S.toCharArray();
	        for (char small_s:char_s) {
	            if (small_s == '#' && stack.size() > 0) {
	              stack.pop();   
	            } else if (small_s != '#'){
	                stack.push(small_s);
	            }
	        }
	        char[] temp_s = new char[stack.size()];
	        for (int i = stack.size() -1; i >= 0 ;i--) {
	          temp_s[i] = stack.pop();     
	        } 
	        
	        String result = new String(temp_s);
	        System.out.println(result);
	        return result;
	    }
	    
	    public static void main(String[] args) {
			String s = "ab#c";
		    String t = "ad#c";
		    Boolean result = new BackSpaceStringCompare().backspaceCompare(s,t); 
		    System.out.println("result is " + result);
		}
	

}
