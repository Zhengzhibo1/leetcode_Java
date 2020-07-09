public class Solution {

// ====================算法实现==================
    public int reverse(int x) {

    	long result = 0;
    	while(x != 0) {
    		result = result * 10 + x % 10;
    		x /= 10;
    	}
    	
    	// 判断是否溢出int类型的取值范围
    	if(result > 0x7FFFFFFF || result < 0x80000000) {
    		return 0;
    	}
    	
    	return (int) result;
    }
    
// =====================测试代码=================
	public static void main(String[] args) {
		Solution s = new Solution();
		int result = s.reverse(-123);
		System.out.println(result);
	}

}
