public class Solution {

// ====================算法实现===================
	// 1 暴力法
	// 时间复杂度O(n^2)
	// 空间复杂度O(1)
	public int trap(int[] height) {

		int ans = 0;
		if (height == null || height.length == 0) {
			return ans;
		}

		for (int i = 1; i < height.length - 1; ++i) {
			int max_left = 0, max_right = 0;
			for (int j = 0; j <= i; ++j) {
				max_left = Math.max(max_left, height[j]);
			}
			for (int j = i; j < height.length; ++j) {
				max_right = Math.max(max_right, height[j]);
			}

			ans += Math.min(max_left, max_right) - height[i];
		}

		return ans;
	}

	// 2 左右最大值数组
	// 时间复杂度O(n)
	// 空间复杂度O(n)
	public int trap2(int[] height) {
		int ans = 0;
		if (height == null || height.length == 0) {
			return ans;
		}

		int[] max_left = new int[height.length];
		max_left[0] = height[0];
		int[] max_right = new int[height.length];
		max_right[height.length - 1] = height[height.length - 1];

		for (int i = 1; i < height.length - 1; ++i) {
			max_left[i] = Math.max(height[i], max_left[i - 1]);
		}

		for (int i = height.length - 2; i > 0; --i) {
			max_right[i] = Math.max(height[i], max_right[i + 1]);
		}

		for (int i = 1; i < height.length - 1; ++i) {
			ans += Math.min(max_left[i], max_right[i]) - height[i];
		}
		return ans;
	}

	// 3 双指针
	// 时间复杂度O(n)
	// 空间复杂度O(1)
	public int trap3(int[] height) {
		int ans = 0;
		if (height == null || height.length == 0) {
			return ans;
		}

		int left = 0, right = height.length - 1;
		int left_max = 0, right_max = 0;
		while (left < right) {
			if (height[left] < height[right]) {
				if (height[left] >= left_max) {
					left_max = height[left];
				} else {
					ans += left_max - height[left];
				}
				left++;
			} else {
				if (height[right] >= right_max) {
					right_max = height[right];
				} else {
					ans += right_max - height[right];
				}
				right--;
			}
		}

		return ans;
	}

// ====================测试代码===================
	public void test() {
		int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		int ans = trap3(height);
		System.out.println(ans);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
