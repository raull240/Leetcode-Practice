package thirtyDaysofCode;

import java.util.*;

/*(This problem is an interactive problem.)

A binary matrix means that all elements are 0 or 1. For each individual row of the matrix, this row is sorted in non-decreasing order.

Given a row-sorted binary matrix binaryMatrix, return leftmost column index(0-indexed) with at least a 1 in it. If such index doesn't exist, return -1.

You can't access the Binary Matrix directly.  You may only access the matrix using a BinaryMatrix interface:

BinaryMatrix.get(row, col) returns the element of the matrix at index (row, col) (0-indexed).
BinaryMatrix.dimensions() returns a list of 2 elements [rows, cols], which means the matrix is rows * cols.
Submissions making more than 1000 calls to BinaryMatrix.get will be judged Wrong Answer.  Also, any solutions that attempt to circumvent the judge will result in disqualification.

For custom testing purposes you're given the binary matrix mat as input in the following four examples. You will not have access the binary matrix directly.

Example 1:

Input: mat = [[0,0],[1,1]]
Output: 0

Example 2: 

Input: mat = [[0,0,0,1],[0,0,1,1],[0,1,1,1]]
Output: 1
 
 * */
public class LeftMostColumnWithAtleastaOne {

	/**
	 * // This is the BinaryMatrix's API interface. // You should not implement it,
	 * or speculate about its implementation interface BinaryMatrix { public int
	 * get(int x, int y) {} public List<Integer> dimensions {} };
	 */

	public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
		int lefmost_col = 0;
		List<Integer> dimensions = binaryMatrix.dimensions();
		int rows = dimensions.get(0);
		int cols = dimensions.get(1);
		int left_most = cols;
		int col = cols;
		for (int row = 0; row < rows; row++) {
			while (binaryMatrix.get(row, col - 1) == 1) {
				col--;
				if (col == 0)
					return 0;
			}
			if (col < left_most) {
				left_most = col;
			}
		}
		return cols == left_most ? -1 : left_most;
	}

}
