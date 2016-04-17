package hzk.leetcode;

import java.util.*;

@SuppressWarnings({ "unchecked", "rawtypes" })

public class P023 {
	ListNode tmp = new ListNode(0); // fake head

	ListNode merge2lists(ListNode a, ListNode b) {
		ListNode pre, p;
		pre = tmp;
		tmp.next=null;
		while (a != null && b != null) {
			if (a.val < b.val) {
				p = a;
				a = a.next;
			} else {
				p = b;
				b = b.next;
			}
			pre = pre.next = p;
		}
		if (a != null)
			pre.next = a;
		if (b != null)
			pre.next = b;
		return tmp.next;
	}

	ListNode[] divide(ListNode[] lists) {
		System.out.println(Arrays.toString(lists));// debug
		int i, k = 0;
		ListNode[] ans = new ListNode[(lists.length + 1) / 2];
		for (i = 0; i < lists.length - 1; i += 2) {
			ans[k++] = merge2lists(lists[i], lists[i + 1]);
		}
		if (i == lists.length - 1)
			ans[k++] = lists[i];

		return ans;
	}

	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0)
			return null;
		while (lists.length > 1)
			lists = divide(lists);
		return lists[0];
	}

	void test() {

	}

	public static void main(String[] args) {
		P023 p = new P023();

		int[][] aa = { { 0, 1, 2 }, { -10, -8, -5, -4 }, {}, {}, { -3 }, { -10, -9, -6, -4, -3, -2, -2, -1, 2 }, { -9, -9, -2, -1, 0, 1 },
				{ -9, -4, -3, -2, 2, 2, 3, 3, 4 } };
		ListNode[] q = new ListNode[aa.length];
		for (int i = 0; i < aa.length; i++) {
			q[i] = ListNode.asList(aa[i]);
		}
		System.out.println(p.mergeKLists(q));

		ListNode a1 = ListNode.asList(1, 3, 5, 8, 11, 15);
		ListNode b1 = ListNode.asList(2, 4, 6, 7, 10, 12, 16, 20, 22, 26);
		ListNode c1 = ListNode.asList(23, 24, 25, 111);
		ListNode d1 = ListNode.asList(3, 8, 14, 49, 56, 89);
		System.out.println(a1);
		System.out.println(b1);
		// System.out.println(p.merge2lists(a1, b1));
		System.out.println(p.mergeKLists(new ListNode[] { null, a1, b1, c1, d1 }));
		System.out.println(p.mergeKLists(new ListNode[] { null }));
		System.out.println(p.mergeKLists(new ListNode[] {}));

	}
}
