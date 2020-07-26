package com.howard.leetcode.training;

import java.util.*;

public class Solution126 {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> nodeNeighbors = new HashMap<>(wordList.size()); // Neighbors for every node
        Map<String, Integer> distance = new HashMap<>(wordList.size());    // Distance of every node from the start node
        List<String> item = new ArrayList<>();

        dict.add(beginWord);
        // 找出所有能到达endWord节点的最短路径
        bfs(beginWord, endWord, dict, nodeNeighbors, distance);
        System.out.println(nodeNeighbors);
        System.out.println(distance);
        dfs(beginWord, endWord, dict, nodeNeighbors, distance, item, result);
        return result;
    }

    /**
     * BFS: Trace every node's distance from the start node (level by level).
     * @param beginWord begin node
     * @param endWord end node
     * @param dict  dictionary
     * @param nodeNeighbors neighbors map
     * @param distanceMap distance map
     */
    private void bfs(String beginWord, String endWord, Set<String> dict, Map<String, List<String>> nodeNeighbors, Map<String, Integer> distanceMap) {
        for (String str: dict)
            nodeNeighbors.put(str, new ArrayList<>());

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        distanceMap.put(beginWord, 0);

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean foundEnd = false;
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                int curDistance = distanceMap.get(cur);
                List<String> neighbors = getNeighbors(cur, dict);
                for (String neighbor : neighbors) {
                    nodeNeighbors.get(cur).add(neighbor);
                    if (!distanceMap.containsKey(neighbor)) {   // Check if visited
                        distanceMap.put(neighbor, curDistance + 1);
                        if (endWord.equals(neighbor))   // Found the shortest path
                            foundEnd = true;
                        else
                            queue.offer(neighbor);
                    }
                }
            }
            if (foundEnd) break;
        }
    }

    /**
     * find all next level nodes.
     * @param node node
     * @param dict  dictionary
     * @return next node list
     */
    private List<String> getNeighbors(String node, Set<String> dict) {
        List<String> res = new ArrayList<>();
        char[] chars = node.toCharArray();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == ch) continue;
                char old = chars[i];
                chars[i] = ch;
                String target = String.valueOf(chars);
                if (dict.contains(target))
                    res.add(target);
                chars[i] = old;
            }
        }
        return res;
    }

    /**
     *
     * @param cur   current node
     * @param end   end node
     * @param dict  dictionary
     * @param nodeNeighbors neighbors map
     * @param distanceMap   distance map
     * @param item  item
     * @param result    result
     */
    private void dfs(String cur, String end, Set<String> dict, Map<String, List<String>> nodeNeighbors, Map<String, Integer> distanceMap, List<String> item, List<List<String>> result) {
        item.add(cur);
        if (end.equals(cur)) {
            result.add(new ArrayList<>(item));
        } else {
            for (String next : nodeNeighbors.get(cur)) {
                if (distanceMap.get(next) == distanceMap.get(cur) + 1)
                    dfs(next, end, dict, nodeNeighbors, distanceMap, item, result);
            }
        }
        item.remove(item.size() - 1);
    }

    public static void main(String[] args) {
        Solution126 solution126 = new Solution126();
        List<List<String>> res = solution126.findLadders("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        System.out.println(res);

    }
}
