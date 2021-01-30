public class Solution {

// ===================算法实现======================
	// 方法 位运算
	// 时间复杂度O(n)，n位数组长度
	// 空间复杂度O(1)
	public int singleNumber(int[] nums) {

		int once = 0, twice = 0;

		// 过滤掉出现3次的数字
		for (int num : nums) {
			once = ~twice & (once ^ num);
			twice = ~once & (twice ^ num);
		}

		return once;
	}

// ===================测试代码======================
	public void test() {
		int nums[] = { 0, 1, 0, 1, 0, 1, 99 };
		int result = singleNumber(nums);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
