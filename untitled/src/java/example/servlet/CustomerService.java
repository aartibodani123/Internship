package java.example.servlet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerService {
    private static Map<Integer, Customer> db = new HashMap<>();
    private static int idCounter = 1;

    public Customer create(String name, String email) {
        Customer c = new Customer(idCounter++, name, email);
        db.put(c.getId(), c);
        return c;
    }

    public Customer getById(int id) {
        return db.get(id);
    }

    public List<Customer> getAll() {
        return new ArrayList<>(db.values());
    }

    public Customer update(int id, String name, String email) {
        Customer c = db.get(id);
        if (c == null) return null;
        c.setName(name);
        c.setEmail(email);
        return c;
    }

    public boolean delete(int id) {
        return db.remove(id) != null;
    }
}
