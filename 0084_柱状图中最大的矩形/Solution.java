import java.util.Arrays;
import java.util.Stack;

public class Solution {

// ===================算法实现====================
	// 方法 单调栈
	// 时间复杂度O(N)，其中N为数组长度，每个元素入栈，出栈一次
	// 空间复杂度O(N)
	/*
	 * 核心思想，固定高度，寻找左右边界 如何找左边界？ 首先可以利用栈，存在数据，从左到右，高度递增，
	 * 这样在往栈中添加一个高度时，要移除所有比当前高度高的数据， 这样它的前一个数据就是左边界，若栈为空时，-1为哨兵节点 同理，从右到左，寻找右边界。
	 */
	public int largestRectangleArea(int[] heights) {

		// 边界条件判断
		if (heights == null || heights.length == 0) {
			return 0;
		}

		int length = heights.length;
		// 用来存放左边界
		int left[] = new int[length];
		// 用来存放右边界
		int right[] = new int[length];

		Stack<Integer> stack = new Stack<Integer>();
		// 寻找左边界
		for (int i = 0; i < length; ++i) {
			while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
				stack.pop();
			}
			left[i] = stack.isEmpty() ? -1 : stack.peek();
			stack.push(i);
		}

		stack.clear();
		// 寻找右边界
		for (int i = length - 1; i >= 0; --i) {
			while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
				stack.pop();
			}
			right[i] = stack.isEmpty() ? length : stack.peek();
			stack.push(i);
		}

		int ans = 0;
		for (int i = 0; i < length; ++i) {
			ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
		}

		return ans;
	}

	/*
	 * 优化，在寻找左边界的时候求出右边界，使数据从栈中弹出的数据即为弹出数据的右边界，
	 * 实际算法求得【一根柱子的左侧且最近得小于其高度的柱子】，但此处需要的是小于等于， 因此会造成当高度相等时，前面柱子的右侧边界不正确，但是不影响总体结果，
	 * 因为最右侧的柱子的右侧边界是正确的，所以还是能够通过最右侧柱子求出正确结果。
	 */
	public int largestRectangleArea2(int[] heights) {

		// 边界条件判断
		if (heights == null || heights.length == 0) {
			return 0;
		}

		int length = heights.length;
		// 用来存放左边界
		int left[] = new int[length];
		// 用来存放右边界
		int right[] = new int[length];
		// 初始化右边界
		Arrays.fill(right, length);

		Stack<Integer> stack = new Stack<Integer>();
		// 寻找左边界
		for (int i = 0; i < length; ++i) {
			while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
				// 被弹出数据的右侧边界
				right[stack.pop()] = i;
			}
			left[i] = stack.isEmpty() ? -1 : stack.peek();
			stack.push(i);
		}

		int ans = 0;
		for (int i = 0; i < length; ++i) {
			ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
		}

		return ans;
	}

// ===================测试代码====================
	public void test() {
		int heights[] = { 2, 1, 5, 6, 2, 3 };
		int res = largestRectangleArea2(heights);
		System.out.println(res);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();
	}

}
