package thirtyDaysofCode;


/*
 Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:

All inputs will be in lowercase.
The order of your output does not matter.
  */
import java.util.*;

public class GroupAnagrams {

	public List<List<String>> groupAnagrams(String[] strs) {

		List<List<String>> result = new ArrayList<>();
		HashMap<String, List<String>> map = new HashMap<>();

		for (String str : strs) {

			char[] curr_char = str.toCharArray();
			Arrays.sort(curr_char);
			String sorted_str = new String(curr_char);
			if (!map.containsKey(sorted_str)) {
				map.put(sorted_str, new ArrayList<>());
			}
			map.get(sorted_str).add(str);
		}
		result.addAll(map.values());
		return result;
	}
	
	public static void main(String[] args) {
		String[] group = {"eat", "tea", "tan", "ate", "nat", "bat"};
		List<List<String>> result = new GroupAnagrams().groupAnagrams(group);
		for (List<String> res: result) {
			System.out.println(res.toString());
		}
	}

}
