package Amazon;

public class LinkedList_Sort {
	public static ListNode sort(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode zeroD = new ListNode(0);
		ListNode oneD = new ListNode(0);
		ListNode twoD = new ListNode(0);

		ListNode zero = zeroD, one = oneD, two = twoD;
		ListNode curr = head;
		while (curr != null) {
			if (curr.val == 0) {
				zero.next = curr;
				zero = zero.next;
				curr = curr.next;
			} else if (curr.val == 1) {
				one.next = curr;
				one = one.next;
				curr = curr.next;
			} else {
				two.next = curr;
				two = two.next;
				curr = curr.next;
			}
		}
		zero.next = oneD.next != null ? oneD.next : twoD.next;
		one.next = twoD.next;
		two.next = null;

		head = zeroD.next;
		return head;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(0);
		head.next.next.next = new ListNode(1);
		head.next.next.next.next = new ListNode(0);
		ListNode result = sort(head);
		while (result != null) {
			System.out.print(result.val + "->");
			result = result.next;
		}
	}
}
