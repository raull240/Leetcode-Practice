/**
 * 
 */
package easyProblems;

import javax.print.DocFlavor.STRING;

/**
 * @author rahulrao
 *
 */
public class Isomorph {

	/**
    */
	public Isomorph() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	
	/**
	 * @param str1
	 * @return
	 */
	public static boolean IsIsomorph(String str1) {
		int map[] = new int[256];
		for (int i = 0; i<str1.length(); i++) {
			map[i] = str1.charAt(i);
			System.out.println(map[i]);
			
		}
		
		return true;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(" Hello world ");
		String str1 = "1234567890abcdefgh";
		boolean answer = IsIsomorph(str1);

	}

}
