public class Board {
    Piece[][] board;
    public Board() {
        board = new Piece[8][8];
        for (int i = 0; i < board.length; i++) {

            int[] pos = new int[2];
            pos[0] = 1;
            pos[1] = i;
            board[1][i] = new Pawn(pos, "Black", Colors.BLACK + "♙ ");
        }
        for (int i = 0; i < board.length; i++) {
            int[] pos = new int[2];
            pos[0] = 6;
            pos[1] = i;
            board[6][i] = new Pawn(pos, "White", Colors.WHITE + "♟ ");
        }
        for (int i = 2; i < board.length-2; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int[] pos = new int[2];
                pos[0] = i;
                pos[1] = j;
                board[i][j] = new Piece(pos, "none", Colors.WHITE + "_   ");
            }
        }
        int[] pos = new int[2];
        pos[0] = 0;
        pos[1] = 0;
        board[0][0] = new Rook(pos, "Black", Colors.BLACK + "♜ ");
        pos[1] += 1;
        board[0][1] = new Knight(pos, "Black", Colors.BLACK + "♞ ");
        pos[1] += 1;
        board[0][2] = new Bishop(pos, "Black", Colors.BLACK + "♝ ");
        pos[1] += 1;
        board[0][3] = new Queen(pos, "Black", Colors.BLACK + "♛ ");
        pos[1] += 1;
        board[0][4] = new King(pos, "Black", Colors.BLACK + "♚ ");
        pos[1] += 1;
        board[0][5] = new Bishop(pos, "Black", Colors.BLACK + "♝ ");
        pos[1] += 1;
        board[0][6] = new Knight(pos, "Black", Colors.BLACK + "♞ ");
        pos[1] += 1;
        board[0][7] = new Rook(pos, "Black", Colors.BLACK + "♜ ");

        pos[0] = 7;
        pos[1] = 0;

        board[7][0] = new Rook(pos, "White", Colors.WHITE + "♜ ");
        pos[1] += 1;
        board[7][1] = new Knight(pos, "White", Colors.WHITE +"♞ ");
        pos[1] += 1;
        board[7][2] = new Bishop(pos, "White", Colors.WHITE +"♝ ");
        pos[1] += 1;
        board[7][3] = new Queen(pos, "White", Colors.WHITE +"♛ ");
        pos[1] += 1;
        board[7][4] = new King(pos, "White", Colors.WHITE +"♚ ");
        pos[1] += 1;
        board[7][5] = new Bishop(pos, "White", Colors.WHITE +"♝ ");
        pos[1] += 1;
        board[7][6] = new Knight(pos, "White", Colors.WHITE +"♞ ");
        pos[1] += 1;
        board[7][7] = new Rook(pos, "White", Colors.WHITE +"♜ ");
    }

    public Piece[][] getBoard() {
        return board;
    }


    public boolean isValidPiece(String color, int[] start) {
        if (board[start[0]][start[1]].getColor().equals(color)) {
            return true;
        } return false;
    }

    public void move(int[] start, int[] end) {
        Piece temp = board[start[0]][start[1]];
        board[end[0]][end[1]] = board[start[0]][start[1]];
        board[start[0]][start[1]] = temp;
    }
}

