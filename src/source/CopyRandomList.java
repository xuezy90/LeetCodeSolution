package source;

import entity.RandomListNode;
import tools.LinkedList;

/**
 * Created by Intellij IEDA.
 * DATE : 2014/7/30
 * TIME : 19:14
 * AUTHOR : Allen.Xue
 * E-MAIL : xuezy90@gmail.com
 */
public class CopyRandomList {
    //must recovery old list
    public RandomListNode copyRandomList(RandomListNode head) {
//        LinkedList.printList("Source List1 : ",head);
        if(head == null ) return null;
        RandomListNode rln;
        RandomListNode p = head;
//        LinkedList.printList("Source List : ",head);
        while(p.next != null)
        {
            rln = new RandomListNode(p.label);
            rln.next = p.next;
            p.next = rln;
            p = p.next.next;
        }
        rln = new RandomListNode(p.label);
        p.next = rln;
        p = head;
//        LinkedList.printList("After Copy1  : ",head);
        RandomListNode newH = head.next;
//        LinkedList.printList("Insert New List : ",head);
        while(p != null)
        {
           if(p.random != null)
           p.next.random = p.random.next;
           p = p.next.next;
        }
//        LinkedList.printList("Source List1 : ",head);
        p = newH;
        RandomListNode pp = head;
        while(p.next != null)
        {
            pp.next = p.next;
            pp = pp.next;
            p.next = pp.next;
            p = p.next;
        }
        pp.next = null;
//        LinkedList.printList("After recover  : ",newH);
//        LinkedList.printList("After recover  : ",newH);
        return newH;
    }

    public static void main(String[] args) {
        RandomListNode head = new RandomListNode(3);
        RandomListNode p1 = new RandomListNode(2);//1
        RandomListNode p2 = new RandomListNode(1);//3
        RandomListNode p3 = new RandomListNode(2);
        RandomListNode p4 = new RandomListNode(7);
        RandomListNode p5 = new RandomListNode(5);
        RandomListNode p6 = new RandomListNode(6);
        head.next = p1;
        p1.next = p2;
        p2.next = p3;
        p3.next = p4;
        p4.next = p5;
        p5.next = p6;

        p3.random = p5;
        p4.random = p1;
        p6.random = p3;

//        head = null;
        CopyRandomList sl = new CopyRandomList();
        RandomListNode tt = sl.copyRandomList(head);
//        if(tt != null)
//            System.out.println("Cycle Start at : "+tt.label);
//        System.out.println("No Cycle!");
        LinkedList.printList("result : ", tt);
    }
}
