package source;

import entity.DoubleLinkedList;
import tools.DoubleLinkedListHandler;
import tools.LinkedList;

import java.util.HashMap;

/**
 * Created by Intellij IEDA.
 * DATE : 2014/7/23
 * TIME : 17:30
 * AUTHOR : Allen.Xue
 * E-MAIL : xuezy90@gmail.com
 */
public class LRUCache {
    private HashMap<Integer,DoubleLinkedList> cacheMap = new HashMap<Integer, DoubleLinkedList>();
    private DoubleLinkedListHandler dll;
    private int cacheSize;
    public LRUCache(int capacity) {
        this.cacheSize = capacity;
        dll = new DoubleLinkedListHandler(0,0);
    }

    public int get(int key) {
//        System.out.println(cacheMap.containsKey(key));
        if(cacheMap == null || !cacheMap.containsKey(key)) return -1;
        else
        {
            DoubleLinkedList temp = cacheMap.get(key);
            dll.shirftToFirst(temp);
            return temp.val;
        }
    }

    public void set(int key, int value) {
        DoubleLinkedList temp = cacheMap.get(key);
        if(temp != null)
        {
            dll.shirftToFirst(temp);
            temp.val = value;
        }
        else {
            if(cacheMap.size() == this.cacheSize) cacheMap.remove(dll.removeLast().key);
            temp = new DoubleLinkedList(key,value);
            dll.insertNew(temp);
        }
        cacheMap.put(key,temp);
    }

    public static void main(String[] args) {
        LRUCache lc = new LRUCache(3);
        LinkedList.printList("head : ",lc.dll.head);
        lc.set(1,101);
        LinkedList.printList("head : ",lc.dll.head);
        lc.set(2,202);
        LinkedList.printList("head : ",lc.dll.head);
        lc.set(3,303);
        LinkedList.printList("head : ",lc.dll.head);
        lc.set(4,404);
        LinkedList.printList("head : ",lc.dll.head);
        System.out.println(lc.get(3));
        LinkedList.printList("head : ",lc.dll.head);
        System.out.println(lc.get(5));
        LinkedList.printList("head : ",lc.dll.head);
        lc.set(4,4040);
        LinkedList.printList("head : ",lc.dll.head);

    }
}
