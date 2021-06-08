package com.atguigu.tree;

/**
 * <p>DESC: 英雄节点</p>
 * <p>DATE: 2021/6/8</p>
 * <p>VERSION:1.0.0</p>
 * <p>@AUTHOR: lhw</p>
 */
public class HeroNode {
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        // 先输出父节点
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    public HeroNode preSearch(int no) {
        System.out.println("进入前序遍历");
        if (this.getNo() == no) {
            return this;
        }
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.preSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        if (this.right != null) {
            resNode = this.right.preSearch(no);
        }

        return resNode;
    }

    public void infixOrder() {

        if (this.left != null) {
            this.left.infixOrder();
        }
        // 先输出父节点
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    public HeroNode inFixSearch(int no) {
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.inFixSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }

        System.out.println("进入中序遍历");
        if (this.getNo() == no) {
            return this;
        }

        if (this.right != null) {
            resNode = this.right.inFixSearch(no);
        }

        return resNode;
    }


    public void nextOrder() {

        if (this.left != null) {
            this.left.nextOrder();
        }
        if (this.right != null) {
            this.right.nextOrder();
        }
        // 先输出父节点
        System.out.println(this);
    }

    public HeroNode nextSearch(int no) {
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.nextSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }

        if (this.right != null) {
            resNode = this.right.nextSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }

        System.out.println("进入后序遍历");
        if (this.getNo() == no) {
            return this;
        }
        return null;
    }
    public void delNode(int no) {
        if(this.left != null && this.left.no == no){
            this.left = null;
            return;
        }
        if(this.right != null && this.right.no == no){
            this.right = null;
            return;
        }
        // 递归删除
        if(this.left != null){
            this.left.delNode(no);
        }
        if(this.right != null){
            this.right.delNode(no);
        }
    }
}
