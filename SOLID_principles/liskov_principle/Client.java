package SOLID_principles.liskov_principle;

interface Shape {
    int getArea();
}
class Rectangle implements Shape {
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getArea() {
        return width * height;
    }
}
class Square implements Shape {
    private int side;

    public Square(int side) {
        this.side = side;
    }

    public int getArea() {
        return side * side;
    }
}


public class Client {
    public static void main(String[] args) {
        Shape r = new Rectangle(5, 10);
        Shape s = new Square(5);

        System.out.println(r.getArea()); // 50
        System.out.println(s.getArea()); // 25
    }
}
