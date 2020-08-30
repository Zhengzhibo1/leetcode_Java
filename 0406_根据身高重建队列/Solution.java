import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Solution {

// ====================算法实现===================
	// 1 贪心算法
	// 矮的人相对于高的人不可见
	// 时间复杂度O(n^2)，其中排序O(N log N)，但最后调整的时候数组的插入移动时间复杂度为O(n)
	// 空间复杂度O(n)
	public int[][] reconstructQueue(int[][] people) {

		// 边界条件判断
		if (people == null || people.length == 0 || people[0].length == 0) {
			return new int[][] {};
		}

		// 先按身高降序排序，身高相等按k值升序排序
		Arrays.sort(people, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {

				return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
			}

		});

		List<int[]> answer = new LinkedList<int[]>();
		// 最后调整
		for (int[] p : people) {
			answer.add(p[1], p);
		}

		return answer.toArray(new int[1][2]);
	}

// ====================测试代码===================
	public void test() {
		int[][] people = { { 7, 0 }, { 4, 4 }, { 7, 1 }, { 5, 0 }, { 6, 1 }, { 5, 2 } };

		int[][] answer = reconstructQueue(people);
		for (int[] ii : answer) {
			for (int i : ii) {
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
