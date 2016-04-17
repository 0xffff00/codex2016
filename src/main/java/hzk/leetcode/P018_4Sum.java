package hzk.leetcode;

import java.util.*;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class P018_4Sum {
	List ans = new ArrayList(100);

	public List quadruplet(int a, int b, int c, int d) {
		List quad = new ArrayList(4);
		quad.add(a);
		quad.add(b);
		quad.add(c);
		quad.add(d);
		return quad;
	}

	public List<List<Integer>> fourSum(int[] nums, int target) {
		int i, j, k, lo, hi, a, b, c, d, a_, b_, c_, d_, w, n = nums.length;
		ans.clear();
		if (n < 4)
			return ans;
		Arrays.sort(nums);
		a_ = b_ = c_ = d_ = nums[0] - 1;
		for (i = 0; i < n - 3; i++) {
			a = nums[i];
			if (i > 0 && a == nums[i - 1])
				continue;

			for (j = i + 1; j < n - 2; j++) {
				b = nums[j];
				if (j > i + 1 && b == nums[j - 1])
					continue;
				lo = j + 1;
				hi = n - 1;
				while (lo < hi) {
					c = nums[lo];
					d = nums[hi];
					w = a + b + c + d - target;
					if (w == 0) {
						if (!(b_ == b && c_ == c && d_ == d)) {
							ans.add(quadruplet(a, b, c, d));
							b_ = b;
							c_ = c;
							d_ = d;
						}
						lo++;
						hi--;
					} else if (w < 0) {
						lo++;
					} else {
						hi--;
					}
				}
			}
		}
		return ans;
	}

	public void test(int tar, int... args) {
		List<List<Integer>> ans = fourSum(args, tar);
		for (List an : ans) {
			System.out.printf("%s,", Arrays.toString(an.toArray()));
		}
		System.out.println("...");
	}

	public static void main(String[] args) {
		P018_4Sum p = new P018_4Sum();
		p.test(0);
		p.test(0, 1, 0, -1, 0, -2, 2);
		p.test(0, -5, -4, -3, -2, -1, 0, 0, 1, 2, 3, 4, 5);
		p.test(0, 0, 0, 0, 0);
		p.test(10, 1, 2, 3, 4);
		p.test(10, 1, 2, 2, 3, 4);
		p.test(10, 1, 2, 3, 4, 5);
		p.test(10, 0, 0, 0, 1, 2, 3, 4, 10);
		p.test(0, 1, 0, -1, 0, -2, 2);
		p.test(5, 1, 2, 3, 4, 2, 3, 6, 65, -63, -33, -32, -1, -2, -3, -5, 12, -6, 22);

	}

}
