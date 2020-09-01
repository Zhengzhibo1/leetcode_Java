import java.util.Deque;
import java.util.LinkedList;

public class Solution {

// ====================算法实现=================
	// 1 双向队列
	// 时间复杂度O(n)
	// 空间复杂度O(n)
	public int[] maxSlidingWindow(int[] nums, int k) {

		// 边界条件判断
		if (nums == null || nums.length == 0 || nums.length < k) {
			return null;
		}

		int[] result = new int[nums.length - k + 1];

		// 双端队列
		Deque<Integer> deque = new LinkedList<Integer>();

		for (int i = 0; i < k; ++i) {
			while (!deque.isEmpty() && nums[i] > nums[deque.getLast()]) {
				deque.removeLast();
			}
			deque.add(i);
		}

		for (int i = k; i < nums.length; ++i) {
			result[i - k] = nums[deque.getFirst()];

			while (!deque.isEmpty() && nums[i] > nums[deque.getLast()]) {
				deque.removeLast();
			}

			if (!deque.isEmpty() && deque.getFirst() <= i - k) {
				deque.removeFirst();
			}

			deque.add(i);
		}

		result[nums.length - k] = nums[deque.getFirst()];
		return result;
	}

// ====================测试代码=================
	public void test() {
		int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
		int k = 3;
		int[] result = maxSlidingWindow(nums, k);
		for (int i : result) {
			System.out.print(i + "\t");
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
