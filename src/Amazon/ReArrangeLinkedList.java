package Amazon;

public class ReArrangeLinkedList {
	public static ListNode rearrange(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		slow = slow.next;

		slow = reverse(slow);
		fast = head;
		ListNode cur = new ListNode(0);
		while (fast != null || slow != null) {
			if (fast != null) {
				cur.next = fast;
				cur = cur.next;
				fast = fast.next;
			}
			if (slow != null) {
				cur.next = slow;
				cur = cur.next;
				slow = slow.next;
			}
		}
		return cur.next;

	}

	private static ListNode reverse(ListNode head) {
		ListNode prev = null;
		ListNode cur = head;
		ListNode next = null;
		while (cur != null) {
			next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		return prev;
	}

	public static void main(String[] args) {
		ListNode a = new ListNode(1);
		a.next = new ListNode(2);
		a.next.next = new ListNode(3);
		a.next.next.next = new ListNode(4);
		ListNode cur = rearrange(a);
		while (cur != null) {
			System.out.print(cur.val + " ");
			cur = cur.next;
		}
	}
}
