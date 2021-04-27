public class Solution {

// ====================算法实现===================
	public double angleClock(int hour, int minutes) {

		double h = hour * 30;
		double m = (double) minutes / 60 * 360;
		h += (double) minutes / 60 * 30;
		return Math.min(Math.abs(h - m), 360 - Math.abs(h - m));
	}

// ====================测试代码===================
	public void test() {
		int hour = 3;
		int minutes = 15;
		double result = angleClock(hour, minutes);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
