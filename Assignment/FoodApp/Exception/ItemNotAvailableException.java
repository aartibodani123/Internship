package Assignment.FoodApp.Exception;

public class ItemNotAvailableException extends RuntimeException {

    public ItemNotAvailableException(String message) {
        super(message);
    }
}

