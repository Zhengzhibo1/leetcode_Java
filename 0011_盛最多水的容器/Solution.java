public class Solution {

// ===================算法实现===================
	public int maxArea(int[] height) {

		// 边界条件判定
		if (height == null || height.length == 0) {
			return 0;
		}

		// 定义左右索引
		int left = 0, right = height.length - 1;
		int result = 0;
		while (left < right) {
			int temp = Math.min(height[left], height[right]) * (right - left);
			result = Math.max(result, temp);

			// 移动较小值的位置
			if (height[left] < height[right]) {
				left++;
			} else {
				right--;
			}
		}

		return result;
	}

// ===================测试代码===================
	public void test() {
		int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		int result = maxArea(height);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
