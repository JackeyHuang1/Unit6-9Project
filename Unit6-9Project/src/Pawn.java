public class Pawn extends Piece {
    int amount = 2;
    boolean hasMoved = false;

    public Pawn(int[] position, String color, String name) {
        super(position, color, name);
    }

    public boolean isValidMove(int[] destination) {
        if (hasMoved) {
            amount = 1;
        }
        if (!super.isValidMove(destination)) {
            return false;
        }
        if (getColor().equals("White") && destination[0] >= getPosition()[0] - amount && destination[1] == getPosition()[1]) {
            if (Board.getBoard()[destination[0]][destination[1]].getColor().equals("none")) {
                hasMoved = true;
                return true;
            }
        }
        if (getColor().equals("Black") && destination[0] <= getPosition()[0] + amount && destination[1] == getPosition()[1]) {
            if (Board.getBoard()[destination[0]][destination[1]].getColor().equals("none")) {
                hasMoved = true;
                return true;
            }
        }
        if (getColor().equals("White") && !Board.getBoard()[destination[0]][destination[1]].getColor().equals("none") && destination[0] == getPosition()[0] - 1 && destination[1] == getPosition()[1] - 1) {
            hasMoved = true;
            return true;
        }
        if (getColor().equals("Black") && !Board.getBoard()[destination[0]][destination[1]].getColor().equals("none") && destination[0] == getPosition()[0] + 1 && destination[1] == getPosition()[1] + 1) {
            hasMoved = true;
            return true;
        } return false;
    }
}
