package thirtyDaysofCode;

/**
 * @author rahulrao Given an array nums, write a function to move all 0's to the
 *         end of it while maintaining the relative order of the non-zero
 *         elements.
 * 
 *         Example:
 * 
 *         Input: [0,1,0,3,12] Output: [1,3,12,0,0] Note:
 * 
 *         You must do this in-place without making a copy of the array.
 *         Minimize the total number of operations.
 */
public class MoveZeroes {

	public int[] moveZeroes(int[] nums) {
		int left = 0;
		for (int num : nums) {
			if (num != 0) {
				nums[left++] = num;

			}
		}
		while (left < nums.length) {
			nums[left++] = 0;
		}
		return nums;

	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 0, 0, 0, 3, 4, 5, 0, 0, 5, 0, 4 };
		int[] result = new MoveZeroes().moveZeroes(arr);
		for (int res : result) {
			System.out.print(res + ", ");
		}

	}
}