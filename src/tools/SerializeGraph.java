package tools;

import entity.UndirectedGraphNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Intellij IEDA.
 * DATE : 2014/8/1
 * TIME : 12:23
 * AUTHOR : Allen.Xue
 * E-MAIL : xuezy90@gmail.com
 */
public class SerializeGraph {
    public static Set<UndirectedGraphNode> set = new HashSet<UndirectedGraphNode>();
    public static void serilize(UndirectedGraphNode x)
    {
        if(x == null) return;
        set.add(x);
        System.out.print(x.label);
        if(x.neighbors == null ||x.neighbors.size() == 0) {System.out.print("#");return;}
        else
        {
            for(UndirectedGraphNode s:x.neighbors) System.out.print(","+s.label);
            System.out.print("#");
        }
        for(UndirectedGraphNode ss:x.neighbors) if(!set.contains(ss)) serilize(ss);
    }

    public static void main(String[] args) {
        UndirectedGraphNode ugn0 = new UndirectedGraphNode(0);
        UndirectedGraphNode ug1 = new UndirectedGraphNode(1);
        UndirectedGraphNode ug2 = new UndirectedGraphNode(2);
        ugn0.neighbors.add(ug1);
        ugn0.neighbors.add(ug2);
        ug1.neighbors.add(ug2);
        ug2.neighbors.add(ug2);
        serilize(ugn0);
    }
}
