package Assignment.multithreading;
import java.io.File;
public class Threadprocessor implements Runnable {
    
    File obj;
    int taskid;
    public Threadprocessor(int taskid,String fileName){
        obj=new File(fileName);
        this.taskid=taskid;
    }
    
    public void run(){
        try{
            Thread.sleep(2000);
            String filename=obj.getName();
            System.out.println("Processing "+"task "+this.taskid+" "+ filename+ " " +Thread.currentThread().getName());
        }
        catch(InterruptedException e){
            System.out.println("Thread interrupted");
        }

    }
    
}
