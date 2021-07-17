package lesson1.GeometricShapes;

public class Circle implements GeometricShape{

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI*(Math.pow(radius,2));
    }

    @Override
    public double perimeter() {
        return 2*Math.PI*radius;
    }

    @Override
    public void printArea() {
        System.out.println("Area this CIRCLE = " + area());
    }

    @Override
    public void printPerimeter() {
        System.out.println("Perimeter this CIRCLE = " + perimeter());
    }

    @Override
    public String toString() {
        return "Circle {" +
                "radius=" + radius +
                '}';
    }
}
