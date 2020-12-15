import java.util.ArrayList;
import java.util.List;

public class Solution {

// ====================算法实现=====================
	// 方法 从上至下计算，滚动列表
	// 时间复杂度O(K)
	// 空间复杂度O(K)
	public List<Integer> getRow(int rowIndex) {

		List<Integer> list = new ArrayList<Integer>();
		// 第0行
		list.add(1);
		// 从第1行开始
		for (int i = 1; i <= rowIndex; ++i) {
			// 因为每一行的最后一个数字都是1，所以从倒数第二个数字开始计算，
			// 这里也是从当前列表的最后一个数字开始往前计算
			// 从后往前计算可以使用滚动列表
			for (int j = i - 1; j > 0; --j) {
				list.set(j, list.get(j - 1) + list.get(j));
			}
			// 每一行的最后一个数字
			list.add(1);
		}

		return list;
	}

// ====================测试代码=====================
	public void test() {
		int rowIndex = 3;
		List<Integer> result = getRow(rowIndex);
		for (int i : result) {
			System.out.print(i + "\t");
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
