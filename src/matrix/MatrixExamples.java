package matrix;

import java.util.*;

public class MatrixExamples {
    private static void ShowMatrixElements() {
        int row = 4;
        int col = 4;
        int[][] matrix = new int[row][col];
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = count++;
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void ElementsByMainDiagonal() {
        int row = 4;
        int col = 4;
        int[][] matrix = new int[row][col];
        int[] diagonal = new int[row];
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = count++;
                if (i == j) {
                    diagonal[i] = matrix[i][j];
                }
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Main diagonal: " + Arrays.toString(diagonal));

    }

    private static void ElementsByAuxiliaryDiagonal() {
        int row = 4;
        int col = 4;
        int[][] matrix = new int[row][col];
        int[] lDiagonal = new int[row];
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = count++;
                System.out.print(matrix[i][j] + " ");
            }
            lDiagonal[i] = matrix[i][col - i - 1];
            System.out.println();
        }
        System.out.println(Arrays.toString(lDiagonal));
    }

    private static void ElementsByAboveMainDiagonal() {
        int row = 4;
        int col = 4;
        int[][] matrix = new int[row][col];
        int[] lDiagonal = new int[row + (col / 2)];
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = count++;
                System.out.print(matrix[i][j] + "  ");
            }
            System.out.println();
        }
        for (int i = 0, count2 = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (j > i) {
                    lDiagonal[count2++] = matrix[i][j];
                }
            }
        }
        System.out.println(Arrays.toString(lDiagonal));
    }

    private static void ElementsByBelowMainSeparate() {
        int row = 4;
        int col = 4;
        int[][] matrix = new int[row][col];
        int count = 0;
        int[] bSeparate = new int[row + (col / 2)];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = count++;
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        for (int i = 0, count2 = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (j < i) {
                    bSeparate[count2++] = matrix[i][j];
                }
            }
        }
        System.out.println(Arrays.toString(bSeparate));
    }

    private static void ElementsByAuxiliaryBelowDiagonal() {
        int row = 4;
        int col = 4;
        int[][] matrix = new int[row][col];
        int count = 0;
        int[] lDiagonal = new int[row + (col / 2)];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = count++;
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        for (int i = 0, count2 = 0; i < row; i++) {
            for (int j = 0; j < col - i - 1; j++) {
                lDiagonal[count2++] = matrix[i][j];
            }
        }
        System.out.println(Arrays.toString(lDiagonal));
    }

    private static void ElementsByStairStepOrder() {
        int row = 4;
        int col = 4;
        int[][] matrix = new int[row][col];
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = count++;
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }




    public static void main(String[] args) {
//        ShowMatrixElements();
//        ElementsByMainDiagonal();
//        ElementsByAuxiliaryDiagonal();
//        ElementsByAboveMainDiagonal();
//        ElementsByBelowMainSeparate();
//        ElementsByAuxiliaryBelowDiagonal();
//        ElementsByStairStepOrder();

    }
}

