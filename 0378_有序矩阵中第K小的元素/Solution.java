import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

// ====================算法实现===================
	// 1 大顶堆
	// 时间复杂度O(n^2 log K)
	// 空间复杂度O(k)
	public int kthSmallest(int[][] matrix, int k) {

		// 边界条件判断
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return -1;
		}

		// 大顶堆
		// 每次操作时间复杂度为O(log k)，其中k为队列大小
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}

		});

		int rows = matrix.length;
		int cols = matrix[0].length;
		for (int i = 0; i < rows; ++i) {
			for (int j = 0; j < cols; ++j) {
				if (queue.size() < k) {
					queue.add(matrix[i][j]);
				} else {
					int temp = queue.peek();
					if (matrix[i][j] < temp) {
						queue.poll();
						queue.add(matrix[i][j]);
					}
				}
			}
		}

		return queue.peek();
	}

	// 2 归并排序 小顶堆
	// 时间复杂度O(k log n)，归并k次，每次操作O(log n)
	// 空间复杂度O(n)，小顶堆大小
	public int kthSmallest2(int[][] matrix, int k) {

		// 边界条件判断
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return -1;
		}

		// 创建小顶堆 数组：第一个元素，值；第二个元素，行；第三个元素，列
		PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}

		});

		int n = matrix.length;
		for (int i = 0; i < n; ++i) {
			queue.offer(new int[] { matrix[i][0], i, 0 });
		}

		for (int i = 0; i < k - 1; ++i) {
			int[] temp = queue.poll();
			if (temp[2] != n - 1) {
				queue.offer(new int[] { matrix[temp[1]][temp[2] + 1], temp[1], temp[2] + 1 });
			}
		}

		return queue.poll()[0];
	}

// ====================测试代码===================
	public void test() {
		int[][] matrix = { { 1, 5, 9 }, { 10, 11, 13 }, { 12, 13, 15 } };
		int k = 8;
		int result = kthSmallest2(matrix, k);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
