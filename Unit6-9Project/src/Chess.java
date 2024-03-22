import java.util.Scanner;
public class Chess {
    private Piece[][] board;
    private Scanner scan;
    private String color;
    private boolean run;
    public Chess() {
        scan = new Scanner(System.in);
        createBoard();
        color = "White";
        run = true;
        play();
    }
    private void createBoard() {
        board = new Piece[8][8];
        for (int i = 0; i < board.length; i++) {
            int[] pos = new int[2];
            pos[0] = 1;
            pos[1] = i;
            board[1][i] = new Pawn(pos, "Black", "♙ ");
        }
        for (int i = 0; i < board.length; i++) {
            int[] pos = new int[2];
            pos[0] = 1;
            pos[1] = i;
            board[6][i] = new Pawn(pos, "White", "♟ ");
        }
        for (int i = 2; i < board.length-2; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int[] pos = new int[2];
                pos[0] = i;
                pos[1] = j;
                board[i][j] = new Piece(pos, "none", "_   ");
            }
        }
        int[] pos = new int[2];
        pos[0] = 0;
        pos[1] = 0;
        board[0][0] = new Rook(pos, "Black", "♜ ");
        pos[1] += 1;
        board[0][1] = new Knight(pos, "Black", "♞ ");
        pos[1] += 1;
        board[0][2] = new Bishop(pos, "Black", "♝ ");
        pos[1] += 1;
        board[0][3] = new Queen(pos, "Black", "♛ ");
        pos[1] += 1;
        board[0][4] = new King(pos, "Black", "♚ ");
        pos[1] += 1;
        board[0][5] = new Bishop(pos, "Black", "♝ ");
        pos[1] += 1;
        board[0][6] = new Knight(pos, "Black", "♞ ");
        pos[1] += 1;
        board[0][7] = new Rook(pos, "Black", "♜ ");

        pos[0] = 7;
        pos[1] = 0;

        board[7][0] = new Rook(pos, "White", "♜ ");
        pos[1] += 1;
        board[7][1] = new Knight(pos, "White", "♞ ");
        pos[1] += 1;
        board[7][2] = new Bishop(pos, "White", "♝ ");
        pos[1] += 1;
        board[7][3] = new Queen(pos, "White", "♛ ");
        pos[1] += 1;
        board[7][4] = new King(pos, "White", "♚ ");
        pos[1] += 1;
        board[7][5] = new Bishop(pos, "White", "♝ ");
        pos[1] += 1;
        board[7][6] = new Knight(pos, "White", "♞ ");
        pos[1] += 1;
        board[7][7] = new Rook(pos, "White", "♜ ");
    }

    private boolean hasPiece(int[] spot) {
        if (board[spot[0]][spot[1]].getPiece() != "_") {
            return true;
        } return false;
    }

    private void printBoard() {
        for (Piece[] row: board) {
            for (Piece piece: row) {
                System.out.print(piece.getPiece());
            } System.out.println();
        }
    }

    private void move() {
        System.out.print("Which piece would you like to move? (Give notation it is on such as e2) ");
        String piece = scan.nextLine();
        char char1 = piece.charAt(0);
        int num = char1 - 'a';
        System.out.println(num);
        if (board[8-Integer.parseInt(piece.substring(1))][num].getColor().equals(color)) {
            System.out.print("To which square? (Give notation such as e4) ");
            String direction = scan.nextLine();
            char1 = direction.charAt(0);
            int destination = char1 - 'a';
            if (board[8-Integer.parseInt(direction.substring(1))][destination].getColor().equals(color)) {
                System.out.println("You can't capture your own piece");
                move();
            }
            int[] pos = new int[2];
            pos[0] = 8-Integer.parseInt(piece.substring(1));
            pos[1] = num;
            board[8-Integer.parseInt(direction.substring(1))][destination] = board[8-Integer.parseInt(piece.substring(1))][num];
            board[8-Integer.parseInt(piece.substring(1))][num] = new Piece(pos, "none", "_   ");

            if (color.equals("White")) {
                color = "Black";
            } else {
                color = "White";
            }
        } else {
            System.out.println("Invalid move");
            move();
        }
    }

    public void play() {
        while (run) {
            printBoard();
            move();
        }
    }
}
