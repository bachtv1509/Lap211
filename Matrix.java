package src;
import java.util.Scanner;

public class Matrix {
    Scanner sc = new Scanner(System.in);
    public int checkInput(String mess1, int min, int max, String mess2){
        int n = 0;
        while(true){
            try {
                System.out.print(mess1);
                n = Integer.parseInt(sc.nextLine());
                if(n >= min && n <= max) break;
                else System.out.println(mess2);
            } catch (Exception e) {
                System.out.println("Must be integer number");
            }
        }
        return n;
    }

    public void printMenu(){
        System.out.println("======= Calculator Program =======");
        System.out.println("1. Addition Matrix");
        System.out.println("2. Subtraction Matrix");
        System.out.println("3. Multiplication Matrix");
        System.out.println("4. Quit");
    }

    public int[][] addMatrix(int row, int col){
        int matrix[][] = new int[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                matrix[i][j] = checkInput("Enter matrix[" + i + "][" + j + "]: ", Integer.MIN_VALUE, Integer.MAX_VALUE, "");
            }
        }
        return matrix;
    }

    public void printMatrix(int matrix[][], int row, int col){
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                System.out.print("[" + matrix[i][j] + "] ");
            }
            System.out.println();
        }
    }

    public void addMatrix(){
        System.out.println("------- Addition -------");
        int row1 = checkInput("Enter Row Matrix 1: ", Integer.MIN_VALUE, Integer.MAX_VALUE, "");
        int col1 = checkInput("Enter Column Matrix 1: ", Integer.MIN_VALUE, Integer.MAX_VALUE, "");
        int matrix1[][] = addMatrix(row1, col1);
        int row2 = 0, col2 = 0;
        while(true){
            row2 = checkInput("Enter Row Matrix 2: ", Integer.MIN_VALUE, Integer.MAX_VALUE, "");
            if(row2 == row1) break;
            else System.out.println("row2 must equal row1");
        }
        while(true){
            col2 = checkInput("Enter Col Matrix 2: ", Integer.MIN_VALUE, Integer.MAX_VALUE, "");
            if(col2 == col1) break;
            else System.out.println("col2 must equal col1");
        }
        int matrix2[][] = addMatrix(row2, col2);
        int matrix3[][] = new int[row1][col1];
        for(int i = 0; i < row1; i++){
            for(int j = 0; j < col1; j++){
                matrix3[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        System.out.println("------- Result -------");
        printMatrix(matrix1, row1, col1);
        System.out.println("+");
        printMatrix(matrix2, row2, col2);
        System.out.println("=");
        printMatrix(matrix3, row2, col2);
    }

    public void subMatrix(){
        System.out.println("------- Subtraction -------");
        int row1 = checkInput("Enter Row Matrix 1: ", Integer.MIN_VALUE, Integer.MAX_VALUE, "");
        int col1 = checkInput("Enter Column Matrix 1: ", Integer.MIN_VALUE, Integer.MAX_VALUE, "");
        int matrix1[][] = addMatrix(row1, col1);
        int row2 = 0, col2 = 0;
        while(true){
            row2 = checkInput("Enter Row Matrix 2: ", Integer.MIN_VALUE, Integer.MAX_VALUE, "");
            if(row2 == row1) break;
            else System.out.println("row2 must equal row1");
        }
        while(true){
            col2 = checkInput("Enter Col Matrix 2: ", Integer.MIN_VALUE, Integer.MAX_VALUE, "");
            if(col2 == col1) break;
            else System.out.println("col2 must equal col1");
        }
        int matrix2[][] = addMatrix(row2, col2);
        int matrix3[][] = new int[row1][col1];
        for(int i = 0; i < row1; i++){
            for(int j = 0; j < col1; j++){
                matrix3[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        System.out.println("------- Result -------");
        printMatrix(matrix1, row1, col1);
        System.out.println("-");
        printMatrix(matrix2, row2, col2);
        System.out.println("=");
        printMatrix(matrix3, row2, col2);
    }

    public void mulMatrix(){
        System.out.println("------- Addition -------");
        int row1 = checkInput("Enter Row Matrix 1: ", Integer.MIN_VALUE, Integer.MAX_VALUE, "");
        int col1 = checkInput("Enter Column Matrix 1: ", Integer.MIN_VALUE, Integer.MAX_VALUE, "");
        int matrix1[][] = addMatrix(row1, col1);
        int row2 = 0, col2 = 0;
        while(true){
            row2 = checkInput("Enter Row Matrix 2: ", Integer.MIN_VALUE, Integer.MAX_VALUE, "");
            if(row2 == col1) break;
            else System.out.println("row2 must equal col1");
        }
        col2 = checkInput("Enter Col Matrix 2: ", Integer.MIN_VALUE, Integer.MAX_VALUE, "");
        int matrix2[][] = addMatrix(row2, col2);
        int matrix3[][] = new int[row1][col2];
        for(int i = 0; i < row1; i++){
            for(int j = 0; j < col2; j++){
                for(int k = 0; k < col1; k++){
                    matrix3[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        System.out.println("------- Result -------");
        printMatrix(matrix1, row1, col1);
        System.out.println("*");
        printMatrix(matrix2, row2, col2);
        System.out.println("=");
        printMatrix(matrix3, row1, col2);        
    }

    public static void main(String[] args) {
        Matrix m = new Matrix();
        int choice = m.checkInput("Your Choice: ", 1, 4, "Please enter 1 - 4");
            switch (choice) {
                case 1:
                    m.addMatrix();
                    break;
                case 2:
                    m.subMatrix();
                    break;
                case 3:
                    m.mulMatrix();
                    break;
                case 4:
                    System.exit(0);
                    break;
            }
    }
}
