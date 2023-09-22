import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        //Задача 22. Дана разреженная квадратная матрица (CS). Повернуть матрицу на 90 градусов.
        /*
        0 2 0 0 0 4 0
        0 0 0 7 0 0 1
        9 0 0 0 0 2 0
        0 3 0 3 0 0 0
        5 0 0 0 0 0 0
        0 0 0 0 0 0 0
        0 6 7 4 0 0 3
         */
        System.out.println("Hello world!");
        int space = 0;
        int size = 7;

        Integer[][] matrix = new Integer[][] {
                {2, 4, 7, 1, 9, 2, 3, 3, 5, 6, 7, 4, 3},
                {1, 1, 2, 2, 3, 3, 4, 4, 5, 7, 7, 7, 7},
                {2, 6, 4, 7, 1, 6, 2, 4, 1, 2, 3, 4, 7}};
        print(matrix, space, size);
        System.out.println();
        print(rotate(matrix, 7), space, size);
    }
    static public void print(Integer[][] matrix, int space, int size) {
        int n = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (n != matrix[0].length && matrix[1][n] == (i + 1) && matrix[2][n] == (j + 1)) {
                    System.out.print(matrix[0][n]);
                    n++;
                } else {
                    System.out.print(space);
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    static Integer[][] rotate(Integer[][] matrix, int size) {
        Integer[][] result = new Integer[3][matrix[0].length];
        Integer[][] fResult = new Integer[3][matrix[0].length];
        result[0] = matrix[0];
        result[1]= matrix[2]; // line
        for (int i = 0; i < matrix[0].length; i++) {
            result[2][i] = 8 - matrix[1][i]; // column
        }
        for (int i = 0; i < 3; i++) {
            result[i] = invert(result[i]);
        }
        int n = 0;
        for (int i = 1; i <= size ; i++) {
            for (int j = 0; j < result[0].length; j++) {
                if (result[1][j] == i) {
                    fResult[0][n] = result[0][j];
                    fResult[1][n] = result[1][j];
                    fResult[2][n] = result[2][j];
                    n++;
                }
            }
        }
        return fResult;
    }
    static Integer[][] convert(Integer[] value, Integer[] line, Integer[] column) {
        Integer[][] result = new Integer[3][value.length];
        result[0] = value;
        result[1] = line;
        result[2] = column;
        return result;
    }
    static Integer[] invert(Integer[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            Integer temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
        return array;
    }
}