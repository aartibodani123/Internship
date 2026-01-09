package Assignment.FoodApp.UserApp;

public abstract class User {

    protected long id;
    protected String name;
    protected String phone;

    public User(long id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }
}
