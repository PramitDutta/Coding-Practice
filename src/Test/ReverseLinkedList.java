package Test;

public class ReverseLinkedList {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static ListNode reverseLinkedList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode prev = null, next = null;
		ListNode curr = head;
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
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
		ListNode temp = reverseLinkedList(a);
		while (temp != null) {
			System.out.print(temp.val + "->");
			temp = temp.next;
		}
	}
}
