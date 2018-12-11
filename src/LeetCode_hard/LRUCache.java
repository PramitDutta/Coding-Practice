package LeetCode_hard;

import java.util.HashMap;

public class LRUCache {
	class Node {
		int key;
		int value;
		Node pre;
		Node next;

		public Node(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}

	int capacity;
	HashMap<Integer, Node> map = new HashMap<Integer, Node>();
	Node head = null;
	Node end = null;

	public int get(int key) {
		if (map.containsKey(key)) {
			Node n = map.get(key);
			remove(n);
			setHead(n);
			return n.value;
		}
		return -1;
	}

	public void put(int key, int value) {
		if (map.containsKey(key)) {
			Node old = map.get(key);
			old.value = value;
			remove(old);
			setHead(old);
		} else {
			Node created = new Node(key, value);
			if (map.size() >= capacity) {
				map.remove(end.key);
				remove(end);
				setHead(created);
			} else {
				setHead(created);
			}
			map.put(key, created);
		}
	}

	public void remove(Node node) {
		if (node.pre != null) {
			node.pre.next = node.next;
		} else {
			head = node.next;
		}
		if (node.next != null) {
			node.next.pre = node.pre;
		} else {
			end = node.pre;

		}
	}

	public void setHead(Node node) {
		node.next = head;
		node.pre = null;
		if (head != null) {
			head.pre = node;
		}
		head = node;
		if (end == null) {
			end = head;
		}
	}
}
