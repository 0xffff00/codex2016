package hzk.leetcode;

public class P024 {

	public ListNode swapPairs(ListNode head) {

		ListNode pre = new ListNode(0),q, p = head;
		while (p != null) {
			q = p.next;
			if (q == null)
				break;
			if (head == p)
				head = q;
			p.next = q.next;
			q.next = p;
			p = p.next;
			pre.next=q;
			pre=q.next;

		}
		return head;

	}

	public static void main(String[] args) {
		P024 p = new P024();
		ListNode a1 = ListNode.asList(23);
		ListNode b1 = ListNode.asList(3, 8);
		ListNode c1 = ListNode.asList(2, 3, 8);
		ListNode d1 = ListNode.asList(1, 3, 5, 8);
		ListNode e1 = ListNode.asList(2, 4, 6, 7, 10);
		ListNode f1 = ListNode.asList(2, 4, 6, 7, 10, 12, 13, 14);

		System.out.println(p.swapPairs(null));
		System.out.println(p.swapPairs(a1));
		System.out.println(p.swapPairs(b1));
		System.out.println(p.swapPairs(c1));
		System.out.println(p.swapPairs(d1));
		System.out.println(p.swapPairs(e1));
		System.out.println(p.swapPairs(f1));
	}

}