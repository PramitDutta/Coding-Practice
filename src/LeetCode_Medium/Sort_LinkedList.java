package LeetCode_Medium;

public class Sort_LinkedList {
	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null)
			return head;

		// cut the list into two halves
		ListNode prev = null, slow = head, fast = head;
		while (fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		prev.next = null;

		// sort each half;
		ListNode l1 = sortList(head);
		ListNode l2 = sortList(slow);

		return merge(l1, l2);
	}

	public ListNode merge(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				tail.next = l1;
				l1 = l1.next;
			} else {
				tail.next = l2;
				l2 = l2.next;
			}
			tail = tail.next;
		}
		if (l1 != null) {
			tail.next = l1;
		}
		if (l2 != null) {
			tail.next = l2;
		}
		return dummy.next;
	}
}
