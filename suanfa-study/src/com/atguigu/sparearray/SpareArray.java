package com.atguigu.sparearray;

import java.io.*;

public class SpareArray {
    public static void main(String[] args) {
        // 创建一个原始的二维数组
        // 0:表示没有棋子，1：表示黑子，2：表示白子
        int rowLength = 11;
        int colLength = 13;
        int[][] chessArr1 = InitArr(rowLength, colLength);
        // 输出二维数组
        System.out.println("----------------打印二维数组----------------");
        for (int[] row: chessArr1) {
            for (int item: row) {
                System.out.printf("%d\t", item);
            }
            System.out.println();
        }
        int[][] spareArr = getSpareArr(chessArr1);

        // 打印稀疏数组
        System.out.println("------------------打印稀疏数组----------------");
        for (int[] row: spareArr) {
            for (int item: row) {
                System.out.printf("%d\t", item);
            }
            System.out.println();
        }


        // 1.先创建二维数组
        int[][] chessArr2 = getChessArr(spareArr);

        // 打印恢复后的二维数组
        System.out.println("----------------打印二维数组----------------");
        for (int[] row: chessArr2) {
            for (int item: row) {
                System.out.printf("%d\t", item);
            }
            System.out.println();
        }

        // 将稀疏数组存入文件
        spareArrWriteToTo(spareArr);
    }

    private static void spareArrWriteToTo(int[][] spareArr) {
        try {
            File file = new File("spareseArray.txt");
            if(file.exists()){
                file.delete();
            }
            file.createNewFile();
            FileOutputStream fos = new FileOutputStream(file);
            OutputStreamWriter writer = new OutputStreamWriter(fos, "utf-8");
            for (int i = 0; i < spareArr.length; i++) {
                for (int j = 0; j < 3; j++) {
                    writer.write(spareArr[i][j]+"\t");
                }
                writer.write("\n");
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int[][] InitArr(int i, int j) {
        int[][] chessArr1 = new int[i][j];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[2][5] = 2;
        return chessArr1;
    }

    private static int[][] getChessArr(int[][] spareArr) {
        System.out.println("----------------稀疏数组转化为二维数组---------------");
        int[][] chessArr2 = new int[spareArr[0][0]][spareArr[0][1]];
        for (int i = 1; i < spareArr.length; i++) {
            chessArr2[spareArr[i][0]][spareArr[i][1]] = spareArr[i][2];
        }
        return chessArr2;
    }

    private static int[][] getSpareArr(int[][] chessArr1) {
        // 1.二维数组转稀疏数组
        System.out.println("------------------二维数组转换为稀疏数组------");
        // 定义有效个数的数量 sum
        int sum = 0;
        for (int[] row: chessArr1) {
            for (int item: row) {
                if (item != 0) {
                    sum++;
                }
            }
        }
        System.out.println("sum: " + sum);

        // 2.定义稀疏数组
        int[][] spareArr = new int[sum + 1][3];
        // 定义稀疏数组第一行数据（原二维数组行，原二维数组列，原有效个数）
        spareArr[0][0] = chessArr1.length;
        spareArr[0][1] = chessArr1[0].length;
        spareArr[0][2] = sum;
        // 定义一个计数器，用于稀疏数组的当前行数，从第二行开始
        int count = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[0].length; j++) {
                if (chessArr1[i][j] != 0) {
                    count++;
                    spareArr[count][0] = i;
                    spareArr[count][1] = j;
                    spareArr[count][2] = chessArr1[i][j];
                }
            }
        }
        return spareArr;
    }
}
