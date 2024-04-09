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

    public void updatePosition(int[] newPosition) {
        position = newPosition;
    }

    public boolean isValidMove(int[] move) {
        if (Board.getBoard()[move[0]][move[1]].getColor().equals(Board.getBoard()[getPosition()[0]][getPosition()[1]].getColor())) {
            return false;
        }
        if (move[0] > 7 || move[0] < 0) {
            return false;
        } if (move[1] > 7 || move[1] < 0) {
            return false;
        } return true;
    }

}
