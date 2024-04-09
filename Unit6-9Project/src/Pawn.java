public class Pawn extends Piece{
    public Pawn(int[] position, String color, String name) {
        super(position, color, name);
    }

    public boolean isValidMove(int[] destination) {
        System.out.println(getPosition()[0] + " " + getPosition()[1]);
        if (!super.isValidMove(destination)) {
            return false;
        }
        if (destination[0] == getPosition()[0] -1) {
            return true;
        }
        return false;
    }
}
