
abstract class Employee {
    private String name;
    private int id;
    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public abstract void work();
}


class Developer extends Employee {
    private String programmingLanguage;

    public Developer(String name, int id, String programmingLanguage) {
        super(name, id); 
        this.programmingLanguage = programmingLanguage;
    }

    
    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(String programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }



    public void work() {
        System.out.println(this.getName() + " is writing code in " + programmingLanguage);
    }
}

class Manager extends Employee {
    public Manager(String name, int id) {
        super(name, id);
    }


    public void work() {
        System.out.println(this.getName() + " is managing the developers.");
    }
}

public class Oops {
    public static void main(String[] args) {
     
        Developer dev = new Developer("Aarti", 101, "Java");
        Manager mgr = new Manager("Yashvi", 102);
        
        Employee e2 = mgr;

        dev.work();
        e2.work(); 

        System.out.println(dev.getName() + " has ID " + dev.getId());
    }
}
