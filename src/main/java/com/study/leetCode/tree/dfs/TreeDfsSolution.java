package com.study.leetCode.tree.dfs;

import com.study.leetCode.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhangchong
 * @CodeReviewer zhangqingan
 * @Description
 */
public class TreeDfsSolution {

    /**
     * 深度遍历
     * 使用集合
     * 如果使用迭代的方式，就要使用stack，后入先出
     *
     * @param root
     * @return
     */
    public List<Integer> dfsTraversal(TreeNode root) {
        LinkedList<TreeNode> visited = new LinkedList<>();
        return DFSRecursiveHelper.dfs(root, visited);
    }

    static class DFSRecursiveHelper {
        private static List<Integer> dfs(TreeNode node, LinkedList<TreeNode> visited) {
            List<Integer> result = new ArrayList<>();

            visited.add(node);

            //process current node here

            for (TreeNode nextNode : node.children()) {
                if (!visited.contains(nextNode)) {
                    result.addAll(dfs(nextNode, visited));
                }
            }
            return result;
        }
    }
}
