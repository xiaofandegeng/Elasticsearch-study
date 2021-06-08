package com.atguigu.hash;

import java.util.Scanner;

/**
 * <p>DESC: 哈希表示例</p>
 * <p>DATE: 2021/6/8</p>
 * <p>VERSION:1.0.0</p>
 * <p>@AUTHOR: lhw</p>
 */
public class HashTableDemo {
    public static void main(String[] args) {
        HashTableList hashTableList = new HashTableList(7);
        //写一个简单的菜单
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("add: 添加雇员");
            System.out.println("list: 显示雇员");
            System.out.println("find: 查找雇员");
            System.out.println("exit: 退出系统");
            key = scanner.next();
            switch (key) {
                case "add":
                    System.out.println("输入 id");
                    int id = scanner.nextInt();
                    System.out.println("输入名字");
                    String name = scanner.next();
                    Emp emp = new Emp(id, name);
                    hashTableList.add(emp);
                    break;
                case "list":
                    hashTableList.list();
                    break;
                case "find":
                    System.out.println("请输入要查找的 id");
                    id = scanner.nextInt();
                    hashTableList.findEmpById(id);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                default:
                    break;
            }
        }
    }
}

class HashTableList {
    private int size;
    private EmpLinkedList[] empLinkedLists;

    public HashTableList(int size) {
        this.size = size;
        empLinkedLists = new EmpLinkedList[size];
        for (int i = 0; i < size; i++) {
            empLinkedLists[i] = new EmpLinkedList();
        }
    }

    public void add(Emp emp) {
        int no = hashFun(emp.id);
        empLinkedLists[no].add(emp);
    }

    public void list() {
        for (int i = 0; i < size; i++) {
            empLinkedLists[i].list(i);
        }
    }

    public int hashFun(int id) {
        return id % size;
    }

    public void findEmpById(int id) {
        int no = hashFun(id);
        Emp emp = empLinkedLists[no].findEmpById(id);
        if (emp != null) {
            System.out.println("在第" + (no + 1) + "条链表找到了员工信息，id为：" + id);
        } else {
            System.out.println("没有找到该员工信息");
        }
    }
}

class Emp {
    public Integer id;
    public String name;
    public Emp next;

    public Emp(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}

class EmpLinkedList {
    private Emp head;

    /**
     * 添加雇员
     *
     * @param emp 雇员信息
     */
    public void add(Emp emp) {
        // 添加第一个员工
        if (head == null) {
            head = emp;
            return;
        }
        Emp curEmp = head;
        while (curEmp.next != null) {
            curEmp = curEmp.next;
        }
        curEmp.next = emp;
    }

    public void list(int no) {
        if (head == null) {
            System.out.println("第 " + (no + 1) + " 链表为空");
            return;
        }
        System.out.print("第 " + (no + 1) + " 链表的信息为");
        Emp curEmp = head;
        while (true) {
            System.out.printf(" => id=%d name=%s\t", curEmp.id, curEmp.name);
            if (curEmp.next == null) {
                break;
            }
            curEmp = curEmp.next;
        }
        System.out.println();
    }

    public Emp findEmpById(int id) {
        if (head == null) {
            System.out.println("链表为空");
            return null;
        }
        Emp curEmp = head;
        while (true) {
            if (curEmp.id == id) {
                break;
            }

            if (curEmp.next == null) {
                curEmp = null;
                break;
            }
            curEmp = curEmp.next;
        }
        return curEmp;

    }
}
