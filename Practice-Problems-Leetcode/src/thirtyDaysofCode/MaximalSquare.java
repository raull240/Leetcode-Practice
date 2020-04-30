package thirtyDaysofCode;

/**
 * @author rahulrao
 * 
 *         Maximal Square Given a 2D binary matrix filled with 0's and 1's, find
 *         the largest square containing only 1's and return its area.
 * 
 *         Example:
 * 
 *         Input:
 * 
 *         1 0 1 0 0 1 0 1 1 1 1 1 1 1 1 1 0 0 1 0
 * 
 *         Output: 4
 */

public class MaximalSquare {

	public int maximalSquare(char[][] matrix) {
		int rows = matrix.length;
		int cols = rows > 0 ? matrix[0].length : 0;
		if (rows == 0 || cols == 0)
			return 0;
		int[][] dp = new int[rows][cols];
		int maxlen = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (matrix[i][j] == '1') {
					dp[i][j] = 1;
					if (i > 0 && j > 0) {
						dp[i][j] += Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
					}
					maxlen = Math.max(maxlen, dp[i][j]);
				}
			}
		}
		return maxlen * maxlen;
	}

}
