package com.study.leetCode.tree.bfs;

import com.study.leetCode.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhangchong
 * @CodeReviewer zhangqingan
 * @Description
 */
public class TreeBfsSolution {
    /**
     * 广度遍历
     * 使用双端队列
     *
     * @param root
     * @return
     */
    public List<Integer> bfsTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        LinkedList<TreeNode> visited = new LinkedList<>();
        visited.add(root);

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        TreeNode node;
        LinkedList<TreeNode> nodes;
        while (!queue.isEmpty()) {
            node = queue.pop();
            visited.add(node);

            //process current node here
            result.add(node.val);

            nodes = generateRelateNodes(node, visited);
            queue.addAll(nodes);
        }

        return result;
    }

    /**
     * 将指定node的左右孩子节点中未被访问的节点返回
     *
     * @param node    指定节点
     * @param visited 访问过的节点集合
     * @return
     */
    private LinkedList<TreeNode> generateRelateNodes(TreeNode node, LinkedList<TreeNode> visited) {
        LinkedList<TreeNode> relateNodes = new LinkedList<>();
        if (null != node.left && !visited.contains(node.left)) {
            relateNodes.add(node.left);
        }

        if (null != node.right && !visited.contains(node.right)) {
            relateNodes.add(node.right);
        }
        return relateNodes;
    }
}
