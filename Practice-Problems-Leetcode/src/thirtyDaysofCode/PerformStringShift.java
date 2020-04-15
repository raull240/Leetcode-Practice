package thirtyDaysofCode;

/*
 You are given a string s containing lowercase English letters, and a matrix shift, where shift[i] = [direction, amount]:

direction can be 0 (for left shift) or 1 (for right shift). 
amount is the amount by which string s is to be shifted.
A left shift by 1 means remove the first character of s and append it to the end.
Similarly, a right shift by 1 means remove the last character of s and add it to the beginning.
Return the final string after all operations.

 

Example 1:

Input: s = "abc", shift = [[0,1],[1,2]]
Output: "cab"
Explanation: 
[0,1] means shift to left by 1. "abc" -> "bca"
[1,2] means shift to right by 2. "bca" -> "cab"
*/

public class PerformStringShift {

    public String stringShift(String s, int[][] shift) {
        int total = 0;
        for (int i = 0; i < shift.length;i++) {
            total += (shift[i][0] == 0) ? shift[i][1] : -shift[i][1]; 
        } if (total > s.length() || -total > s.length()) {
            total = total%s.length();
        } if( total < 0) {
            total += s.length();
        }
        return s.substring(total) + s.substring(0,total);
    }
    
    public static void main(String[] args) {
		String s = "abcdefg";
		int[][] shift = {{1,1},{1,1},{0,2},{1,3}};
		String result = new PerformStringShift().stringShift(s, shift);
		System.out.println(result);
	}
}
