package lesson1.GeometricShapes;

public class Square implements GeometricShape{

    private double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double area() {
        return side*side;
    }

    @Override
    public double perimeter() {
        return 4*side;
    }

    @Override
    public void printArea() {
        System.out.println("Area this SQUARE = " + area());
    }

    @Override
    public void printPerimeter() {
        System.out.println("Perimeter this SQUARE = " + perimeter());
    }

    @Override
    public String toString() {
        return "Square {" +
                "side=" + side +
                '}';
    }
}
