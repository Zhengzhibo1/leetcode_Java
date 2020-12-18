import java.util.ArrayList;
import java.util.List;

public class Solution {

// ===================算法实现=====================
    // 方法 递归
	// 时间复杂度O(n 个元素中选择 k个，枚举)
	// 空间复杂度O(n)
	public List<List<Integer>> result;
	public List<Integer> ans;
	public List<List<Integer>> combine(int n, int k) {
    	result = new ArrayList<List<Integer>>();
    	ans = new ArrayList<Integer>();
		dfs(1, n, k);
    	return result;
    }
	
	private void dfs(int cur, int n, int k) {
		// 如果当前结果长度加上剩余长度仍小于k，则剪枝
		if(ans.size() + (n - cur + 1) < k) {
			return;
		}
		
		// 记录结果
		if(ans.size() == k) {
			result.add(new ArrayList<Integer>(ans));
			return;
		}
		
		// 选择当前位置
		ans.add(cur);
		dfs(cur + 1, n, k);
		ans.remove(ans.size() - 1);
		// 不选择当前位置
		dfs(cur + 1, n, k);
	}
	
// ===================测试代码=====================
	public void test() {
		int n = 4;
		int k = 2;
		List<List<Integer>> result = combine(n, k);
		for(List<Integer> list : result) {
			for(int i : list) {
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
