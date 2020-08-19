import java.util.Arrays;
import java.util.Stack;

public class Solution {

// ====================算法实现=================
	// 1 暴力法
	// 时间复杂度O(MN)，其中M为温度区间长度，N为T数组长度
	// T中每个元素都要遍历一次next数组
	// 空间复杂度O(M)
	public int[] dailyTemperatures(int[] T) {

		int[] ans = new int[T.length];
		int[] next = new int[101];
		Arrays.fill(next, Integer.MAX_VALUE);

		for (int i = T.length - 1; i >= 0; --i) {

			int temp = Integer.MAX_VALUE;
			for (int t = T[i] + 1; t <= 100; ++t) {
				if (next[t] < temp) {
					temp = next[t];
				}
			}

			if (temp < Integer.MAX_VALUE) {
				ans[i] = temp - i;
			}

			next[T[i]] = i;
		}

		return ans;
	}

	// 单调栈
	// 时间复杂度O(n)，n为数组长度
	// 空间复杂度O(n)
	public int[] dailyTemperatures2(int[] T) {

		if (T == null || T.length == 0) {
			return null;
		}

		int[] ans = new int[T.length];
		Stack<Integer> stack = new Stack<Integer>();

		for (int i = 0; i < T.length; ++i) {
			int temperature = T[i];
			while (!stack.isEmpty() && temperature > T[stack.peek()]) {

				int preIndex = stack.pop();
				ans[preIndex] = i - preIndex;
			}

			stack.push(i);
		}

		return ans;
	}

// ====================测试代码=================
	public void test() {
		int[] temperatures = { 73, 74, 75, 71, 69, 72, 76, 73 };
		int[] ans = dailyTemperatures(temperatures);
		for (int i : ans) {
			System.out.print(i + "\t");
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
