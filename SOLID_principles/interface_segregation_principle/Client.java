package SOLID_principles.interface_segregation_principle;

interface Workable {
    void work();
}

interface Eatable {
    void eat();
}
class HumanWorker implements Workable, Eatable {

    public void work() {
        System.out.println("Human is working");
    }

    public void eat() {
        System.out.println("Human is eating");
    }
}
class RobotWorker implements Workable {

    public void work() {
        System.out.println("Robot is working");
    }
}

public class Client {
     public static void main(String[] args) {

        Workable human = new HumanWorker();
        Workable robot = new RobotWorker();

        human.work();
        robot.work();

        Eatable eater = new HumanWorker();
        eater.eat();
    }
}
