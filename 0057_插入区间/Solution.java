import java.util.ArrayList;
import java.util.List;

public class Solution {

// ===================算法实现========================
	// 方法 模拟，一次遍历
	// 时间复杂度O(n)，n为给定区间个数
	// 空间复杂度O(n)，存放临时结果
	public int[][] insert(int[][] intervals, int[] newInterval) {

		int left = newInterval[0];
		int right = newInterval[1];

		// 新区间是否插入标志位
		boolean flag = false;

		List<int[]> result = new ArrayList<int[]>();
		for (int[] interval : intervals) {

			if (interval[0] > right) {
				// 如果当前区间在新插入区间右侧且无交集
				if (!flag) {
					result.add(new int[] { left, right });
					flag = true;
				}

				result.add(interval);
			} else if (interval[1] < left) {
				// 如果当前区间在新插入区间左侧且无交集
				result.add(interval);
			} else {
				// 当前区间与新插入区间有交集
				left = Math.min(left, interval[0]);
				right = Math.max(right, interval[1]);
			}
		}

		if (!flag) {
			result.add(new int[] { left, right });
		}

		int ans[][] = new int[result.size()][2];
		for (int i = 0; i < result.size(); ++i) {
			ans[i] = result.get(i);
		}

		return ans;
	}

// ===================测试代码========================
	public void test() {
		int intervals[][] = { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 } };
		int newInterval[] = { 4, 8 };

		int result[][] = insert(intervals, newInterval);
		for (int[] interval : result) {
			System.out.println(interval[0] + " " + interval[1]);
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
