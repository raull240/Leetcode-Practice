package thirtyDaysofCode;

/** 
 * @author rahulrao
 Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.

  */

import java.util.*;

public class MinStack {

	private Stack<int[]> stack = new Stack<>();

	/** initialize your data structure here. */
	public MinStack() {
	}

	public void push(int x) {

		/* load the stack and maintain the lowest item */
		if (stack.isEmpty()) {
			stack.push(new int[] { x, x });
			return;
		}
		int currentMin = stack.peek()[1];
		stack.push(new int[] { x, Math.min(currentMin, x) });
	}

	public void pop() {

		stack.pop();

	}

	public int top() {
		return stack.peek()[0];
	}

	public int getMin() {
		return stack.peek()[1];
	}

	public static void main(String[] args) {
		MinStack obj = new MinStack();
		obj.push(10);
		obj.push(7);
		obj.push(3);
		obj.push(-10);
		obj.push(-7);
		obj.push(6);
		obj.pop();
		int param_3 = obj.top();
		System.out.println("top element is" + param_3);
		int param_4 = obj.getMin();
		System.out.println("min element is" + param_4);
		obj.pop();

	}
}
