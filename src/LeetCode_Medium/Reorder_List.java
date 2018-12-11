package LeetCode_Medium;

public class Reorder_List {
	public ListNode rotateRight(ListNode head, int n) {
		if (head == null || head.next == null)
			return head;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode fast = dummy, slow = dummy;
		int i;
		for (i = 0; fast.next != null; i++) {// get the total length;
			fast = fast.next;
		}
		for (int j = i - n % i; j > 0; j--) { // get the i-n%ith node
			slow = slow.next;
		}
		fast.next = dummy.next; // do the rotation
		dummy.next = slow.next;
		slow.next = null;

		return dummy.next;
	}
}
