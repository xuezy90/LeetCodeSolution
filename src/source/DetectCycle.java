package source;

import entity.ListNode;
import tools.LinkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Intellij IEDA.
 * DATE : 2014/7/30
 * TIME : 8:24
 * AUTHOR : Allen.Xue
 * E-MAIL : xuezy90@gmail.com
 */
public class DetectCycle {


    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;
        ListNode low = head;
        ListNode high = head.next;
        if(low == high) return true;
        while(high.next !=null && high.next.next != null)
        {
            low = low.next;
            high = high.next.next;
            if(low == high ) {
                return true;
            }
        }
        return false;
    }

    public ListNode detectCycle(ListNode head) {

        if(head == null || head.next == null) return null;
        ListNode low = head;
        ListNode high = head.next;
        if(low == high) return head;
        ListNode temp = null;
        while(high.next !=null && high.next.next != null)
        {
            low = low.next;
            high = high.next.next;
            if(low == high ) {
                temp = low;
                break;
            }
        }
        if(high.next == null|| high.next.next == null) return null;
        else
        {
            temp = findEntry(head,temp);
            return temp;
        }
    }

    private ListNode findEntry(ListNode head, ListNode temp) {

        ListNode p1 = head;
        ListNode p2 = temp.next;//not $temp,because high started at head.next
        while(p1 != p2)
        {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
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
        p2.next = p3;
        p3.next = p4;
        p4.next = p5;
//        p5.next = p6;
//        head = null;
        DetectCycle sl = new DetectCycle();
        ListNode tt = sl.detectCycle(head);
        if(tt != null)
        System.out.println("Cycle Start at : "+tt.val);
        System.out.println("No Cycle!");
        LinkedList.printList("result : ", head);
    }
}
