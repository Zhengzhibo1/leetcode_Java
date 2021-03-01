import java.util.ArrayList;
import java.util.List;

public class Solution {

// ===================算法实现======================
	// 方法 双指针法
	// 时间复杂度O(n)，只会移动到 target / 2 处
	// 空间复杂度O(n)
	public int[][] findContinuousSequence(int target) {

		int left = 1, right = 2, curSum = 3;
		List<int[]> resultList = new ArrayList<int[]>();
		while (left < right) {

			if (curSum == target) {
				int[] temp = new int[right - left + 1];
				for (int i = left; i <= right; ++i) {
					temp[i - left] = i;
				}
				resultList.add(temp);
			}

			if (curSum >= target) {
				curSum -= left;
				left++;
			}

			if (curSum < target) {
				right++;
				curSum += right;
			}
		}

		return resultList.toArray(new int[0][]);
	}

// ===================测试代码======================
	public void test() {
		int target = 15;
		int[][] result = findContinuousSequence(target);
		for (int[] temp : result) {
			for (int i : temp) {
				System.out.print(i + "\t");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
