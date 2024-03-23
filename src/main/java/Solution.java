import java.util.*;

public class Solution {
    public void reorderList(ListNode head) {
        Queue<ListNode> q = new LinkedList<>();
        Deque<ListNode> stack = new ArrayDeque<>();
        ListNode temp = head;

        ListNode fast = head;
        while (fast != null && fast.next != null) {
            q.offer(temp);
            temp = temp.next;
            fast = fast.next.next;
        }
        if (fast != null) {
            q.offer(temp);
            temp = temp.next;
        }
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        boolean flag = true;
        q.poll();
        temp = head;
        while (!stack.isEmpty() || !q.isEmpty()) {
            if (flag) {
                temp.next = stack.pop();
            } else temp.next = q.poll();
            temp = temp.next;
            flag = !flag;
        }
        temp.next = null;
    }
}

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

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val;
    }
}