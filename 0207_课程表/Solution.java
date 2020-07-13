import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

// ====================算法实现===============
	// 1、入读表 宽度优先遍历
	// 时间复杂度O(N + M),遍历一个图需要访问所有节点和所有临边，N和M分别为节点数量和临边数量；
	// 空间复杂度O(N + M),为建立邻接表所需额外空间，adjacency 长度为N，并存储M条临边的数据。
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		// 边界条件判断
		if (numCourses == 0 || prerequisites == null) {
			return false;
		}
		// 创建入读表
		int[] indegrees = new int[numCourses];
		// 创建队列
		Queue<Integer> queue = new LinkedList<Integer>();
		// 创建邻接表
		List<ArrayList<Integer>> adjacency = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < numCourses; ++i) {
			adjacency.add(new ArrayList<Integer>());
		}
		for (int[] cp : prerequisites) {
			indegrees[cp[0]]++;
			adjacency.get(cp[1]).add(cp[0]);
		}

		// 将入度为0的课程添加到队列中
		for (int i = 0; i < numCourses; ++i) {
			if (indegrees[i] == 0) {
				queue.add(i);
			}
		}

		// 宽带优先 拓扑排序 遍历每个节点的时候遍历每条边
		// 故时间复杂度为O(N + M)
		while (!queue.isEmpty()) {
			int pre = queue.poll();
			numCourses--;
			for (int cur : adjacency.get(pre)) {
				indegrees[cur] -= 1;
				if (indegrees[cur] == 0) {
					queue.add(cur);
				}
			}
		}
		return numCourses == 0;
	}

	// 2、递归 深度优先遍历
	// 时间复杂度：O(N + M)，历一个图需要访问所有节点和所有临边，N和M分别为节点数量和临边数量；
	// 递归过程每个节点和边均只访问一次
	// 空间复杂度：O(N + M)，为建立邻接表所需额外空间，adjacency 长度为N，并存储M条临边的数据。
	public boolean canFinish2(int numCourses, int[][] prerequisites) {
		// 边界条件判断
		if (numCourses == 0 || prerequisites == null) {
			return false;
		}
		// 创建标志位数组，判断每个节点的状态
		// 0：未被访问；1：被当前节点的DFS访问过；-1：被其他节点的DFS访问过,且不成环
		int[] flags = new int[numCourses];
		// 创建邻接表
		List<ArrayList<Integer>> adjacency = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < numCourses; ++i) {
			adjacency.add(new ArrayList<Integer>());
		}
		for (int[] cp : prerequisites) {
			adjacency.get(cp[1]).add(cp[0]);
		}

		// 深度优先遍历
		for (int i = 0; i < numCourses; ++i) {
			// 如果成环直接返回false
			if (!dfs(adjacency, flags, i)) {
				return false;
			}
		}
		return true;
	}

	private boolean dfs(List<ArrayList<Integer>> adjacency, int[] flags, int i) {
		if (flags[i] == 1) {
			return false;
		}
		if (flags[i] == -1) {
			return true;
		}
		flags[i] = 1;
		for (int j : adjacency.get(i)) {
			if (!dfs(adjacency, flags, j)) {
				return false;
			}
		}
		flags[i] = -1;
		return true;
	}

// ====================测试代码===============
	public static void main(String[] args) {
		Solution s = new Solution();
		int[][] prerequisites = { { 1, 0 } };
		int numCourses = 2;
		boolean result = s.canFinish2(numCourses, prerequisites);
		System.out.println(result);
	}

}
