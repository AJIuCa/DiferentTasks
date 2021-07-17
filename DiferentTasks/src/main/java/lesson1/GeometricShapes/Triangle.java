package lesson1.GeometricShapes;

public class Triangle implements  GeometricShape{

    private double side1;
    private double side2;
    private double side3;

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    @Override
    public double area() {
        double halfPerimeter = perimeter()/2;
        return Math.sqrt(halfPerimeter*(halfPerimeter-side1)*(halfPerimeter-side2)*(halfPerimeter-side3));
    }

    @Override
    public double perimeter() {
        return side1+side2+side3;
    }

    @Override
    public void printArea() {
        System.out.println("Area this TRIANGLE = " + area());
    }

    @Override
    public void printPerimeter() {
        System.out.println("Perimeter this TRIANGLE = " + perimeter());
    }

    @Override
    public String toString() {
        return "Triangle {" +
                "side1=" + side1 +
                ", side2=" + side2 +
                ", side3=" + side3 +
                '}';
    }
}
