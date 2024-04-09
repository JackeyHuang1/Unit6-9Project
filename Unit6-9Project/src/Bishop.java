public class Bishop extends Piece{
    public Bishop(int[] position, String color, String name) {
        super(position, color, name);
    }

    public boolean isValidMove(int[] destination) {
        if (!super.isValidMove(destination)) {
            return false;
        }
        if (Math.abs(destination[0] - getPosition()[0]) >= 1 && Math.abs(destination[1] - getPosition()[1]) >= 1){
            if (Math.abs(destination[0]-getPosition()[0]) == Math.abs(destination[1] - getPosition()[1])) {
                return true;
            }

        } return false;
    }
}
