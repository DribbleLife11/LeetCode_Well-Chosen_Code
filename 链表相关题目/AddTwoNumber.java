/**
* 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
* 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
*
* （可以假设除了数字 0 之外，这两个数都不会以 0 开头。）
*/

public class AddTwoNumber {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //1、新建一个哑结点/哨兵
        ListNode dummyHead = new ListNode(0);
        //2、定义两个指针p、q，分别指向两个l1、l2
        ListNode p = l1, q = l2, curr = dummyHead;
        //进位
        int carry = 0;
        //3、遍历两个链表，相加各个结点
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        //最后如果carry等于1，则在后面补一个值为1的结点
        if (carry == 1) {
            curr.next = new ListNode(1);
        }

        return dummyHead.next;
    }
}
