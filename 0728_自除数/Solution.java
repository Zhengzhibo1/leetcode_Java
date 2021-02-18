import java.util.ArrayList;
import java.util.List;

public class Solution {

// ===================算法实现===================
	public List<Integer> selfDividingNumbers(int left, int right) {

		List<Integer> resultList = new ArrayList<Integer>();
		// 边界条件判断
		if (left > right) {
			return resultList;
		}

		// 标志位，判断是否是自除数
		boolean flag = true;
		for (int i = left; i <= right; ++i) {
			flag = true;
			int temp = i;
			while (temp != 0) {
				int val = temp % 10;
				if (val == 0) {
					flag = false;
					break;
				}

				if (i % val != 0) {
					flag = false;
					break;
				}

				temp = temp / 10;
			}

			if (flag) {
				resultList.add(i);
			}
		}

		return resultList;
	}

// ===================测试代码===================
	public void test() {
		int left = 1;
		int right = 22;
		List<Integer> resultList = selfDividingNumbers(left, right);
		for (int i : resultList) {
			System.out.print(i + "\t");
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
