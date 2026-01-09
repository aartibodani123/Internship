
class Person {

    public String name;         
    protected int age;           
    int id;                      
    private String aadhaar;     

  
    static int population = 0;

    final String nationality = "Indian";

   
    Person(String name, int age, int id, String aadhaar) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.aadhaar = aadhaar;
        population++;
    }


    public void showName() {
        System.out.println("Name: " + name);
    }

  
    protected void showAge() {
        System.out.println("Age: " + age);
    }

    void showId() {
        System.out.println("ID: " + id);
    }

    
    private void showAadhaar() {
        System.out.println("Aadhaar: " + aadhaar);
    }


    final void showNationality() {
        System.out.println("Nationality: " + nationality);
    }


    static void showPopulation() {
        System.out.println("Population: " + population);
    }
}


class Student extends Person {

    Student(String name, int age, int id, String aadhaar) {
        super(name, age, id, aadhaar);
    }

    void accessTest() {
        System.out.println(name); // public hence can be used      
        System.out.println(age);  //protected (same package allowed) hence can be used   
        System.out.println(id);   //default(package private that means can used in same package) hence can be used  
     //adhaar cant be used as its private 
     // population can be used 
     // nationailty can be used but not changed as it is final
     //showNationality() CANNOT be overridden as its final
    }


}


final class Utility {

    static final int MAX_MARKS = 100;

    static void showMax() {
        System.out.println("Max Marks: " + MAX_MARKS);
    }
}


public class Demo {

    public static void main(String[] args) {

       
        Student s = new Student("Aarti", 22, 101, "1234-5678");

       
        s.showName();          
        s.showAge();           
        s.showId();           
        s.showNationality();   

   
        Person.showPopulation();

        Utility.showMax();
        System.out.println(Utility.MAX_MARKS);

      
        final Student s2 = new Student("Ravi", 23, 102, "9999");
        s2.name = "Ravi Kumar";  
  
    }
}

