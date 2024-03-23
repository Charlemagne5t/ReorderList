import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test1(){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        ListNode expected = new ListNode(1);
        expected.next = new ListNode(4);
        expected.next.next = new ListNode(2);
        expected.next.next.next = new ListNode(3);
        new Solution().reorderList(head);
        Assert.assertTrue(compare(head, expected));
    }
    @Test
    public void test2(){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode expected = new ListNode(1);
        expected.next = new ListNode(5);
        expected.next.next = new ListNode(2);
        expected.next.next.next = new ListNode(4);
        expected.next.next.next.next = new ListNode(3);
        new Solution().reorderList(head);
        Assert.assertTrue(compare(head, expected));
    }

    boolean compare(ListNode head1, ListNode head2){
        while (head1 != null || head2 != null){
            if(head1.val != head2.val){
                return false;
            }
            head1 = head1.next;
            head2 = head2.next;
        }

        return true;
    }
}
