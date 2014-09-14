package tools;

import entity.DoubleLinkedList;

/**
 * Created by Intellij IEDA.
 * DATE : 2014/7/23
 * TIME : 22:18
 * AUTHOR : Allen.Xue
 * E-MAIL : xuezy90@gmail.com
 */
public class DoubleLinkedListHandler {
    public DoubleLinkedList head;
    DoubleLinkedList tail;
    public DoubleLinkedListHandler(int k, int v)
    {
        head = new DoubleLinkedList(0,0);
        tail = new DoubleLinkedList(0,0);
        head.next = tail;
        tail.pref = head;
    }
    public void insertNew(DoubleLinkedList dll)
    {
        if(dll != null)
        {
            dll.next = head.next;
            dll.pref = head.next.pref;
            head.next.pref = dll;
            head.next = dll;
        }
    }

    public DoubleLinkedList removeLast()
    {
        DoubleLinkedList p = this.tail.pref;
        p.pref.next = tail;
        tail.pref = p.pref;
        return p;
    }

    public void shirftToFirst(DoubleLinkedList dll)
    {
        dll.pref.next = dll.next;
        dll.next.pref = dll.pref;
        dll.next = head.next;
        dll.pref = head;
        head.next = dll;
        dll.next.pref = dll;
    }
}
