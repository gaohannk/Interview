package google;

import java.util.HashSet;

import amazon.ListNode;

public class RemoveDuplicate {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode dummy = new ListNode(0);
		ListNode p = head;
		dummy.next = head;
		HashSet<Integer> set = new HashSet<Integer>();
		ListNode prev = dummy;
		while (p != null) {
			if (set.contains(p.val)) {
				prev.next = p.next;
				p = p.next;
			} else {
				set.add(p.val);
				prev = p;
				p = p.next;
			}
		}
		return dummy.next;
	}
}
