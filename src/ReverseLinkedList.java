
public class ReverseLinkedList {
	public static void reorderList(ListNode head) {
        if(head==null || head.next==null) return;
        
        ListNode fast=head;
        ListNode slow=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        
        ListNode preMid = slow;
        ListNode preCur = slow.next;
        while(preCur.next!=null){
            ListNode current = preCur.next;
            preCur.next=current.next;
            current.next = preMid.next;
            preMid.next=current;
        }
    }
	public static void main(String[] args){
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(4);
		ListNode e = new ListNode(5);
		ListNode f = new ListNode(6);
		a.next=b;
		b.next=c;
		c.next=d;
		d.next=e;
		e.next=f;
		reorderList(a);
		ListNode temp=a;
		while(temp!=null){
			System.out.println(temp.val);
			temp=temp.next;
		}
	}
	
}
