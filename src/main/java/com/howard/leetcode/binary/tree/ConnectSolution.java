package com.howard.leetcode.binary.tree;

/**
 * 每个节点右向指针
 *
 * @author howard he
 * @create 2018-12-27 14:17
 */
public class ConnectSolution {

    /**
     * 每个节点右向指针
     * @param root
     */
    public void connect(TreeLinkNode root) {
        connectNext(root, null);
    }

    /**
     * 自顶向下的思路
     *
     * 1. 你能确定一些参数，从该节点自身解决出发寻找答案吗？
     * 2. 你可以使用这些参数和节点本身的值来决定什么应该是传递给它子节点的参数吗？
     * @param curr
     * @param next
     */
    private void connectNext(TreeLinkNode curr, TreeLinkNode next) {
        if (curr == null) {
            return;
        }
        curr.next = next;
        connectNext(curr.left, curr.right);
        connectNext(curr.right, curr.next == null ? null : curr.next.left);
    }
}
