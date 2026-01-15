package Assignment.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SimpleExecutor {
    public static void main(String []args){
        long startTime = System.currentTimeMillis();

        ExecutorService es = Executors.newFixedThreadPool(3);
        String[] files={
            "Assignment/multithreading/File1.txt",
                        "Assignment/multithreading/File2.txt",
                        "Assignment/multithreading/File3.txt",
                        "Assignment/multithreading/File4.txt",
                        "Assignment/multithreading/File5.txt",
                        "Assignment/multithreading/File6.txt",
                        "Assignment/multithreading/File7.txt",
                        "Assignment/multithreading/File8.txt",
                        "Assignment/multithreading/File9.txt",
                        "Assignment/multithreading/File10.txt"};
        for(int i=0;i<files.length;i++){
            es.execute(new Threadprocessor(i+1,files[i]));
        }
        
        try {
            es.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            System.out.println("Execution interrupted");
        }
        es.shutdown();
        System.out.println("All file processed");
        long endtime= System.currentTimeMillis();
        System.out.println("Total time taken " +(endtime-startTime)+" ms");
    }
    
}
