import java.util.Scanner;

public class Matrix3x3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = new int[3][3];
        
        // Taking user input for the matrix
        System.out.println("Enter elements of the 3x3 matrix:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("Element at (" + i + "," + j + "): ");
                matrix[i][j] = scanner.nextInt();
            }
        }
        
        // Displaying the matrix
        System.out.println("The 3x3 matrix is:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        
        scanner.close();
    }
}