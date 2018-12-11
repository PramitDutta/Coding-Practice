package LeetCode_Medium;

public class Partition_List {
	public ListNode partition(ListNode head, int val) {
		ListNode node1 = new ListNode(0);
		ListNode node2 = new ListNode(0);

		ListNode cur1 = node1, cur2 = node2;

		while (head != null) {
			if (head.val < val) {
				cur1.next = head;
				cur1 = head;
			} else {
				cur2.next = head;
				cur2 = head;
			}
			head = head.next;
		}
		cur2.next = null;
		cur1.next = node2.next;

		return node1.next;
	}
}
