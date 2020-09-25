import java.util.Arrays;

public class Solution {

// ====================算法实现=======================
	// 1 双指针，从前往后
	// 时间复杂度都O(m + n)
	// 空间复杂度O(m)，创建临时数组
	public void merge(int[] nums1, int m, int[] nums2, int n) {

		if (nums1 == null) {

			if (nums1 == null) {
				System.arraycopy(nums2, 0, nums1, m, n);
			}

			if (nums2 == null) {
				return;
			}

			System.arraycopy(nums2, 0, nums1, m, n);
			Arrays.sort(nums1);
		}

		if (nums2 == null) {
			return;
		}

		int temp[] = new int[m];
		System.arraycopy(nums1, 0, temp, 0, m);
		int index1 = 0;
		int index2 = 0;
		int tempIndex = 0;
		while (index1 < m && index2 < n) {
			if (temp[index1] <= nums2[index2]) {
				nums1[tempIndex] = temp[index1];
				index1++;
			} else {
				nums1[tempIndex] = nums2[index2];
				index2++;
			}

			tempIndex++;
		}

		while (index1 < m) {
			nums1[tempIndex++] = temp[index1++];
		}

		while (index2 < n) {
			nums1[tempIndex++] = nums2[index2++];
		}

	}

	// 2 先合并在排序
	// 关于Arrays.sort()排序算法
	// 根据传入参数选择以下排序算法
	// 1、 基本数据类型选择快速排序
	// 2、 对象数组选择归并排序
	// 快速排序不稳定，归并排序稳定
	// 两种排序平均时间复杂度为O(n log n)
	// 归并排序需要O(n)的额外空间
	// 本题复杂度
	// 时间复杂度O((m + n) log (m + n))
	// 空间复杂度O(1)
	public void merge2(int[] nums1, int m, int[] nums2, int n) {

		if (nums1 == null) {
			System.arraycopy(nums2, 0, nums1, m, n);
		}

		if (nums2 == null) {
			return;
		}

		System.arraycopy(nums2, 0, nums1, m, n);
		Arrays.sort(nums1);

	}

	// 3 双指针，从后往前
	// 时间复杂度O(m + n)
	// 空间复杂度O(1)
	public void merge3(int[] nums1, int m, int[] nums2, int n) {

		if (nums1 == null || nums1.length == 0) {
			System.arraycopy(nums2, 0, nums1, m, n);
		}

		if (nums2 == null) {
			return;
		}

		int index1 = m - 1;
		int index2 = n - 1;
		int index = m + n - 1;

		while (index1 >= 0 && index2 >= 0) {
			if (nums1[index1] >= nums2[index2]) {
				nums1[index] = nums1[index1];
				index1--;
			} else {
				nums1[index] = nums2[index2];
				index2--;
			}

			index--;
		}

		while (index1 >= 0) {
			nums1[index--] = nums1[index1--];
		}

		while (index2 >= 0) {
			nums1[index--] = nums2[index2--];
		}

	}

// ====================测试代码=======================
	public void test() {
		int nums1[] = { 1, 2, 3, 0, 0, 0 };
		int nums2[] = { 2, 5, 6 };
		int m = 3;
		int n = 3;

		merge3(nums1, m, nums2, n);
		for (int i : nums1) {
			System.out.print(i + "\t");
		}
	}

	public void test2() {
		int nums1[] = { 2, 0 };
		int nums2[] = { 1 };
		int m = 1;
		int n = 1;
		merge3(nums1, m, nums2, n);
		for (int i : nums1) {
			System.out.print(i + "\t");
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test2();

	}

}
