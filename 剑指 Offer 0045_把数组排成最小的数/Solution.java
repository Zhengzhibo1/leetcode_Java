import java.util.Arrays;
import java.util.Comparator;

public class Solution {

// ===================算法实现====================
	// 方法1 排序法
	// 时间复杂度O(n log n)
	// 空间复杂度O(n)
	public String minNumber(int[] nums) {

		String[] strs = new String[nums.length];
		for (int i = 0; i < nums.length; ++i) {
			strs[i] = String.valueOf(nums[i]);
		}

		Arrays.sort(strs, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				String a = o1 + o2;
				String b = o2 + o1;
				return a.compareTo(b);
			}

		});
		StringBuilder sb = new StringBuilder();
		for (String s : strs) {
			sb.append(s);
		}

		return sb.toString();
	}

	// 方法2 快速排序
	// 时间复杂度O(n log n)
	// 空间复杂度O(n)
	public String minNumber2(int[] nums) {

		String[] strs = new String[nums.length];
		for (int i = 0; i < nums.length; ++i) {
			strs[i] = String.valueOf(nums[i]);
		}
		fastSort(strs, 0, strs.length - 1);
		StringBuilder sb = new StringBuilder();
		for (String s : strs) {
			sb.append(s);
		}

		return sb.toString();
	}

	private void fastSort(String[] strs, int left, int right) {
		if (left >= right) {
			return;
		}
		int i = left, j = right;
		String temp = strs[i];
		while (i < j) {
			while ((strs[j] + strs[left]).compareTo(strs[left] + strs[j]) >= 0 && i < j) {
				j--;
			}
			while ((strs[i] + strs[left]).compareTo(strs[left] + strs[i]) <= 0 && i < j) {
				i++;
			}

			// 交换
			temp = strs[i];
			strs[i] = strs[j];
			strs[j] = temp;
		}

		strs[i] = strs[left];
		strs[left] = temp;
		fastSort(strs, left, i - 1);
		fastSort(strs, i + 1, right);
	}

// ===================测试代码====================
	public void test() {
		int[] nums = { 3, 30, 34, 5, 9 };
		String minNum = minNumber2(nums);
		System.out.println(minNum);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
