package amazon;

public class IsPalindromeinReverseLinkedLIst {

	public boolean isPalindromeinReverseLinkedLIst(ListNode head) {
		if (head == null || head.next == null)
			return true;
		String str = "";
		ListNode p = head;
		while (p != null) {
			str += p.val;
			p = p.next;
		}
		ListNode newHead = reverseList(head);
		int index = 0;
		while (newHead != null) {
			if (newHead.val != str.charAt(index))
				return false;
			index++;
		}
		return true;
	}

	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode reverseHead = reverseList(head.next);
		head.next.next = head;
		head.next = null;
		return reverseHead;
	}

}
