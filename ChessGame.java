import java.util.Scanner;

class ChessGame {
    private static final int SIZE = 8;
    private static char[][] board = new char[SIZE][SIZE];

    public static void main(String[] args) {
        initializeBoard();
        displayBoard();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter your move (e.g., e2 e4): ");
            String move = scanner.nextLine();
            if (move.equalsIgnoreCase("exit")) break;
            if (isValidMove(move)) {
                makeMove(move);
                displayBoard();
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
        scanner.close();
    }

    private static void initializeBoard() {
        String[] initialSetup = {
                "RNBQKBNR",
                "PPPPPPPP",
                "        ",
                "        ",
                "        ",
                "        ",
                "pppppppp",
                "rnbqkbnr"
        };
        for (int i = 0; i < SIZE; i++) {
            board[i] = initialSetup[i].toCharArray();
        }
    }

    private static void displayBoard() {
        System.out.println("  a b c d e f g h");
        for (int i = 0; i < SIZE; i++) {
            System.out.print((8 - i) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println(8 - i);
        }
        System.out.println("  a b c d e f g h");
    }

    private static boolean isValidMove(String move) {
        return move.matches("[a-h][1-8] [a-h][1-8]");
    }

    private static void makeMove(String move) {
        int startRow = 8 - Character.getNumericValue(move.charAt(1));
        int startCol = move.charAt(0) - 'a';
        int endRow = 8 - Character.getNumericValue(move.charAt(4));
        int endCol = move.charAt(3) - 'a';
        
        board[endRow][endCol] = board[startRow][startCol];
        board[startRow][startCol] = ' ';
    }
}
