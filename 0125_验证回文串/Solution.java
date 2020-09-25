public class Solution {

// ====================算法实现=======================
	// 1 筛选 翻转
	// 时间复杂度O(n)，其中n为字符串长度
	// 空间复杂度O(n)
	public boolean isPalindrome(String s) {

		if (s == null || s.length() == 0) {
			return true;
		}

		StringBuffer sgoods = new StringBuffer();
		for (int i = 0; i < s.length(); ++i) {
			char temp = s.charAt(i);
			if (Character.isLetterOrDigit(temp)) {
				sgoods.append(Character.toLowerCase(temp));
			}
		}

		StringBuffer sgoods_rev = new StringBuffer(sgoods).reverse();
		return sgoods.toString().equals(sgoods_rev.toString());
	}

	// 2 筛选 双指针
	// 时间复杂度O(n)
	// 空间复杂度O(n)
	public boolean isPalindrome2(String s) {

		if (s == null || s.length() == 0) {
			return true;
		}

		StringBuffer sgoods = new StringBuffer();
		for (int i = 0; i < s.length(); ++i) {
			char temp = s.charAt(i);
			if (Character.isLetterOrDigit(temp)) {
				sgoods.append(Character.toLowerCase(temp));
			}
		}

		int left = 0;
		int right = sgoods.length() - 1;

		while (left < right) {
			if (sgoods.charAt(left) != sgoods.charAt(right)) {
				return false;
			}

			left++;
			right--;
		}

		return true;
	}

	// 3 双指针
	// 时间复杂度O(n)
	// 空间复杂度O(1)
	public boolean isPalindrome3(String s) {

		if (s == null || s.length() == 0) {
			return true;
		}

		int left = 0;
		int right = s.length() - 1;

		while (left < right) {
			while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
				left++;
			}

			while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
				right--;
			}

			if (left < right) {
				if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
					return false;
				}
			}

			left++;
			right--;
		}

		return true;
	}

// ====================测试代码=======================
	public void test() {
		String s = "A man, a plan, a canal: Panama";
		boolean result = isPalindrome3(s);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
