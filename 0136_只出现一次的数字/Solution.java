public class Solution {

// ====================算法实现==================
	// 1 位运算 异或
	// 时间复杂度O(n)，n为数组的长度
	// 空间复杂度O(1)
	// 异或的三个性质：
	// 1、任何数和0做异或，结果仍然是原来的数
	// 2、任何数和其自身做异或，结果为0
	// 3、异或运算满足交换律和结合律
	public int singleNumber(int[] nums) {

		if (nums == null || nums.length == 0) {
			return -1;
		}

		int result = nums[0];
		for (int i = 1; i < nums.length; ++i) {
			result ^= nums[i];
		}

		return result;
	}

	// 该题还可以采用以下方法
	// 方法2 哈希表
	// 方法3 重复删除
	// 方法4 计算数组元素和

// ====================测试代码==================
	public void test() {
		int[] nums = { 2, 2, 1 };
		int result = singleNumber(nums);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
