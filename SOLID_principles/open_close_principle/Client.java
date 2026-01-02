package SOLID_principles.open_close_principle;

interface Shape {
    double calculateArea();
}

class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle implements Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return width * height;
    }
}

class Triangle implements Shape {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }
}

public class Client {
    public static void main(String[] args) {
        Shape circle = new Circle(5.5);
        Shape rect = new Rectangle(7.2,9.4);
        Shape tri = new Triangle(5.5,5.5);
        double r1 = circle.calculateArea();
        double r2 = rect.calculateArea();
        double r3 = tri.calculateArea();
        System.out.println(r1+" "+r2+" "+r3);
    
    }
}
