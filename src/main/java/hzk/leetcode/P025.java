package hzk.leetcode;

public class P025 {
	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null)
			return null;
		if (k<2) return head;
		int x;
		ListNode tmp, pre = null, newPre, p, q, newHead = null;
		int len=0;
		p=head;
		while (p!=null){
			p=p.next;
			len++;
		}
		int ts=len/k;
		if (ts==0) return head;
		newPre = head;
		while (ts-->0) { // pre,newPre is set
			if (newPre == null)
				break;
			x = k-1;
			p = newPre;
			q = p.next;
			while (x-- > 0) {
				if (q == null)
					break;
				tmp = q.next;
				q.next = p;

				p = q;
				q = tmp;
			}

			if (pre != null)
				pre.next = p;
			pre = newPre;
			pre.next = null;
			newPre = q;
			if (newHead == null)
				newHead = p;

		}
		if (pre != null) pre.next=newPre;
		return newHead;

	}

	public static void main(String[] args) {
		P025 p = new P025();
		ListNode a1 = ListNode.asList(23);
		ListNode b1 = ListNode.asList(3, 8);
		ListNode c1 = ListNode.asList(2, 3, 8);
		ListNode d1 = ListNode.asList(1, 3, 5, 8);
		ListNode e1 = ListNode.asList(2, 4, 6, 7, 10);
		ListNode f0 = ListNode.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17);
		ListNode f1 = ListNode.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17);
		ListNode f2 = ListNode.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17);
		ListNode f3 = ListNode.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17);
		ListNode f4 = ListNode.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17);
		ListNode f5 = ListNode.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17);
		// System.out.println(p.reverseKGroup(null,2));
		 System.out.println(p.reverseKGroup(a1,2));
		 System.out.println(p.reverseKGroup(b1,2));
		System.out.println(p.reverseKGroup(c1, 2));
		System.out.println(p.reverseKGroup(d1, 3));
		System.out.println(p.reverseKGroup(e1, 3));
		System.out.println(p.reverseKGroup(f0, 0));
		System.out.println(p.reverseKGroup(f1, 1));
		System.out.println(p.reverseKGroup(f2, 2));
		System.out.println(p.reverseKGroup(f3, 3));
		System.out.println(p.reverseKGroup(f4, 4));
		System.out.println(p.reverseKGroup(f5, 5));
	}

}