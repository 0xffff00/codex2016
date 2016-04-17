package hzk.leetcode;

public class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}

	static ListNode asList(int... vals) {
		if (vals == null)
			return null;
		ListNode head = null, pre = null, p;
		for (int v : vals) {
			p = new ListNode(v);
			if (head == null)
				head = p;
			if (pre != null)
				pre = pre.next = p;
			else
				pre = head;
		}
		return head;
	}

	public boolean isCircled(){
		
		ListNode p = this.next;
		while (p != null) {
			if (p==this) return true;
			p=p.next;
		}
		return false;
	}
	public String toString() {
		ListNode p = this;
		boolean notFirst=false;
		StringBuffer sb = new StringBuffer();
		while (p != null) {
			if (notFirst && p==this){
				sb.append("->(head)");
				break;
			}
			sb.append(p.val).append("->");
			
			notFirst=true;
			p = p.next;
		}
		if (p==null) sb.append("$");
		return sb.toString();
	}
}
