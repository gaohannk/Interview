package google;

import java.util.LinkedList;

import amazon.ListNode;

public class ListNodeDeepCopy {

	public static ListNode getListNodeDeepCopy(ListNode head) {
		ListNode p = head;
		ListNode dummy = new ListNode(0);
		ListNode q = dummy;
		while (p != null) {
			q.next = new ListNode(p.val);
			p = p.next;
			q = q.next;
		}
		return dummy.next;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(5);
		head.next.next = new ListNode(6);
		head.next.next.next = new ListNode(3);
		print(head);
		print(getListNodeDeepCopy(head));
	}

	private static void print(ListNode head) {
		while (head != null) {
			System.out.print(head.val);
			head = head.next;
		}
		System.out.println();
	}
}
