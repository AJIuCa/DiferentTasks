package lesson1.GeometricShapes;

public class Main {
    public static void main(String[] args) {
        GeometricShape geometricShape1 = new Circle(23);
        GeometricShape geometricShape2 = new Triangle(4.0,5.0,6.4);
        GeometricShape geometricShape3 = new Square(5);

        System.out.println(geometricShape1.toString());
        geometricShape1.printArea();
        geometricShape1.printPerimeter();
        System.out.println("");

        System.out.println(geometricShape2.toString());
        geometricShape2.toString();
        geometricShape2.printArea();
        geometricShape2.printPerimeter();
        System.out.println("");

        System.out.println(geometricShape3.toString());
        geometricShape3.toString();
        geometricShape3.printArea();
        geometricShape3.printPerimeter();
        System.out.println("");
    }
}
