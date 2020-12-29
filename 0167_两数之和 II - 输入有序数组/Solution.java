public class Solution {

// ====================算法实现==================
	// 方法 双指针法
	// 时间复杂度O(n)
	// 空间复杂度O(n)
	public int[] twoSum(int[] numbers, int target) {

		int result[] = new int[2];
		if (numbers == null || numbers.length < 2) {
			return result;
		}

		int left = 0, right = numbers.length - 1;
		while (left < right) {
			int sum = numbers[left] + numbers[right];
			if (sum == target) {
				result[0] = left + 1;
				result[1] = right + 1;
				return result;
			} else if (sum > target) {
				right--;
			} else {
				left++;
			}

		}
		return result;
	}

// ====================测试代码==================
	public void test() {
		int numbers[] = { 2, 7, 11, 15 };
		int target = 9;
		int result[] = twoSum(numbers, target);
		System.out.println("index1: " + result[0]);
		System.out.println("index2: " + result[1]);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
