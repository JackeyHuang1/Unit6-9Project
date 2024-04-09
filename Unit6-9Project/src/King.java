public class King extends Piece {
    private boolean hasCastled;
    public King(int[] position, String color, String name) {
        super(position, color, name);
        hasCastled = false;
    }

    public boolean isValidMove(int[] destination) {
        System.out.println(destination[0] + " " + destination[1]);
        if (!super.isValidMove(destination)) {
            return false;
        }
        if (destination[0] - getPosition()[0] <= 1 && destination[1] - getPosition()[1] <= 1) {
            return true;
        }
        if (destination[1] - getPosition()[1] == 2) {
            if (Board.getBoard()[destination[0]][destination[1]].getColor().equals("none")) {
                if (Board.getBoard()[destination[0]][destination[1] - 1].getColor().equals("none") &&
                        (Board.getBoard()[destination[0]][destination[1] + 1] instanceof Rook &&
                                ((Rook) Board.getBoard()[destination[0]][destination[1] + 1]).hasNotMoved())) {
                    Board.getBoard()[destination[0]][destination[1] + 1].updatePosition(new int[] {destination[0], destination[1] - 1});
                    return true;
                }
            }
            return false;
        } if (getPosition()[1] - destination[1] == 2) {
            if (Board.getBoard()[destination[0]][destination[1]].getColor().equals("none")) {
                if (Board.getBoard()[destination[0]][destination[1] + 1].getColor().equals("none") &&
                        (Board.getBoard()[destination[0]][destination[1] - 2] instanceof Rook &&
                                ((Rook) Board.getBoard()[destination[0]][destination[1] - 2]).hasNotMoved())) {
                    Board.getBoard()[destination[0]][destination[1] + 1].updatePosition(new int[] {destination[0], destination[1] + 1});
                    return true;
                }
            }
        }
        return false;
    }
}
