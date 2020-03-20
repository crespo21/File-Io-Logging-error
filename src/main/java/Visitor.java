import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import  java.time.LocalTime;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Visitor {

    private static String fullName;
    private static int Age;
    private static String comments;
    private static String Assistant = "Tshepo";

    private static final Logger logger = LogManager.getLogger(Visitor.class.getName());
    public static boolean saves(String fullName, int Age, String comments, String Assistant) throws IOException {

        FileWriter fileWriter = null;
        boolean checker = false;
         try {
             if (fullName.isEmpty()) {

                checker = true;
                File visitorFile = new File("visitor_ " +
                        fullName.replace(" ", "_")+".txt");
                
                if (visitorFile.createNewFile()) {
                     fileWriter = new FileWriter(visitorFile);
                     fileWriter.write("Full name: " + fullName + "\n" +
                       "Age: " + Age+ " years old"+ "\n" +
                       "Date of visit: " + LocalDate.now() + "\n" +
                       "Time of visit: " + LocalTime.now() + "\n" + "Comments: " + comments + "\n" +
                       "Assistant: " + Assistant);
                     String msg = "Recruit's file successfully created!";
                    logger.info((msg));
                }
                else{
                     logger.error("file already exist");
                }

            }
            else{
                checker = false;
                logger.error("File not  created! because full name cannot be empty!");
            }
         }
         catch (IOException e) {
             logger.info(saves(fullName,Age,comments,Assistant));
                logger.error(saves(fullName,Age,comments,Assistant));
             System.out.println(" ");
                e.printStackTrace();
         }
         fileWriter.close();

        return checker;

    }
    public static String load(String fullName){
        try{
            File visitorFile = new File("visitor_ " +
                    fullName.replace(" ", "_")+".txt");
            Scanner reader = new Scanner(visitorFile);
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                System.out.println(data);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            logger.error("File not Found :(");
            e.getStackTrace();

        }
        return fullName;
    }
        public static void main(String[] args)  {
        try {
            System.out.println("Welcome to Umuzi's VisInfoCap");
            System.out.println(" ");

            Scanner input = new Scanner(System.in);
            System.out.println("please enter your name: ");
            fullName = input.nextLine();
            Scanner input1 = new Scanner(System.in);
            System.out.println("please enter your age");
            Age = input1.nextInt();
            Scanner input2 = new Scanner(System.in);

            System.out.println("please enter your comments");
            comments = input2.nextLine();
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            logger.error(saves(fullName, Age, comments, Assistant));
            Visitor vst = new Visitor();
            vst.load(fullName);
            System.out.println(" ");
            System.out.println(("This file belong's to " + fullName));
        } catch (NullPointerException | IOException e){
            e.getMessage();

        }

    }

}
