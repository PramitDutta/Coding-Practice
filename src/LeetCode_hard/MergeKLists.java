package LeetCode_hard;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKLists {
	class ListNode {
		int value;
		ListNode next;

		public ListNode(int value) {
			this.value = value;
			this.next = null;
		}
	}

	public ListNode mergeK(ListNode[] lists) {
		if (lists == null || lists.length == 0)
			return null;
		PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
			@Override
			public int compare(ListNode o1, ListNode o2) {
				if (o1.value < o2.value)
					return -1;
				else if (o1.value > o2.value)
					return 1;
				else
					return 0;
			}
		});

		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;

		for (ListNode node : lists) {
			if (node != null) {
				pq.add(node);
			}
		}

		while (!pq.isEmpty()) {
			tail.next = pq.poll();
			tail = tail.next;
			if (tail.next != null) {
				pq.add(tail.next);
			}
		}
		return dummy.next;
	}
}
