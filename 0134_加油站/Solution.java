public class Solution {

// ====================算法实现=====================
	// 方法 一次遍历
	// 时间复杂度O(N)，其中N为数组长度
	// 空间复杂度O(1)
	public int canCompleteCircuit(int[] gas, int[] cost) {

		// 总加油站数量
		int n = gas.length;
		int i = 0; // 加油站起始位置
		int sumGas = 0; // 总加油量
		int sumCost = 0; // 总消耗量
		int count = 0; // 经过加油站数量
		int current = 0; // 当前所在加油站位置

		while (i < n) { // 循环中止条件为起始点为所有加油站
			count = 0; // 每次进入循环，经过加油站数量置0
			sumGas = 0; // 每次进入循环，总油量置0
			sumCost = 0; // 每次进入循环，总消耗量置0

			while (count < n) { // 循环中止条件为走过所有的加油站

				current = (i + count) % n; // 加油站成环
				sumGas += gas[current];
				sumCost += cost[current];
				if (sumGas < sumCost) {
					// 油量无法走到下一站,跳出循环
					break;
				}
				count++;
			}

			if (count == n) { // 如果走过所有加油站
				return i;
			} else {
				// 如果没能走过所有加油站，说明当前加油站的加油量小于消耗量
				// 故应该从当前加油站的下一个加油站开始遍历
				i = i + count + 1;
			}

		}
		return -1;
	}

// ====================测试代码=====================
	public void test() {
		int gas[] = { 1, 2, 3, 4, 5 };
		int cost[] = { 3, 4, 5, 1, 2 };
		int result = canCompleteCircuit(gas, cost);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
