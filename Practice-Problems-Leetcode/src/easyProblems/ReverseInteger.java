package easyProblems;
import java.util.Scanner;

public class ReverseInteger {

	
	private static int ReverseInteger(int int_x) {
		// TODO Auto-generated method stub
		int reversed = 0;
		boolean flag = false;
		if (int_x == 0) return 0;
		if (int_x < 0) {
			int_x += int_x * -2;
			flag = true;
		}
		while (int_x > 0) {
			reversed = reversed*10 + int_x%10;
			int_x/=10;
		
		}			
	    if(flag == true) {
	    	reversed -= 2*(reversed);
	    }
		return reversed;
	}
	
    public static void main(String[] args) {
		System.out.println("Please enter an integer to be reversed");
		Scanner sc = new Scanner(System.in);
		int capturedInput = sc.nextInt();
		System.out.println("The captured user input is " + capturedInput);
		int reversedInt = ReverseInteger(capturedInput);
		System.out.println("The resevered int for the given input is " + reversedInt);
		
	}

}

