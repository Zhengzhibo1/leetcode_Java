import java.util.Stack;

public class Solution {

// ===================算法实现=======================
	// 方法 模拟
	// 时间复杂度O(n)
	// 空间复杂度O(n)
	public boolean validateStackSequences(int[] pushed, int[] popped) {

		int index = 0;
		Stack<Integer> stack = new Stack<Integer>();

		for (int num : pushed) {
			stack.push(num);

			while (!stack.isEmpty() && stack.peek() == popped[index]) {
				stack.pop();
				index++;
			}
		}

		return stack.isEmpty();
	}

// ===================测试代码=======================
	public void test() {
		int[] pushed = { 1, 2, 3, 4, 5 };
		int[] popped = { 4, 5, 3, 2, 1 };
		boolean result = validateStackSequences(pushed, popped);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
