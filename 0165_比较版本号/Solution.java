public class Solution {

// ===================算法实现======================
	public int compareVersion(String version1, String version2) {

		String[] v1 = version1.split("\\.");
		String[] v2 = version2.split("\\.");

		int length = Math.max(v1.length, v2.length);
		for (int i = 0; i < length; ++i) {
			int temp1 = i < v1.length ? Integer.parseInt(v1[i]) : 0;
			int temp2 = i < v2.length ? Integer.parseInt(v2[i]) : 0;
			if (temp1 < temp2) {
				return -1;
			}

			if (temp1 > temp2) {
				return 1;
			}
		}

		return 0;
	}

// ===================测试代码======================
	public void test() {
		String version1 = "1.01";
		String version2 = "1.001";
		int result = compareVersion(version1, version2);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
