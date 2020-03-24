package easyProblems;

// 1108. Defanging an IP Address 
// https://leetcode.com/problems/defanging-an-ip-address/


public class DefangIP {

    public String defangIPaddr(String address) {
        StringBuilder build = new StringBuilder();
        for (int i = 0; i< address.length();i++) {
            if (address.charAt(i) == '.') {
                build.append("[.]");
            } else {
                build.append(address.charAt(i));
            }
        }
        return build.toString();
    }
    
    public static void main(String[] args) {
    	String IP = "1.0.1.300.1";
    	String answer = new DefangIP().defangIPaddr(IP);
        System.out.println(answer);
    }

}
