public class Knight extends Piece{
    public Knight(int[] position, String color, String name) {
        super(position, color, name);
    }

    public boolean isValidMove(int[] destination) {
        System.out.println(getPosition()[0] + "," + getPosition()[1]);
        if (destination[0] == getPosition()[0] + 1 || destination[0] == getPosition()[0] -1) {
            if (destination[1] == getPosition()[1] - 2 || destination[0] == getPosition()[1] + 2) {
                return true;
            }
        } return false;
    }
}
