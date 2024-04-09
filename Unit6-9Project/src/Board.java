public class Board {
    static Piece[][] board;
    public void makeBoard() {
        board = new Piece[8][8];
        for (int i = 0; i < board.length; i++) {
            board[1][i] = new Pawn(new int[] {1, i}, "Black", Colors.BLACK + "♙ ");
        }
        for (int i = 0; i < board.length; i++) {
            board[6][i] = new Pawn(new int[] {6, i}, "White", Colors.WHITE + "♟ ");
        }
        for (int i = 2; i < board.length-2; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = new Piece(new int[] {i, j}, "none", Colors.WHITE + "_   ");
            }
        }

        board[0][0] = new Rook(new int[] {0, 0}, "Black", Colors.BLACK + "♜ ");
        board[0][1] = new Knight(new int[] {0, 1}, "Black", Colors.BLACK + "♞ ");
        board[0][2] = new Bishop(new int[] {0, 2}, "Black", Colors.BLACK + "♝ ");
        board[0][3] = new Queen(new int[] {0, 3}, "Black", Colors.BLACK + "♛ ");
        board[0][4] = new King(new int[] {0, 4}, "Black", Colors.BLACK + "♚ ");
        board[0][5] = new Bishop(new int[] {0, 5}, "Black", Colors.BLACK + "♝ ");
        board[0][6] = new Knight(new int[] {0, 6}, "Black", Colors.BLACK + "♞ ");
        board[0][7] = new Rook(new int[] {0, 7}, "Black", Colors.BLACK + "♜ ");


        board[7][0] = new Rook(new int[] {7, 0}, "White", Colors.WHITE + "♜ ");
        board[7][1] = new Knight(new int[] {7, 1}, "White", Colors.WHITE +"♞ ");
        board[7][2] = new Bishop(new int[] {7, 2}, "White", Colors.WHITE +"♝ ");
        board[7][3] = new Queen(new int[] {7, 3}, "White", Colors.WHITE +"♛ ");
        board[7][4] = new King(new int[] {7, 4}, "White", Colors.WHITE +"♚ ");
        board[7][5] = new Bishop(new int[] {7, 5}, "White", Colors.WHITE +"♝ ");
        board[7][6] = new Knight(new int[] {7, 6}, "White", Colors.WHITE +"♞ ");
        board[7][7] = new Rook(new int[] {7, 7}, "White", Colors.WHITE +"♜ ");
    }

    public static Piece[][] getBoard() {
        return board;
    }


    public static boolean isValidPiece(String color, int[] start) {
        if (board[start[0]][start[1]].getColor().equals(color)) {
            return true;
        } return false;
    }

    public static void move(int[] start, int[] end) {
        Piece temp = board[start[0]][start[1]];
        int[] tempCoords = board[end[0]][end[1]].getPosition();
        board[end[0]][end[1]] = temp;
        board[end[0]][end[1]].updatePosition(tempCoords);
        board[start[0]][start[1]] = new Piece(new int[] {start[0], start[1]}, "none", Colors.WHITE + "_   ");

    }
}

