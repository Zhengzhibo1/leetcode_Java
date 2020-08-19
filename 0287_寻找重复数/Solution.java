public class Solution {

// ====================算法实现===================
	// 1 二分查找
	// 时间复杂度O(NlogN)，N为数组长度，查找logN次，每次需要O(N)次比较
	// 空间复杂度O(1)
	public int findDuplicate(int[] nums) {

		int n = nums.length;
		int left = 1, right = n - 1, ans = -1;
		while (left <= right) {
			int middle = (left + right) >> 1;
			int count = 0;
			for (int i = 0; i < n; ++i) {
				if (nums[i] <= middle) {
					count++;
				}
			}

			if (count <= middle) {
				left = middle + 1;
			} else {
				right = middle - 1;
				ans = middle;
			}
		}

		return ans;
	}

	// 2 快慢指针
	// 数组存在重复数字，一定存在环
	// 时间复杂度O(n)
	// 空间复杂度O(1)
	public int findDuplicate2(int[] nums) {

		int slow = 0, fast = 0;

		// 找到环内节点
		do {
			slow = nums[slow];
			fast = nums[nums[fast]];
		} while (slow != fast);

		// 找到环的入口，即重复位置
		slow = 0;
		while (slow != fast) {
			slow = nums[slow];
			fast = nums[fast];
		}

		return slow;
	}

// ====================测试代码===================
	public void test() {
		int[] nums = { 1, 4, 6, 6, 6, 2, 3 };
		int ans = findDuplicate2(nums);
		System.out.println(ans);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
