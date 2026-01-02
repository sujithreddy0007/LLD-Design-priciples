package KISS;
class EvenChecker {
    public boolean isEven(int n) {
        return n % 2 == 0;
    }
}

public class Client {
    public static void main(String[] args) {
        EvenChecker evenChecker = new EvenChecker();
        System.out.println(evenChecker.isEven(4)); // true
        System.out.println(evenChecker.isEven(7)); // false
    }
}
