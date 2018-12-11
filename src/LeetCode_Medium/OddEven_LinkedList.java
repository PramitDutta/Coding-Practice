package LeetCode_Medium;

public class OddEven_LinkedList {
	public ListNode oddEven(ListNode head) {
		if (head != null) {
			ListNode odd = head;
			ListNode even = head.next;
			ListNode evenHead = even;

			while (even != null && even.next != null) {
				odd.next = odd.next.next;
				even.next = even.next.next;
				odd = odd.next;
				even = even.next;
			}
			odd.next = evenHead;
		}
		return head;
	}
}
