package entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Intellij IEDA.
 * DATE : 2014/8/1
 * TIME : 12:01
 * AUTHOR : Allen.Xue
 * E-MAIL : xuezy90@gmail.com
 */
public class UndirectedGraphNode {
    public int label;
    public List<UndirectedGraphNode> neighbors;
    public UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
}
