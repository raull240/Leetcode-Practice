package thirtyDaysofCode;

/**
 * 
  Given an integer array arr, count element x such that x + 1 is also in arr.
  If there're duplicates in arr, count them seperately.
  
  Example 1:
  Input: arr = [1,2,3]
  Output: 2
  
  Explanation: 1 and 2 are counted cause 2 and 3 are in arr.
*/

import java.util.*;

public class Countingelements {
	public int countElements(int[] arr) {
		int output = 0;
		HashSet<Integer> set = new HashSet<>();
		for (int num : arr) {
			set.add(num);
		}
		for (int nums : arr) {
			if (set.contains(nums + 1)) {
				output += 1;
				// set.remove(nums + 1);
			}
		}

		return output;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 1, 2, 3, 3, 4 };
		int result = new Countingelements().countElements(nums);
		System.out.println(result);

	}
}
