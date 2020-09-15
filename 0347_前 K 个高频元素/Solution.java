import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {

// ====================算法实现=====================
	// 1 小顶堆
	// 时间复杂度O(n log k)，其中统计频率时间复杂度O(n)，小顶堆为O(n log k)
	// 空间复杂度O(n)，map为O(n)，小顶堆为O(k)
	public int[] topKFrequent(int[] nums, int k) {

		// 边界条件判断
		if (nums == null || nums.length == 0) {
			return null;
		}

		// 结果数组
		int result[] = new int[k];

		// 字典存放出现频率
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; ++i) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
		}

		// 小顶堆
		PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {

				return o1[1] - o2[1];
			}

		});

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			int num = entry.getKey();
			int count = entry.getValue();

			if (queue.size() < k) {
				queue.add(new int[] { num, count });
			} else if (queue.peek()[1] < count) {
				queue.poll();
				queue.add(new int[] { num, count });
			}
		}

		for (int i = 0; i < k; ++i) {
			result[i] = queue.poll()[0];
		}
		return result;
	}

// ====================测试代码=====================
	public void test() {
		int nums[] = { 1, 1, 1, 2, 2, 3 };
		int k = 2;

		int result[] = topKFrequent(nums, k);
		for (int i : result) {
			System.out.print(i + "\t");
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
