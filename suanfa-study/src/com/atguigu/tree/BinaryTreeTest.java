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
        HeroNode node05 = new HeroNode(5, "王胜");

        tree.setRoot(node01);
        node01.setLeft(node02);
        node01.setRight(node03);
        node03.setRight(node04);
        node03.setLeft(node05);

//        // 前序遍历
//        tree.preOrder();
//        //中序遍历
//        tree.infixOrder();
        //后续遍历
        tree.nextOrder();

    }
}
