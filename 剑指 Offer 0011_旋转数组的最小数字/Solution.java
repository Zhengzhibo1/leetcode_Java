public class Solution {

// ===================算法实现========================
	// 方法 二分查找
	// 时间复杂度O(n)
	// 空间复杂度O(n)
	public int minArray(int[] numbers) {

		int start = 0;
		int end = numbers.length - 1;

		while (start < end) {
			int middle = start + (end - start) >> 1;
			// 与最后一个数字比较，便于找出未旋转数组的最小值
			if (numbers[middle] > numbers[end]) {
				start = middle + 1;
			} else if (numbers[middle] < numbers[end]) {
				end = middle;
			} else {
				end = end - 1;
			}
		}

		return numbers[end];
	}

// ===================测试代码========================
	public void test() {
		int[] numbers = { 1, 3, 5 };
		int result = minArray(numbers);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
