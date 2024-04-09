import java.util.Scanner;
import java.util.ArrayList;
public class Chess {
    private Board board;
    private Scanner scan;
    private String color;
    private boolean run;
    private ArrayList pointsWhite;
    private ArrayList pointsBlack;

    public Chess() {
        scan = new Scanner(System.in);
        board = new Board();
        color = "White";
        run = true;
        System.out.println("You win the game by capturing the king (Not an excuse because I'm bad at coding and can't implement checks)");
        play();
    }

    private void printBoard() {
        ;
        for (char alphabet = 'a'; alphabet <= 'h'; alphabet++) {
            System.out.print("  " + alphabet);
        }
        System.out.println();
        for (int i = 0; i < board.getBoard().length; i++) {
            System.out.print(Colors.WHITE + (8 - i) + " ");
            for (int j = 0; j < board.getBoard()[0].length; j++) {
                System.out.print(board.getBoard()[i][j].getPiece());
            }
            System.out.println();
        }

    }

    public void move() {
        printBoard();
        System.out.println(Colors.RESET + "Right now, it is " + color + "'s turn");
        System.out.print("Which piece would you like to move? (Give notation it is on such as e2) ");
        String piece = scan.nextLine();
        char char1 = piece.charAt(0);
        int num = char1 - 'a';
        if (num > 7 || Character.getNumericValue(piece.charAt(1)) > 7) {
            System.out.println("invalid input, retry");
            move();
        }
        int[] start = new int[]{8 - Character.getNumericValue(piece.charAt(1)), num};
        if (!board.isValidPiece(color, start)) {
            System.out.println("Invalid move, that is not one of your pieces");
            move();
        }
        System.out.print("To which square? (Give notation to where such as e4) ");
        String destination = scan.nextLine();
        char char2 = destination.charAt(0);
        int num2 = char2 - 'a';
        if (num2 > 7 || Character.getNumericValue(destination.charAt(1)) > 7) {
            System.out.println("invalid input, retry");
            move();
        }
        int[] end = new int[]{8 - Character.getNumericValue(destination.charAt(1)), num2};
        if (board.getBoard()[start[0]][start[1]].isValidMove(end)) {
            board.move(start, end);
        } else {
            System.out.println("Invalid move, that is not a valid square");
            move();
        }
        if (color.equals("White")) {
            color = "Black";
        } else {
            color = "White";
        }
    }

    public void play() {
        while (run) {
            move();
//        } if () {
//            System.out.print(color + " has checkmated ");
//            if (color.equals("White")) {
//                color = "Black";
//            } else {
//                color = "White";
//            } System.out.print(color);
//        }
        }
    }
}
