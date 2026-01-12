
class MyThread implements Runnable{
    
  	// Method to start Thread
    public void run(){
        
      	String str = "Thread is Running Successfully";
        System.out.println(str);
    }

}

public class Threading{
    
    public static void main(String[] args){
        
        MyThread g1 = new MyThread();
      
        // initializing Thread Object
        Thread t1 = new Thread(g1);
        
      	// Running Thread
      	t1.start();
    }
}