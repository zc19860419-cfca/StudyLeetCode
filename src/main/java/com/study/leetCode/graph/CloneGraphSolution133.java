package com.study.leetCode.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author zhangchong
 * @CodeReviewer qazhang
 * @Description CloneGraphSolution133
 * 133. 克隆图
 * 给你无向 连通 图中一个节点的引用，请你返回该图的 深拷贝（克隆）。
 * <p>
 * 图中的每个节点都包含它的值 val（int） 和其邻居的列表（list[Node]）。
 * <p>
 * class Node {
 * public int val;
 * public List<Node> neighbors;
 * }
 * <p>
 * <p>
 * 测试用例格式：
 * <p>
 * 简单起见，每个节点的值都和它的索引相同。例如，第一个节点值为 1（val = 1），第二个节点值为 2（val = 2），以此类推。该图在测试用例中使用邻接列表表示。
 * <p>
 * 邻接列表 是用于表示有限图的无序列表的集合。每个列表都描述了图中节点的邻居集。
 * <p>
 * 给定节点将始终是图中的第一个节点（值为 1）。你必须将 给定节点的拷贝 作为对克隆图的引用返回。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：adjList = [[2,4],[1,3],[2,4],[1,3]]
 * 输出：[[2,4],[1,3],[2,4],[1,3]]
 * 解释：
 * 图中有 4 个节点。
 * 节点 1 的值是 1，它有两个邻居：节点 2 和 4 。
 * 节点 2 的值是 2，它有两个邻居：节点 1 和 3 。
 * 节点 3 的值是 3，它有两个邻居：节点 2 和 4 。
 * 节点 4 的值是 4，它有两个邻居：节点 1 和 3 。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：adjList = [[]]
 * 输出：[[]]
 * 解释：输入包含一个空列表。该图仅仅只有一个值为 1 的节点，它没有任何邻居。
 * 示例 3：
 * <p>
 * 输入：adjList = []
 * 输出：[]
 * 解释：这个图是空的，它不含任何节点。
 * 示例 4：
 * <p>
 * <p>
 * <p>
 * 输入：adjList = [[2],[1]]
 * 输出：[[2],[1]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 节点数不超过 100 。
 * 每个节点值 Node.val 都是唯一的，1 <= Node.val <= 100。
 * 无向图是一个简单图，这意味着图中没有重复的边，也没有自环。
 * 由于图是无向的，如果节点 p 是节点 q 的邻居，那么节点 q 也必须是节点 p 的邻居。
 * 图是连通图，你可以从给定节点访问到所有节点。
 */
public class CloneGraphSolution133 {

    private LinkedList<Node> queue = new LinkedList<Node>();
    private Map<Integer, Node> visited = new HashMap<>();
    private Map<Integer, Node> builded = new HashMap<>();


    /**
     * 深度优先搜索:进行「图的遍历」，并在遍历的过程中完成图的深拷贝
     * 使用一个哈希表存储所有已被访问和克隆的节点。
     *
     * @param node
     * @return
     */
    public Node cloneGraph(Node node) {
        final CloneGraphDFSHelper dfsHelper = new CloneGraphDFSHelper();
        return dfsHelper.cloneGraph(node);
    }

    static class CloneGraphDFSHelper {
        private Map<Node, Node> visited = new HashMap<>();

        public Node cloneGraph(Node node) {
            //递归终止条件：条件一 遍历完所有节点
            if (node == null) {
                return node;
            }

            //递归终止条件：条件二 如果该节点已经访问过，则直接返回克隆点
            if (visited.containsKey(node)) {
                return visited.get(node);
            }

            //克隆节点，注意到为了深拷贝我们不会克隆它的邻居的列表
            final Node cloneNode = new Node(node.val, new ArrayList<>());
            visited.put(node, cloneNode);

            //遍历该节点的邻居节点并更新克隆节点的邻居节点
            for (Node neighbor : node.neighbors) {
                cloneNode.neighbors.add(cloneGraph(neighbor));
            }

            return cloneNode;

        }
    }


    private void debugScan(Node node) {
        System.out.println("debugScan running...");
        queue.add(node);
        while (!queue.isEmpty()) {
            // 取出队列的头节点
            Node n = queue.remove();
            final StringBuffer buffer = new StringBuffer();
            buffer.append(n.val).append("=>[");
            // 遍历该节点的邻居
            for (int i = 0; i < n.neighbors.size(); i++) {
                Node neighbor = n.neighbors.get(i);
                if (i > 0) {
                    buffer.append(',');
                }
                buffer.append(neighbor.val);
                if (!visited.containsKey(neighbor.val)) {
                    visited.put(neighbor.val, neighbor);
                    queue.add(neighbor);
                    System.out.println("queue.add:"+neighbor.val);
                }
            }
            buffer.append("]\n");
            System.out.print(buffer.toString());
        }
        System.out.println("debugScan finished");
    }

    public Node buildGraph(List<List<Integer>> adjList) {

        debugAdjList(adjList);
        final Node header = new Node(1);
        builded.put(1, header);
        int val;
        Node node;
        List<Integer> adjNodes;
        for (int i = 0; i < adjList.size(); i++) {
            val = i + 1;
            node = requireNode(val);
            adjNodes = adjList.get(i);
            for (int j = 0; j < adjNodes.size(); j++) {
                val = adjNodes.get(j).intValue();
                node.neighbors.add(requireNode(val));
            }
        }
        debugScan(header);
        return header;
    }

    private void debugAdjList(List<List<Integer>> adjList) {
        System.out.println("debugAdjList running...");
        for (int i = 0; i < adjList.size(); i++) {
            int val = i + 1;
            System.out.print(val + "=>[");
            final List<Integer> nodes = adjList.get(i);
            for (int j = 0; j < nodes.size(); j++) {
                if (j > 0) {
                    System.out.print(",");
                }
                final Integer node = nodes.get(j);
                System.out.print(node.intValue());
            }
            System.out.println("]");
        }
        System.out.println("debugAdjList finished");
    }

    private Node requireNode(int val) {
        final Node node;
        if (!builded.containsKey(val)) {
            node = new Node(val);
            builded.put(val, node);
        } else {
            node = builded.get(val);
        }
        return node;
    }
}
