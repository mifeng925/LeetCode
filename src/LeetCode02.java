public class LeetCode02 {

    public static void main(String[] args) {
        ListNode node = new ListNode(1, new ListNode(4, new ListNode(9)));
        ListNode node2 = new ListNode(5, new ListNode(4, new ListNode(6)));
        addTwoNumbers(node, node2);

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, link = null;
        int carrry = 0;
        while (l1 != null || l2 != null) {
            int d1 = l1 != null ? l1.val : 0;
            int d2 = l2 != null ? l2.val : 0;
            int sum = d1 + d2 + carrry;
            if (head == null) {
                head = new ListNode(sum % 10);
                link = head;
            } else {
                link.next = new ListNode(sum % 10);
                link = link.next;
            }
            carrry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carrry > 0) {
            link.next = new ListNode(carrry);
        }
        return head;
    }

    public static class ListNode {
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

}
