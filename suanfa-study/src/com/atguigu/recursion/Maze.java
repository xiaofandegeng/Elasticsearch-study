package com.atguigu.recursion;

import static java.lang.System.out;

/**
 * @Description 用递归实现迷宫
 * @Author lhw
 * @Date 2021/5/31 21:33
 * @Version 1.0
 **/
public class Maze {
    public static void main(String[] args) {
        int[][] map = new int[10][10];
        for (int i = 0; i < map.length; i++) {
            map[0][i] = 1;
            map[map.length - 1][i] = 1;
        }
        for (int i = 0; i < map[0].length; i++) {
            map[i][0] = 1;
            map[i][map.length - 1] = 1;
        }
        map[2][1] = 1;
        map[3][4] = 1;
        map[5][2] = 1;
        out.println("打印地图");
        for (int[] ints : map) {
            for (int anInt : ints) {
                out.print(anInt + " ");
            }
            out.println();
        }
        out.println(map[7][8]);

        setWay(map, 1, 1);

        out.println("-----------------行走之后的地图-----------");
        for (int[] ints : map) {
            for (int anInt : ints) {
                out.print(anInt + " ");
            }
            out.println();
        }
    }

    /**
     * 判断是否找到了终点 1：表示墙  2：表示走过了 可以走的路 3表示思路不能走了
     *
     * @param map 地图map
     * @param i   起始位置的行 col
     * @param j   起始位置的列 row
     * @return 找到了终点为true，没找到为false
     */
    private static boolean setWay(int[][] map, int i, int j) {
        if (map[7][8] == 2) {
            out.println("找到了迷宫的出口！！！！");
            return true;
        } else {
            //  默认传入的点可以走通
            if (map[i][j] == 0) {
                map[i][j] = 2;
                //  行走路径为 上 -> 下 ->右 -> 左
                if (setWay(map, i - 1, j)) {
                    return true;
                } else if (setWay(map, i + 1, j)) {
                    return true;
                } else if (setWay(map, i, j + 1)) {
                    return true;
                } else if (setWay(map, i, j - 1)) {
                    return true;
                } else {
                    map[i][j] = 3;
                    return false;
                }
            } else {
                out.println("当前位置：map[" + i + "][" + j+"] 不是迷宫的出口！！！！");
                return false;
            }
        }
    }
}
