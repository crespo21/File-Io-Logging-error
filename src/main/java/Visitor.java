import java.io.*;
import java.time.LocalDate;
import  java.time.LocalTime;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class Visitor {
    private static final Logger logger = LogManager.getLogger(Visitor.class.getName());
    public static boolean saves(String fullName, int Age, String comments, String Assistant) throws IOException {
        FileWriter fileWriter = null;
        new File("visitor_ " +
                fullName.replace(" ", "_") + ".txt");
        File visitorFile;
        try {
            if (!fullName.isEmpty()) {
                //create a new file
                 visitorFile = new File("visitor_ " +
                        fullName.replace(" ", "_")+".txt");
                 //writing to a file
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
                    logger.debug("file already exist");
                }
            }
            else{
                logger.error("File not  created! because full name cannot be empty!");
            }
        }
        catch (IOException e) {
            logger.info(saves(fullName,Age,comments,Assistant));
            logger.error(saves(fullName,Age,comments,Assistant));
            System.out.println(" ");
            e.printStackTrace();
        }
        assert fileWriter != null;
        fileWriter.close();
        return true;
    }
    //search for a file
    public static File load(String fullName) {
        // load a file to read from using fullName
        File files = new  File("visitor_ " +
                fullName.replace(" ", "_")+".txt");
        // check if file is readable
        if (!files.exists()) {
            logger.error("File not Found :(");
        } else {
            System.out.println("File name: " + files.getName());
            System.out.println("Absolute path: " + files.getAbsoluteFile());
            System.out.println("Writeable: " + files.canWrite());
            System.out.println("Readable: " + files.canRead());
            System.out.println("File size in bytes: " + files.length());
        }
        return files;
    }
    public static void main(String[] args)  {
        try {
            System.out.println("* Umuzi Management Systems *");
            System.out.println(" ");
            int choice;
            char repeat;
            String input;
            Scanner select = new Scanner(System.in);

            do {
                //Menu options
                System.out.println("****************************");
                System.out.println("      Select your option    *");
                System.out.println("*       1. Save             *");
                System.out.println("*       2. Load             *");
                System.out.println("****************************");
                choice = select.nextInt();
                //switching cases save and load
                switch (choice) {
                    case 1:
                         Scanner input0 = new Scanner(System.in);
                           System.out.println("please enter your name: ");
                             String fullName = input0.nextLine();
                         Scanner input1 = new Scanner(System.in);
                           System.out.println("please enter your age");
                             int age = input1.nextInt();
                         Scanner input2 = new Scanner(System.in);
                           System.out.println("please enter your comments");
                             String comments = input2.nextLine();
                         Scanner input3 = new Scanner(System.in);
                           System.out.println("please enter your assistant name");
                             String assistant = input3.nextLine();
                   saves(fullName,age,comments, assistant);
                   break;
                   case 2:
                         Scanner inputLoad = new Scanner(System.in);
                           System.out.println("please enter your name: ");
                             fullName = inputLoad.nextLine();
                   load(fullName);
                    break;
                    default:
                        System.out.println("Invalid menu choice , try again.");
                        break;
                }
                System.out.println();
                System.out.println("Would you like to save or load visitor information again ?");
                System.out.println("Enter Y for yes or N for no :");
                input = select.next();
                repeat = input.charAt(0);
            }while (repeat == 'Y' || repeat == 'y');
        } catch (NullPointerException | IOException e){
            e.getMessage();
        }
    }
}

