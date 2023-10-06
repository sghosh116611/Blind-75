package DataStructures;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Reverse_LinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode temp = head;
        ListNode current = head;
        ListNode prev = null;

        while (current != null) {
            temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }

        head = prev;
        return head;
    }
}

// Note
// 1. Maintain 3 pointers - temp, current and prev and updat them accordingly O(n) + O(1)
