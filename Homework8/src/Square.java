public class Square extends Rectangle{

    public Square() {
    }

    public Square(double side) {
        super(side, side);
    }

    public Square(String color, Boolean filled, double side) {
        super(color, filled, side, side);
    }

    public double getSide() {
        return super.getArea();
    }
    public void setSide(double side) {
       super.setWidth(side);
       super.setLength(side);
    }

    @Override
    public String toString() {
        return "A Square with side="
                + super.getWidth() +
                ", which is a subclass of \n"
                + super.toString();
    }
}
