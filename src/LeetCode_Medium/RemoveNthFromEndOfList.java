package LeetCode_Medium;

public class RemoveNthFromEndOfList {
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode fast = head;
		ListNode slow = head;
		while (n > 0) {
			fast = fast.next;
			n--;
		}
		if (fast == null)
			return head.next;
		fast = fast.next;

		while (fast != null) {
			fast = fast.next;
			slow = slow.next;
		}
		slow.next = slow.next.next;
		return head;
	}

	public static void main(String[] args) {
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(4);
		ListNode e = new ListNode(5);
		ListNode f = new ListNode(6);
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		e.next = f;

		ListNode head = removeNthFromEnd(a, 2);
		while (head != null) {
			System.out.print(head.val + "->");
			head = head.next;
		}
	}
}
