package com.study.leetCode.topologicalSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Author: zhangchong
 * @Description: 你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。
 * <p>
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]
 * <p>
 * 给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？
 * <p>
 *  
 * <p>
 * 示例 1:
 * 输入: 2, [[1,0]]
 * 输出: true
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
 * 示例 2:
 * <p>
 * 输入: 2, [[1,0],[0,1]]
 * 输出: false
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。
 *  
 * <p>
 * 提示：
 * <p>
 * 输入的先决条件是由 边缘列表表示的图形，而不是邻接矩阵。详情请参见图的表示法。
 * 你可以假定输入的先决条件中没有重复的边。
 * 1 <= numCourses <= 10^5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/course-schedule
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class WordSortSolution {

    /**
     * 当前出现的字母
     */
//    private int[] letterTable;

    /**
     * 依赖关系
     */
    List<List<Item>> edges;
    /**
     * Item 搜索状态
     */
    Status[] visited;
    /**
     * 成环条件
     */
    boolean valid = true;
    StringBuilder builder;
    Map<Character, Integer> charAndIntegerMap = new HashMap<>();
    Map<Integer, Character> charRank = new HashMap<>();

    public Item[][] build(String[] words) {

        int numCourses = 0;
        char[] hit = new char[256];
        int count = 0;
        for (String word : words) {
            final char[] chars = word.toCharArray();
            for (char c : chars) {
                if (hit[c] == 0) {
                    charAndIntegerMap.put(c, count);
                    charRank.put(count, c);
                    count++;
                    hit[c] = 1;
                }
            }

        }

//        final Item w = new Item();
//        w.c = 'w';
//        final Item e = new Item();
//        e.c = 'e';
//        final Item r = new Item();
//        r.c = 'r';
//        final Item t = new Item();
//        t.c = 't';
//        final Item f = new Item();
//        f.c = 'f';
        numCourses = count;
        Item[][] prerequisites = new Item[numCourses][2];
        return prerequisites;
    }

    void initLetterTable(Item[][] prerequisites) {
        for (int i = 0; i < prerequisites.length; i++) {
            for (int j = 0; j < prerequisites[i].length; j++) {
                final char c = prerequisites[i][j].c;
                prerequisites[i][j].id = charAndIntegerMap.get(c);
            }
        }

//        debug(charAndIntegerMap);
//        debugCharRank(charRank);
//        debug(prerequisites);
    }

    private void debug(Item[][] prerequisites) {
        for (int i = 0; i < prerequisites.length; i++) {
            for (int j = 0; j < prerequisites[i].length; j++) {
                System.out.println("[" + i + "][" + j + "]=" + prerequisites[i][j]);
            }
        }
    }

    private void debugCharRank(Map<Integer, Character> charRank) {
        final Set<Integer> characters = charRank.keySet();
        for (Integer character : characters) {
            System.out.println(character + "->" + charRank.get(character));
        }
    }

    private void debug(Map<Character, Integer> charAndIntegerMap) {
        final Set<Character> characters = charAndIntegerMap.keySet();
        for (Character character : characters) {
            System.out.println(character + "->" + charAndIntegerMap.get(character));
        }
    }

    /**
     * @param numCourses
     * @param prerequisites 必备条件
     *                      [
     *                      ]
     * @return
     */
    public String wordSort(int numCourses, Item[][] prerequisites) {
        builder = new StringBuilder();
        edges = new ArrayList<List<Item>>();
        for (int i = 0; i < numCourses; ++i) {
            edges.add(new ArrayList<Item>());
        }
        visited = new Status[numCourses];
        Arrays.fill(visited, Status.Non_Visited);
        for (Item[] info : prerequisites) {
            edges.get(info[1].id).add(info[0]);
//            System.out.println("add edge(" + info[1].c + "->" + info[0].c + ")");
        }
        debug(edges);
        for (int i = 0; i < numCourses && valid; ++i) {
            switch (visited[i]) {
                case Non_Visited:
                    dfs(i);
                    break;
                case Visiting:
                case Visited:
                default:
                    break;
            }
        }
        return builder.toString();
    }

    private void debug(List<List<Item>> edges) {
        for (int u = 0; u < edges.size(); u++) {
            List<Item> edge = edges.get(u);
            for (Item v : edge) {
                System.out.println(charRank.get(u) + "->" + v.c);
            }
        }
    }

    public void dfs(int u) {
        visited[u] = Status.Visiting;
        //u->v
        for (Item v : edges.get(u)) {
            switch (visited[v.id]) {
                case Non_Visited:
                    dfs(v.id);
                    if (!valid) {
                        return;
                    }
                    break;
                case Visiting://表示成环
                    valid = false;
                    return;
                default:
                    break;
            }
        }
        visited[u] = Status.Visited;
        builder.append(charRank.get(u));
    }

    enum Status {
        Non_Visited, Visiting, Visited
    }

    public static class Item {
        char c;
        int id;

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Item{");
            sb.append("c=").append(c);
            sb.append(", id=").append(id);
            sb.append('}');
            return sb.toString();
        }
    }
}
