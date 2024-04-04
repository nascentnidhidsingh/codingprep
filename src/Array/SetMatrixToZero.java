package Array;

public class SetMatrixToZero {
    public static void main(String[] args) {
        int[][] matrix = {{0, 1, 1},
                {1, 0, 1},
                {1, 1, 1}};
        int row_length = matrix.length;
        int col_length = matrix[0].length;

        bruteForce(row_length, col_length, matrix);
        int[][] matrix1 = {{0, 1, 1},
                {1, 0, 1},
                {1, 1, 1}};
        System.out.println();
        efficient(matrix1);
    }

    private static void efficient(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int col0 = 1;
        //mark row - matrix[..][0]
        //mark col - matrix[0][..]
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    if (j != 0)
                        matrix[0][j] = 0;
                    else
                        col0 = 0;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (matrix[0][0] == 0) {
            for (int j = 0; j < n; j++)
                matrix[0][j] = 0;
        }

        if (col0 == 0) {
            for (int i = 0; i < m; i++)
                matrix[i][0] = 0;
        }
        for (int[] ints : matrix) {
            for (int j = 0; j < n; j++) {
                System.out.print(ints[j]);
            }
            System.out.println();
        }
    }

    private static void bruteForce(int row_length, int col_length, int[][] matrix) {
        for (int i = 0; i < row_length; i++) {
            for (int j = 0; j < col_length; j++) {
                if (matrix[i][j] == 0) {
                    markRow(i, col_length, matrix);
                    markCol(j, row_length, matrix);
                }
            }
        }

        for (int i = 0; i < row_length; i++) {
            for (int j = 0; j < col_length; j++) {
                if (matrix[i][j] == -1)
                    matrix[i][j] = 0;
            }
        }

        for (int[] ints : matrix) {
            for (int j = 0; j < col_length; j++) {
                System.out.print(ints[j]);
            }
            System.out.println();
        }
    }

    private static void markRow(int i, int col_length, int[][] matrix) {
        for (int x = 0; x < col_length; x++) {
            if (matrix[i][x] != 0)
                matrix[i][x] = -1;
        }
    }

    private static void markCol(int j, int row_length, int[][] matrix) {
        for (int x = 0; x < row_length; x++) {
            if (matrix[x][j] != 0)
                matrix[x][j] = -1;
        }
    }
}

