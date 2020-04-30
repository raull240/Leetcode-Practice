package thirtyDaysofCode;

/**
 * 
 * @author rahulrao
 * 
 *         Given an integer array nums, find the contiguous subarray (containing
 *         at least one number) which has the largest sum and return its sum.
 * 
 *         Example:
 * 
 *         Input: [-2,1,-3,4,-1,2,1,-5,4], Output: 6 Explanation: [4,-1,2,1] has
 *         the largest sum = 6. Follow up:
 * 
 *         If you have figured out the O(n) solution, try coding another
 *         solution using the divide and conquer approach, which is more subtle.
 */

public class MaximumSubArray {
	public int maxSubArray(int[] nums) {
		int[] dp = new int[nums.length];
		if (nums.length == 0 || nums == null)
			return -1;
		dp[0] = nums[0];
		int max = dp[0];
		for (int i = 1; i < nums.length; i++) {
			dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
			if (dp[i] > max)
				max = dp[i];

		}
		return max;
	}

}
