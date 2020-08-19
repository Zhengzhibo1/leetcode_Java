import java.util.Arrays;
import java.util.Random;

public class Solution {

// ====================算法实现====================
	// 1 库函数
	// 时间复杂度O(NlgoN)，排序所需时间
	// 空间复杂度O(logN)，排序所需辅助空间
	public int findKthLargest(int[] nums, int k) {

		Arrays.sort(nums);
		return nums[nums.length - k];
	}

	// 2 基于快速排序的选择方法
	// 快排每次随机选出一个节点，其左边的元素均小于等于该节点，右边的元素均比该元素大
	// 每次均拿目标值下标与该值小标进行对比，减少完全排序的消耗
	// 空间复杂度O(n)，n为数组长度
	// 时间复杂度O(log n)，递归栈深度
	public int findKthLargest2(int[] nums, int k) {
		return quickSelect(nums, 0, nums.length - 1, nums.length - k);
	}

	public int quickSelect(int[] nums, int left, int right, int index) {
		// 获取随机数字的下标
		int randomIndex = randomPartition(nums, left, right);
		// 若该数字下标所求下标相等，该下标所在值即为所求值
		if (randomIndex == index) {
			return nums[randomIndex];
		} else {
			// 如果该坐标小于所求下标，即对该坐标右边部分进行快排
			// 如果该坐标大于所求下标，即对该坐标左边部分进行快排
			return randomIndex < index ? quickSelect(nums, randomIndex + 1, right, index)
					: quickSelect(nums, left, randomIndex - 1, index);
		}
	}

	// 快排实现
	public int randomPartition(int[] nums, int left, int right) {
		// 随机选取数组中某元素下标
		Random random = new Random();
		int randomIndex = random.nextInt(right - left + 1) + left;
		// 将该元素与数组最右边元素进行交换
		swap(nums, randomIndex, right);
		// 从头比对各元素与该元素的大小关系
		// 小于该元素往数组左边移
		int position = left;
		for (int i = left; i < right; ++i) {
			if (nums[i] < nums[right]) {
				swap(nums, i, position);
				position++;
			}
		}
		// 将该元素交换到合适的位置
		swap(nums, position, right);
		return position;
	}

	// 交换数组两元素
	public void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	// 3 基于堆排序的选择方法
	// 时间复杂度O(n log n)
	// 空间复杂度O(1)
	public int findKthLargest3(int[] nums, int k) {

		int heapSize = nums.length;
		// 创建大顶堆
		for (int i = heapSize / 2; i >= 0; --i) {
			heapAdjust(nums, i, heapSize);
		}

		for (int i = nums.length - 1; i > nums.length - k; --i) {
			int temp = nums[0];
			nums[0] = nums[i];
			nums[i] = temp;

			--heapSize;
			heapAdjust(nums, 0, heapSize);
		}

		return nums[0];
	}

	// 大顶堆调整
	public void heapAdjust(int[] nums, int index, int heapSize) {
		int temp = nums[index];
		for (int j = 2 * index + 1; j < heapSize; j = j * 2 + 1) {
			if (j < heapSize - 1 && nums[j] < nums[j + 1]) {
				j++;
			}

			if (nums[j] < temp) {
				break;
			} else {
				nums[index] = nums[j];
				index = j;
			}
		}
		nums[index] = temp;
	}

// ====================测试代码====================
	public void test() {
		int[] nums = { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
		int k = 4;
		int result = findKthLargest2(nums, k);
		System.out.println(result);
	}

	public void test1() {
		int[] nums = { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
		int k = 4;
		int result = findKthLargest2(nums, k);
		System.out.println(result);
	}

	public void test2() {
		int[] nums = { 3, 2, 3, 1, 2, 4, 5, 5, 6, 7, 7, 8, 2, 3, 1, 1, 1, 10, 11, 5, 6, 2, 4, 7, 8, 5, 6 };
		int k = 2;
		int result = findKthLargest3(nums, k);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();
		s.test1();
		s.test2();

	}

}
