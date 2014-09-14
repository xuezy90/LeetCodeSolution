package source;

import entity.ListNode;
import tools.LinkedList;

/**
 * Created by Intellij IEDA.
 * DATE : 2014/7/22
 * TIME : 22:51
 * AUTHOR : Allen.Xue
 * E-MAIL : xuezy90@gmail.com
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode realHead = new ListNode(0);
        realHead.next = head;
        LinkedList.printList("ReadyForSort : ",realHead.next);
        ListNode p1 = head;
        ListNode p2;
        ListNode temp;
        while(p1.next != null)
        {
            p2 = p1.next;
            if(p1.val > p2.val)
            {
                p1.next = p2.next;
                temp = realHead;
                while(temp.next != null)
                {
                    if(temp.next.val > p2.val)
                    {
                        p2.next = temp.next;
                        temp.next = p2;
                        break;
                    }
                    else temp = temp.next;
                }
                LinkedList.printList(p2.val+" : ",realHead.next);
            }
            else p1 = p1.next;
        }
        return realHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode p1 = new ListNode(2);//1
        ListNode p2 = new ListNode(1);//3
        ListNode p3 = new ListNode(2);
        ListNode p4 = new ListNode(7);
        ListNode p5 = new ListNode(5);
        ListNode p6 = new ListNode(6);
        head.next = p1;
        p1.next = p2;
//        p2.next = p3;
//        p3.next = p4;
//        p4.next = p5;
//        p5.next = p6;
        InsertionSortList sl = new InsertionSortList();
        head = sl.insertionSortList(head);
        LinkedList.printList("result : ", head);
    }
}
