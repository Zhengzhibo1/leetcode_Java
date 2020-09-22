import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {

// ====================算法实现=====================
	// 1 排序
	// 时间复杂度O(time)，由于任务种类一定，故时间复杂度取决于任务的数量
	// 空间复杂度O(1)
	public int leastInterval(char[] tasks, int n) {

		if (tasks == null || tasks.length == 0) {
			return 0;
		}

		int time = 0;

		int counts[] = new int[26];
		for (int i = 0; i < tasks.length; ++i) {
			counts[tasks[i] - 'A']++;
		}
		Arrays.sort(counts);
		while (counts[25] > 0) {
			int i = 0;
			while (i <= n) {
				if (counts[25] == 0) {
					break;
				}

				if (i < 26 && counts[25 - i] > 0) {
					counts[25 - i]--;
				}

				time++;
				i++;
			}

			Arrays.sort(counts);
		}

		return time;
	}

	// 2 优先队列
	// 时间复杂度O(time)
	// 空间复杂度O(1)
	public int leastInterval2(char[] tasks, int n) {

		if (tasks == null || tasks.length == 0) {
			return 0;
		}

		int time = 0;

		int counts[] = new int[26];
		for (int i = 0; i < tasks.length; ++i) {
			counts[tasks[i] - 'A']++;
		}

		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(26, Collections.reverseOrder());

		for (int i : counts) {
			if (i > 0) {
				queue.offer(i);
			}
		}

		while (!queue.isEmpty()) {
			int i = 0;
			List<Integer> temp = new ArrayList<Integer>();
			while (i <= n) {
				if (!queue.isEmpty()) {
					if (queue.peek() > 1) {
						temp.add(queue.poll() - 1);
					} else {
						queue.poll();
					}
				}
				time++;
				if (queue.isEmpty() && temp.size() == 0) {
					break;
				}
				i++;
			}

			for (int num : temp) {
				queue.offer(num);
			}
		}

		return time;
	}

// ===================测试代码======================
	public void test() {
		char tasks[] = { 'A', 'A', 'A', 'B', 'B', 'B' };
		int n = 2;
		int result = leastInterval2(tasks, n);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
