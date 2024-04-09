public class Rook extends Piece{
    private boolean hasNotMoved;
    public Rook(int[] position, String color, String name) {
        super(position, color, name);
        hasNotMoved = false;
    }

    public boolean hasNotMoved() {
        return hasNotMoved;
    }

    public boolean isValidMove(int[] destination) {
        if (!super.isValidMove(destination)) {
            return false;
        }
        if (Math.abs(destination[0] - getPosition()[0]) >= 1 || Math.abs(destination[1] - getPosition()[1]) >= 1){
            if (destination[0] - getPosition()[0] == 0 || destination[1] - getPosition()[1]== 0) {
                hasNotMoved = true;
                return true;
            }
        } return false;
    }
}
