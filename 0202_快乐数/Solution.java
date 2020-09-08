import java.util.HashSet;
import java.util.Set;

public class Solution {

// ====================算法实现========================
	// 1 HashSet检测循环
	// 时间复杂度O(logN)
	// 空间复杂度O(logN)
	public boolean isHappy(int n) {

		Set<Integer> set = new HashSet<Integer>();

		int temp = n;
		while (!set.contains(temp)) {

			set.add(temp);

			int num = 0;
			while (temp != 0) {
				num += Math.pow(temp % 10, 2);
				temp = temp / 10;
			}

			if (num == 1) {
				return true;
			}
			temp = num;
		}

		return false;
	}

	// 2 双指针，快慢指针
	// 时间复杂度O(logN)
	// 空间复杂度O(1)
	public int getNext(int n) {
		int num = 0;
		while (n != 0) {
			num += Math.pow(n % 10, 2);
			n = n / 10;
		}

		return num;
	}

	public boolean isHappy2(int n) {
		int slow = n;
		int fast = getNext(n);

		while (fast != 1 && fast != slow) {
			slow = getNext(slow);
			fast = getNext(getNext(fast));
		}

		return fast == 1;
	}

// ====================测试代码========================
	public void test() {
		int n = 19;
		boolean result = isHappy(n);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
