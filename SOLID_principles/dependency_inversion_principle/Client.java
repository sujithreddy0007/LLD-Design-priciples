package SOLID_principles.dependency_inversion_principle;
interface InventoryService {
    void updateStock(Order order);
    boolean checkAvailability(Product product);
}
 interface LoggingService {
    void logMessage(String message);
    void logError(String error);
}
 interface NotificationService {
    void sendNotification(String message);
}
class Product {
}

class Order {
    private int id;
    private Product product;

    public int getId(){
        return id;
    }

    public Product getProduct() {
        return product;
    }
}

class EmailNotifier implements NotificationService {
    @Override
    public void sendNotification(String message) {
        // Email specific implementation
    }
}   

class PushNotifier implements NotificationService {
    @Override
    public void sendNotification(String message) {
        // Push notification specific implementation
    }
}
class SMSNotifier implements NotificationService {
    @Override
    public void sendNotification(String message) {
        // SMS specific implementation
    }
}
class DatabaseLogger implements LoggingService {
    @Override
    public void logMessage(String message) {
        // Database logging implementation
    }

    @Override
    public void logError(String error) {
        // Error logging implementation
    }
}
class WarehouseInventoryService implements InventoryService {
    @Override
    public void updateStock(Order order) {

    }

    @Override
    public boolean checkAvailability(Product product) {
        return false;
    }
}

 class OrderService {
    private final NotificationService notificationService;
    private final LoggingService loggingService;
    private final InventoryService inventoryService;
    // Constructor injection of dependencies
    public OrderService(NotificationService notificationService,
                        LoggingService loggingService, InventoryService inventoryService) {
        this.notificationService = notificationService;
        this.loggingService = loggingService;
        this.inventoryService = inventoryService;
    }

    public void placeOrder(Order order) {
        try {
            // Check inventory
            if (inventoryService.checkAvailability(order.getProduct())) {
                // Process order
                inventoryService.updateStock(order);
                // Send notification
                notificationService.sendNotification(
                        "Order #" + order.getId() + " placed successfully");
                // Log success
                loggingService.logMessage(
                        "Order processed successfully: " + order.getId());
            }
        } catch (Exception e) {
            loggingService.logError(
                    "Error processing order: " + order.getId() + " - " + e.getMessage());
            throw e;
        }
    }
}
public class Client {
    public static void main(String[] args) {
         // Usage with dependency injection
        NotificationService emailNotifier = new EmailNotifier();
        LoggingService logger = new DatabaseLogger();
        InventoryService inventory = new WarehouseInventoryService();
        OrderService orderService = new OrderService(emailNotifier, logger, inventory);
    }
}
