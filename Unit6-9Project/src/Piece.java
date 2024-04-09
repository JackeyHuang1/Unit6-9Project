public class Piece {
    private int[] position;
    private String color;
    private String name;

    public Piece(int[] position, String color, String name) {
        this.position = position;
        this.color = color;
        this.name = name;
    }

    public int[] getPosition() {
        return position;
    }

    public String getPiece() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public boolean isValidMove(int[] move) {
        if (move[0] > 7 || move[0] < 0) {
            return false;
        } if (move[1] > 7 || move[1] < 0) {
            return false;
        } return true;
    }

}
