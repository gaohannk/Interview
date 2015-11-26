package godaddy;

public class Mergetwosortedlinkedlists {

	class Node {
		int data;
		Node next;
	}

	Node MergeLists(Node headA, Node headB) {
		// This is a "method-only" submission.
		// You only need to complete this method
		if (headA == null && headB == null)
			return null;
		if (headA == null)
			return headB;
		if (headB == null)
			return headA;
		Node newHead = new Node();
		Node p = newHead;
		while (headA != null && headB != null) {
			if (headA.data < headB.data) {
				p.next = headA;
				headA = headA.next;
			} else {
				p.next = headB;
				headB = headB.next;
			}
			p = p.next;
		}
		if (headA == null) {
			p.next = headB;
		} else {
			p.next = headA;
		}
		return newHead.next;
	}
}
