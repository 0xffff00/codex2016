package hzk.leetcode;

import java.util.*;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class P022 {

	List ans;
	char tmp[];
	int n;

	/**
	 * 
	 * @param x
	 * @param pop
	 * @param l
	 *            count of '(' pushed
	 * @param r
	 *            count of ')' pushed
	 */
	void dfs(int x, boolean pop, int l, int r) {

		if (pop) {
			tmp[x] = ')';
			r++;
		} else {
			tmp[x] = '(';
			l++;
		}
		if (l == n && r == n) {
			ans.add(String.valueOf(tmp, 0, n << 1));
		}
		if (l < n)
			dfs(x + 1, false, l, r);
		if (r < n && l > r)
			dfs(x + 1, true, l, r);
	}

	int fac(int n) {
		int s = 1;
		while (n > 0) {
			s *= n;
			n--;
		}
		return s;
	}

	public List<String> generateParenthesis(int n) {
		this.n = n;
		ans = new ArrayList(fac(n));
		if (n<=0) return ans;
		tmp = new char[n * 2];
		dfs(0, false, 0, 0);
		return ans;

	}

	void prt() {
		for (int i = 0; i < n * 2; i++)
			System.out.print(tmp[i]);
		System.out.println();
	}

	public void test(int n) {
		List ans = generateParenthesis(n);
		System.out.printf("%d: %s\n", n, Arrays.toString(ans.toArray()));

	}

	public static void main(String[] args) {
		P022 p = new P022();
		p.test(0);
		p.test(1);
		p.test(2);
		p.test(3); // "((()))", "(()())", "(())()", "()(())", "()()()"
		p.test(4);
		p.test(5);
		p.test(6);
		// p.test(12);

	}

}
