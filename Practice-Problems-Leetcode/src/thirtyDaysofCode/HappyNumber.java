package thirtyDaysofCode;

import java.util.HashSet;

public class HappyNumber {

	
	/*
	 * A happy number is a number defined by the following process: Starting with any positive integer, 
	 * replace the number by the sum of the squares of its digits, and repeat the process until the number 
	 * equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. 
	 * Those numbers for which this process ends in 1 are happy numbers.
	 * */
	
	public boolean isHappy(int n) {

		// Use a hashset to find a cycle. If a cycle exists the algorithm will loop
		// endlessly
		HashSet<Integer> seen = new HashSet<>();

		// base conditions
		if (n == 1)
			return true;
		if (n < 1)
			return false;

		// making sure while looping we don't encounter a already visited number which
		// means its a cycle
		// and also that the value doesn't go below one.
		while (n > 1 && !seen.contains(n)) {

			// add num to hashset so we can check later
			seen.add(n);
			int add_square_num = 0;

			// seperate each digit and square it and maintain a sum
			while (n > 0) {
				int curr = n % 10;
				add_square_num += curr * curr;
				n /= 10;
			}
			n = add_square_num;
		}
		return n == 1;
	}
	
	public static void main(String[] args) {
		int num = 7;
		System.out.println("finding if the number " + num + " is a happy number :" + new HappyNumber().isHappy(num));
	}
}
