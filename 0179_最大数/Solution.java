import java.util.Arrays;
import java.util.Comparator;

public class Solution {

// ====================算法实现=======================
	// 方法 重构排序方法
	// 时间复杂度O(N log N)，N为数组长度，主要为排序的时间复杂度
	// 空间复杂度O(N)
	public String largestNumber(int[] nums) {

		// 边界条件判断
		if (nums == null || nums.length == 0) {
			return "0";
		}

		int length = nums.length;

		String[] strs = new String[length];
		for (int i = 0; i < length; ++i) {
			strs[i] = String.valueOf(nums[i]);
		}

		// 重写排序方法
		Arrays.sort(strs, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				String str1 = o1 + o2;
				String str2 = o2 + o1;
				return str2.compareTo(str1);
			}

		});

		// 如果全是0
		if (strs[0].equals("0")) {
			return "0";
		}

		StringBuilder sb = new StringBuilder();
		for (String temp : strs) {
			sb.append(temp);
		}

		return sb.toString();
	}

// ====================测试代码=======================
	public void test() {
		int[] nums = { 0, 0 };
		String result = largestNumber(nums);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
