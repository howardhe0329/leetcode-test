package com.howard.leetcode.binary.tree;

/**
 * 每个节点的右向指针II
 *
 * @author howard he
 * @create 2018-12-27 15:44
 */
public class ConnectSolutionII {

    /**
     *
     * @param root
     */
    public void connect(TreeLinkNode root) {
        connectNext(root, null);
    }

    /**
     * 自顶向下的思想
     *
     * @param curr
     * @param prev
     */
    private void connectNext(TreeLinkNode curr, TreeLinkNode prev) {
        if (curr == null) {
            return;
        }
        if (prev != null) {
            prev.next = curr;
        }
        connectNext(curr.left,  null);
        connectNext(curr.right, curr.left);
    }

}
