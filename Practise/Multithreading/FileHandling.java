package Multithreading;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class FileHandling{
    public static void main (String []args){
        File obj=new File("Practise/Multithreading/firstFile.txt");
        System.out.println("File created");
        try{
            FileWriter writer=new FileWriter(obj);
            writer.write("Working with files in java is amzaing");
            writer.close();
            System.out.println("Done");
            Scanner Reader = new Scanner(obj);
          
            // Traversing File Data
          	while (Reader.hasNextLine()) {
                String data = Reader.nextLine();
                System.out.println(data);
            }
        }catch(IOException e){
            System.out.println("Error occured"+e);

        }

    }
}