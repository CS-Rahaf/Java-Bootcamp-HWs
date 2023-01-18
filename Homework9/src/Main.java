public class Main {
    public static void main(String[] args) {

        Book book = new Book("Atomic Habits",100, "James Clear");

        System.out.println("Book's name: " + book.getName());
        System.out.println("Book's price: " + book.getPrice());
        System.out.println("Book's author: " + book.getAuthor());
        System.out.println("Book's price after applying 20% discount: " + book.getDiscount());

        System.out.println("-----------------------");

        Movie movie = new Movie("Cruella", 50, "Craig Gillespie");
        System.out.println("Movie's name: " + movie.getName());
        System.out.println("Movie's price: " + movie.getPrice() + " SAR");
        System.out.println("Movie's director: " + movie.getDirector());
        System.out.println("Movie's price after applying 10% discount: " + movie.getDiscount() + " SAR");

        System.out.println("-----------------------");

        MovablePoint movablePoint = new MovablePoint(20,50,10,30);
        System.out.println(movablePoint.toString());
        movablePoint.moveUp();
        movablePoint.moveLeft();
        System.out.println("MovablePoint object details after calling 'moveUp and moveLeft methods' : \n" + movablePoint.toString());

    }
}