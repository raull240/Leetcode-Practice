package thirtyDaysofCode;

/**
 * @author rahulrao
 * 
 *         Search in Rotated Sorted Array
 * 
 *         Suppose an array sorted in ascending order is rotated at some pivot
 *         unknown to you beforehand.
 * 
 *         (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * 
 *         You are given a target value to search. If found in the array return
 *         its index, otherwise return -1.
 * 
 *         You may assume no duplicate exists in the array.
 * 
 *         Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 *         Example 1:
 * 
 *         Input: nums = [4,5,6,7,0,1,2], target = 0 Output: 4 Example 2:
 * 
 *         Input: nums = [4,5,6,7,0,1,2], target = 3 Output: -1
 */

public class SearchInARotatedArray {

	public int search(int[] nums, int target) {
		if (nums.length == 0 || nums == null) {
			return -1;
		}
		// try doing a modified binary search
		int left = 0;
		int right = nums.length - 1;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] > nums[right]) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		int least_index = left, start_index = 0, end_index = 0;
		if (target >= nums[least_index] && target <= nums[nums.length - 1]) {
			start_index = least_index;
			end_index = nums.length - 1;
		} else {
			start_index = 0;
			end_index = least_index;
		}
		while (start_index <= end_index) {
			int mid = start_index + (end_index - start_index) / 2;
			if (target == nums[mid]) {
				return mid;
			} else if (target > nums[mid]) {
				start_index = mid + 1;
			} else {
				end_index = mid - 1;
			}
		}

		return -1;
	}

}
