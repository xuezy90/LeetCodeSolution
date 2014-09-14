package source;

import entity.UndirectedGraphNode;
import tools.SerializeGraph;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Intellij IEDA.
 * DATE : 2014/8/1
 * TIME : 12:00
 * AUTHOR : Allen.Xue
 * E-MAIL : xuezy90@gmail.com
 */
public class CloneGraph {
    Map<UndirectedGraphNode,UndirectedGraphNode> set = new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return null;
        UndirectedGraphNode ugn = new UndirectedGraphNode(node.label);
        if(set.keySet().contains(node)) return set.get(node);
        else set.put(node,ugn);
        if(node.neighbors == null || node.neighbors.size() == 0) return ugn;
        else
        {
           for(UndirectedGraphNode s:node.neighbors)
           {
               ugn.neighbors.add(cloneGraph(s));
           }
        }
        return ugn;
    }

    public static void main(String[] args) {
        UndirectedGraphNode ugn0 = new UndirectedGraphNode(0);
        UndirectedGraphNode ug1 = new UndirectedGraphNode(1);
        UndirectedGraphNode ug2 = new UndirectedGraphNode(2);
        ugn0.neighbors.add(ug1);
        ugn0.neighbors.add(ug2);
        ug1.neighbors.add(ug2);
        ug2.neighbors.add(ug2);
        CloneGraph cg = new CloneGraph();
        UndirectedGraphNode temp = cg.cloneGraph(ugn0);
        SerializeGraph.serilize(ugn0);
        System.out.println("\r\n===========================");
        SerializeGraph.set.clear();
        SerializeGraph.serilize(temp);
    }
}
