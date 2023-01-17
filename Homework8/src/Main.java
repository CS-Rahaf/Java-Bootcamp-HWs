public class Main {
    public static void main(String[] args) {


        Shape shape =new Shape("Black", false);
        System.out.println(shape.toString());
        System.out.println("--------------------");

        Circle circle= new Circle(5);
        System.out.println(circle.toString() + "\n");
        System.out.println("Circle area= " + circle.getArea());
        System.out.println("Circle perimeter= " + circle.getPerimeter());
        System.out.println("--------------------");

        Rectangle rectangle=new Rectangle(5,4);
        System.out.println(rectangle.toString() + "\n");
        System.out.println("Rectangle area= " + rectangle.getArea());
        System.out.println("Rectangle perimeter= " + rectangle.getPerimeter());
        System.out.println("--------------------");

        Square square =new Square(5);
        square.setColor("Pink");
        System.out.println(square.toString() + "\n");
        System.out.println("Square area= " + square.getSide());
        System.out.println("Square perimeter= " + square.getPerimeter());
        

    }
}