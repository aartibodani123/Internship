package Assignment.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SimpleExecutor {
    public static void main(String []args){
        long startTime = System.currentTimeMillis();

        ExecutorService es = Executors.newFixedThreadPool(3);
        String[] files={"File1.txt","File2.txt","File3.txt","File4.txt","File5.txt","File6.txt","File7.txt","File8.txt","File9.txt","File10.txt"};
        for(int i=0;i<files.length;i++){
            es.execute(new Threadprocessor(i+1,files[i]));
        }
        es.shutdown();
        try {
            es.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            System.out.println("Execution interrupted");
        }
        System.out.println("All file processed");
        long endtime= System.currentTimeMillis();
        System.out.println("Total time taken " +(endtime-startTime)+" ms");
    }
    
}
