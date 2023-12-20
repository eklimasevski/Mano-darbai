public class Apartment {
    private int rooms;
    private int squares;
    private int pricePerSquare;

//    private int totalPrice = pricePerSquare * squares;

    public Apartment(int rooms, int squares, int pricePerSquare) {
        this.rooms = rooms;
        this.squares = squares;
        this.pricePerSquare = pricePerSquare;
    }

    public int totalPrice() {
        int multiply = pricePerSquare * squares;
        return multiply;
    }

    public boolean largerThan(Apartment compared) {
        if (squares > compared.squares) {
            return true;
        }
        return false;
    }

    public int priceDifference(Apartment compared) {
        int priceCompared = compared.pricePerSquare * compared.squares;
        int difference = Math.abs(priceCompared - totalPrice());

        return difference;
    }

    public boolean moreExpensiveThan(Apartment compared) {
        int priceCompared = compared.pricePerSquare * compared.squares;
        if (priceCompared < totalPrice()) {
            return true;
        }
        return false;
    }

}