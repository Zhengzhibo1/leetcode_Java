import java.util.Deque;
import java.util.LinkedList;

public class Solution {

// ===================算法实现===================
	// 方法 双端队列存放滑动窗口的最大值
	// 时间复杂度O(n)，n为数组的长度
	// 空间复杂度O(k)
	public int[] maxSlidingWindow(int[] nums, int k) {

		// 边界条件判断
		if (nums == null || nums.length == 0 || nums.length < k) {

			return new int[0];
		}
		int[] maxValue = new int[nums.length - k + 1];
		// 双端队列存放最大值
		Deque<Integer> deque = new LinkedList<Integer>();

		// 未完全形成窗口
		for (int i = 0; i < k; ++i) {

			// 从队列尾部开始删除比当前值小的点
			while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
				deque.pollLast();
			}
			deque.offer(nums[i]);
		}

		maxValue[0] = deque.peekFirst();

		// 形成窗口后
		for (int i = k; i < nums.length; ++i) {

			// 删除窗口第一个值
			if (nums[i - k] == deque.peekFirst()) {
				deque.pollFirst();
			}

			// 添加当前值
			while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
				deque.pollLast();
			}
			deque.offer(nums[i]);

			maxValue[i - k + 1] = deque.peekFirst();
		}

		return maxValue;
	}

// ===================测试代码===================
	public void test() {
		int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
		int k = 3;
		int[] maxValue = maxSlidingWindow(nums, k);
		for (int num : maxValue) {
			System.out.print(num + "\t");
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
