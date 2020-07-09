public class Solution {

// ====================算法实现==================

	// 1、合并两数组再求中位数，默认输入数组不为空
	// 时间复杂度为O(m+n)
	// 空间复杂度O(m+n)
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {

		double result = 0;
		if (nums1.length == 0 && nums2.length == 0) {
			return 0;
		}

		if (nums1.length == 0) {
			if ((nums2.length & 1) == 0) {
				result = (nums2[(nums2.length >> 1) - 1] + nums2[nums2.length >> 1]) / 2.0;
			} else {
				result = nums2[nums2.length >> 1];
			}
			return result;
		}

		if (nums2.length == 0) {
			if ((nums1.length & 1) == 0) {
				result = (nums1[(nums1.length >> 1) - 1] + nums1[nums1.length >> 1]) / 2.0;
			} else {
				result = nums1[nums1.length >> 1];
			}
			return result;
		}

		int[] nums = new int[nums1.length + nums2.length];
		int index1 = 0;
		int index2 = 0;
		int index = 0;
		while (index != nums1.length + nums2.length) {
			if (nums1[index1] <= nums2[index2]) {
				nums[index] = nums1[index1];
				index1++;
			} else {
				nums[index] = nums2[index2];
				index2++;
			}
			index++;
			if (index1 == nums1.length && index2 != nums2.length) {
				while (index2 != nums2.length) {
					nums[index] = nums2[index2];
					index++;
					index2++;
				}
			} else if (index2 == nums2.length && index1 != nums1.length) {
				while (index1 != nums1.length) {
					nums[index] = nums1[index1];
					index++;
					index1++;
				}
			}
		}

		if ((nums.length & 1) == 0) {
			result = (nums[(nums.length >> 1) - 1] + nums[nums.length >> 1]) / 2.0;
		} else {
			result = nums[nums.length >> 1];
		}
		return result;
	}

	// 2、二分查找
	// 时间复杂度为O(log(m+n))
	// 空间复杂度O(1)
	public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
		int length1 = nums1.length;
		int length2 = nums2.length;
		int totalLength = length1 + length2;
		if ((totalLength & 1) == 1) {
			int midIndex = totalLength / 2;
			double median = getKthElement(nums1, nums2, midIndex + 1);
			return median;
		} else {
			int midIndex1 = totalLength / 2 - 1;
			int midIndex2 = totalLength / 2;
			double median = (getKthElement(nums1, nums2, midIndex1 + 1) + getKthElement(nums1, nums2, midIndex2 + 1))
					/ 2.0;
			return median;
		}
	}

	public int getKthElement(int[] nums1, int[] nums2, int k) {
		int length1 = nums1.length;
		int length2 = nums2.length;
		int index1 = 0, index2 = 0;

		while (true) {
			// 边界情况考虑
			if (index1 == length1) {
				return nums2[index2 + k - 1];
			}
			if (index2 == length2) {
				return nums1[index1 + k - 1];
			}
			if (k == 1) {
				return Math.min(nums1[index1], nums2[index2]);
			}

			// 正常情况
			int half = k / 2;
			int newIndex1 = Math.min(index1 + half, length1) - 1;
			int newIndex2 = Math.min(index2 + half, length2) - 1;
			int pivot1 = nums1[newIndex1], pivot2 = nums2[newIndex2];
			if (pivot1 <= pivot2) {
				k -= (newIndex1 - index1 + 1);
				index1 = newIndex1 + 1;
			} else {
				k -= (newIndex2 - index2 + 1);
				index2 = newIndex2 + 1;
			}
		}
	}
// =================测试代码==================

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] n1 = {};
		int[] n2 = {};
		double result = s.findMedianSortedArrays(n1, n2);
		System.out.println(result);

	}

}
