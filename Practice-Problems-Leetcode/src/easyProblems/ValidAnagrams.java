package easyProblems;

import java.util.*;
public class ValidAnagrams {

    public boolean isAnagram(String s, String t) {
        char[] s_char = s.toCharArray();
        char[] t_char = t.toCharArray();
        Arrays.sort(s_char);
        Arrays.sort(t_char);
        
        return Arrays.equals(s_char,t_char);
        
    }
   
    public static void main(String[] args) {
		String s1 = "nitin";
		String s2 = "nitni";
		System.out.println("The above 2 strings are anagrams : " + new ValidAnagrams().isAnagram(s1, s2));
	}
}
