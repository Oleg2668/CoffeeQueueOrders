package coffee.order;

public class Main {
    public static void main(String[] args) {
        CoffeeOrderBoard board = new CoffeeOrderBoard();

        board.add("Alice");
        board.add("Bob");
        board.add("Charlie");

        board.draw();
        board.deliver();
        board.draw();
        board.deliver(2);
        board.draw();
    }
}