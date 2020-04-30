package thirtyDaysofCode;

import java.util.*;

/**
 * 
 * @author rahulrao
 * 
 *         Given a non-empty array of integers, every element appears twice
 *         except for one. Find that single one.
 * 
 *         Note:
 * 
 *         Your algorithm should have a linear runtime complexity. Could you
 *         implement it without using extra memory?
 * 
 *         Example 1:
 * 
 *         Input: [2,2,1] Output: 1 Example 2:
 * 
 *         Input: [4,1,2,1,2] Output: 4
 */
public class SingleNumber {

	public int singleNumber(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			if (map.containsKey(num)) {
				map.put(num, map.get(num) + 1);
			} else
				map.put(num, 1);
		}
		for (int num : nums) {
			if (map.get(num) == 1) {
				return num;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] nums = { 7, 7, 6, 5, 4, 3, 3, 4, 5, 2, 2, 12, 12, 67, 67, 98, 98, 65, 65 };
		int result = new SingleNumber().singleNumber(nums);
		System.out.println(result);

	}
}
