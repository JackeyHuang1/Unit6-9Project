public class King extends Piece {
    private boolean hasCastled;
    public King(int[] position, String color, String name) {
        super(position, color, name);
        hasCastled = false;
    }

//    public boolean move(Piece other) {
//
//    }
}
