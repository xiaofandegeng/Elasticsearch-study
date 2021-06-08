package com.atguigu.tree;

/**
 * <p>DESC: 二叉树测试类</p>
 * <p>DATE: 2021/6/8</p>
 * <p>VERSION:1.0.0</p>
 * <p>@AUTHOR: lhw</p>
 */
public class BinaryTreeTest {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        HeroNode node01 = new HeroNode(1, "宋江");
        HeroNode node02 = new HeroNode(2, "吴用");
        HeroNode node03 = new HeroNode(3, "林冲");
        HeroNode node04 = new HeroNode(4, "武松");

        tree.setRoot(node02);
        node02.setLeft(node01);
        node02.setRight(node03);
        node03.setRight(node04);

//        // 前序遍历
//        tree.preOrder();
//        //中序遍历
//        tree.infixOrder();
        //后续遍历
        tree.nextOrder();

    }
}
