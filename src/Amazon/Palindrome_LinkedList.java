package Amazon;

public class Palindrome_LinkedList {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int val) {
			this.val = val;
		}
	}

	public static boolean isPalindrome(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		if (fast != null) {
			slow = slow.next;
		}
		slow = reverseList(slow);
		fast = head;
		while (slow != null) {
			if (slow.val != fast.val)
				return false;
			fast = fast.next;
			slow = slow.next;
		}
		return true;

	}

	public static ListNode reverseList(ListNode head) {
		ListNode pre = null, cur = head, next = null;
		while (cur != null) {
			next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		return pre;
	}

	public static void main(String[] args) {
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(2);
		ListNode e = new ListNode(4);
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		boolean isPal = isPalindrome(a);
		System.out.println(isPal);
	}
}
