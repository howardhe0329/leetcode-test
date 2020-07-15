package com.howard.leetcode.binary.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NTreeNodeGenerator {

    public static NTreeNode generate(List<Integer> data, int N) {
        if (data == null || data.isEmpty()) {
            return null;
        }
        NTreeNode root = new NTreeNode(data.get(0));
        Queue<NTreeNode> queue = new LinkedList<>();
        queue.offer(root);
        for (int i = 1; i < data.size(); i += N) {
            NTreeNode t = queue.poll();
            if (t != null) {
                List<NTreeNode> children = new ArrayList<>();
                t.children = children;
                for (int j = 0; j < N; j++) {
                    if (i + j < data.size()) {
                        Integer val = data.get(i + j);
                        if (val != null) {
                            NTreeNode child = new NTreeNode(val);
                            queue.offer(child);
                            children.add(child);
                        }
                    }
                }
            }
        }
        return root;
    }
}
