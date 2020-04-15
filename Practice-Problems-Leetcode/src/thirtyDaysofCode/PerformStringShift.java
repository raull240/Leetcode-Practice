package thirtyDaysofCode;

public class PerformStringShift {

    public String stringShift(String s, int[][] shift) {
        int total = 0;
        for (int i = 0; i < shift.length;i++) {
            total += (shift[i][0] == 0) ? shift[i][1] : -shift[i][1]; 
        } if (total > s.length() || -total > s.length()) {
            total = total%s.length();
        } if( total < 0) {
            total += s.length();
        }
        return s.substring(total) + s.substring(0,total);
    }
    
    public static void main(String[] args) {
		String s = "abcdefg";
		int[][] shift = {{1,1},{1,1},{0,2},{1,3}};
		String result = new PerformStringShift().stringShift(s, shift);
		System.out.println(result);
	}
}
