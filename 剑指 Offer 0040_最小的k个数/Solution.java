import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

// ===================算法实现=======================
	// 方法 大顶堆
	// 时间复杂度O(nlogK)，大顶堆的插入删除时间复杂度为O(logK)
	// 空间复杂度O(k)
	public int[] getLeastNumbers(int[] arr, int k) {

		int[] result = new int[k];
		if (k == 0) {
			return result;
		}

		// 创建大顶堆
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}

		});

		for (int i = 0; i < arr.length; ++i) {
			if (queue.size() < k) {
				queue.offer(arr[i]);
			} else {
				if (queue.peek() > arr[i]) {
					queue.poll();
					queue.offer(arr[i]);
				}
			}
		}

		for (int i = 0; i < k; ++i) {
			result[i] = queue.poll();
		}

		return result;
	}

// ===================测试代码=======================
	public void test() {
		int[] arr = { 3, 2, 1 };
		int k = 2;
		int[] result = getLeastNumbers(arr, k);
		for (int i : result) {
			System.out.print(i + "\t");
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
