package Medium;
import java.util.*;

public class AsteroidColliision {

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
       int i = 0;
        while (i < asteroids.length) {
            if(asteroids[i] > 0) {
                stack.push(asteroids[i]);
            } else {
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(asteroids[i])) {
                    stack.pop();    
                }
                 if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(asteroids[i]);
                } else if (stack.peek() == Math.abs(asteroids[i])) {
                    stack.pop();
                }    
            }
            i++;
        }
        int[] answer = new int[stack.size()];
        for (int j = stack.size() - 1;j >= 0; j--) {
            answer[j] = stack.pop();
        }
        return answer;
    }
    
    public static void main(String[] args) {
    	int[] asteroids_Array = {5,7,-10,-3,8,3};
    	int[] result = new AsteroidColliision().asteroidCollision(asteroids_Array);
    	for (int res: result) {
    		System.out.println(res);
    	}
    }

}
