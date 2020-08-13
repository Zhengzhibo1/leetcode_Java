import java.util.ArrayList;
import java.util.Arrays;
//import java.util.Comparator;
import java.util.List;

public class Solution {

// ====================算法实现=================
	// 1 排序合并
	// 时间复杂度O(NlogN)，排序所需时间
	// 空间复杂度O(logN)，排序所需空间
	public int[][] merge(int[][] intervals) {

		if (intervals == null || intervals.length == 0 || intervals[0].length == 0) {
			return new int[0][];
		}

		// 对数组进行排序，按照第一个元素的升序排序
		// Lambda表达式最简写法
		Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);

//		Arrays.sort(intervals, new Comparator<int[]>() {
//
//			@Override
//			public int compare(int[] o1, int[] o2) {
//				return o1[0] - o2[0];
//			}
//
//		});

		/*
		 * 关于接口Comparator的方法compare(o1, o2)的一些见解： 此方法为抽象方法 int compare(T o1, T o2)
		 * 比较用来排序的两个参数。 关于返回值：如果该方法返回值小于0，则代表o1，o2的位置不需要改变，即o1在前，o2在后。
		 * 如果该方法返回值大于0，则代表o1，o2的位置需要改变，即o2在前，o1在后。
		 * 另外一种见解：该方法的返回值代表了两个参数的权重大小，返回值大于0，代表前者权重大， 返回值小于0，代表后者权重大，最后按权重默认升序排列。
		 * 最后，虽然接口Comparator有两个抽象方法，int compare(T o1, T o2)，boolean equals(Object obj)
		 * 但继承时仅需实现compare方法即可，具体JAVA核心技术卷1应该有解释。
		 */

		// 创建列表存放临时结果
		List<int[]> results = new ArrayList<int[]>();

		// 对二维数组中的每个数组进行遍历
		// 判断当前数组的左值是否小于结果列表最后一个元素的右值
		// 若小于或等于，则合并
		// 若大于，则直接将当前数组添加进去
		for (int i = 0; i < intervals.length; ++i) {
			int left = intervals[i][0], right = intervals[i][1];
			if (results.isEmpty() || results.get(results.size() - 1)[1] < left) {
				results.add(new int[] { left, right });
			} else {
				results.get(results.size() - 1)[1] = Math.max(results.get(results.size() - 1)[1], right);
			}
		}

		return results.toArray(new int[0][]);
	}

	/*
	 * 使用集合转数组得方法，必须使用集合的toArray(T[] array)，传入的是类型完全一样的数组，大小就是list.size()
	 * 使用toArray带参数方法，入参分配的数组空间不够大时，toArray方法内部将重新分配内存空间，并返回新数组地址；
	 * 如果数组元素个数大于实际所需，下标为[list.size()]的数组元素被设置为null，其他数组元素保持原值，
	 * 因此最好将方法入参数组大小定义与集合元素个数一致
	 * 
	 * 直接使用toArray无参数方法存在问题，此方法返回值只能是Object[]类，若强转其他类型数组将出现 ClassCastException错误。
	 */

// ====================测试代码=================
	public void test() {
		int[][] intervals = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
		int[][] results = merge(intervals);
		for (int[] result : results) {
			for (int i : result) {
				System.out.print(i + "\t");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
