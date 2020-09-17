public class Solution {

// ===================算法实现==================
	// 1 异或和 与
	// 异或：无进位加法
	// 与：进位
    public int getSum(int a, int b) {

    	int carry = (a & b) << 1;
    	int sum = a ^ b;
    	while(carry != 0) {
    		int temp = (carry & sum) << 1 ;
    		sum = sum ^ carry;
    		carry = temp;
    	}
    	
    	return sum;
    }
// ===================测试代码==================
    public void test() {
    	int a = -3;
    	int b= 2;
    	int sum = getSum(a, b);
    	System.out.println(sum);
    }
	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
