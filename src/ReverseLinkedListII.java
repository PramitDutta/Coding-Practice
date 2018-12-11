
public class ReverseLinkedListII {
	public static ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode cur1 = dummy;
		ListNode pre1 = null;
		for (int i = 0; i < m; i++) {
			pre1 = cur1;
			cur1 = cur1.next;
		}
		ListNode pre2 = pre1;
		ListNode cur2 = cur1;
		ListNode q2;
		for (int i = m; i <= n; i++) {
			q2 = cur2.next;
			cur2.next = pre2;
			pre2 = cur2;
			cur2 = q2;
		}

		pre1.next = pre2;
		cur1.next = cur2;

		return dummy.next;
	}

	public static void main(String[] args) {
		ListNode a = new ListNode(1);
		a.next = new ListNode(2);
		a.next.next = new ListNode(3);
		a.next.next.next = new ListNode(4);
		a.next.next.next.next = new ListNode(5);
		a.next.next.next.next.next = null;
		ListNode head = reverseBetween(a, 2, 4);
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
	}
}
