package DRY;

class UserValidator {

    static void validateName(String name) {
        if (name == null || name.length() < 3) {
            throw new IllegalArgumentException("Invalid user");
        }
    }
}


class UserService {

    public void createUser(String name) {
        UserValidator.validateName(name);
        System.out.println("User created: " + name);
    }

    public void updateUser(String name) {
        UserValidator.validateName(name);
        System.out.println("User updated: " + name);
    }
}


public class Client {
    public static void main(String[] args) {

        UserService userService = new UserService();

        // Valid cases
        userService.createUser("Sai");
        userService.updateUser("Reddy");

        // Invalid cases (will throw exception)
        try {
            userService.createUser("ab");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            userService.updateUser(null);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
