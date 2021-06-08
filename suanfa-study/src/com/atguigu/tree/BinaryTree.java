package com.atguigu.tree;

/**
 * <p>DESC: 二叉树</p>
 * <p>DATE: 2021/6/8</p>
 * <p>VERSION:1.0.0</p>
 * <p>@AUTHOR: lhw</p>
 */
public class BinaryTree {
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("当前二叉树为空，无法遍历");
        }
    }

    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("当前二叉树为空，无法遍历");
        }
    }

    public void nextOrder() {
        if (this.root != null) {
            this.root.nextOrder();
        } else {
            System.out.println("当前二叉树为空，无法遍历");
        }
    }

    public HeroNode preSearch(int no) {
        HeroNode res = null;
        if (this.root != null) {
            res = this.root.preSearch(no);
        } else {
            System.out.println("当前二叉树为空，无法遍历");
        }
        return res;
    }
    public HeroNode inFixSearch(int no) {
        HeroNode res = null;
        if (this.root != null) {
            res = this.root.inFixSearch(no);
        } else {
            System.out.println("当前二叉树为空，无法遍历");
        }
        return res;
    }
    public HeroNode nextSearch(int no) {
        HeroNode res = null;
        if (this.root != null) {
            res = this.root.nextSearch(no);
        } else {
            System.out.println("当前二叉树为空，无法遍历");
        }
        return res;
    }

    public void delNode(int no) {
        if(this.root != null){
            // 删除节点是root
            if(this.root.getNo() == no){
                root = null;
            }else {
                root.delNode(no);
            }
        }else {
            System.out.println("这是一个空树，不能删除！");
        }
    }
}


