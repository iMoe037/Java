import java.util.Scanner; // Needed for the Scanner class
import java.io.*;         // Needed for the File class


//This program reads data from a file. Using while loop to read files


public class Crypt
{
   public static void main(String[] args) throws IOException
   {
      // Create a Scanner object for keyboard input.
      Scanner keyboard = new Scanner(System.in);

      // Get the filename.
      System.out.print("Enter the filename: ");
      String filename = keyboard.nextLine();

      // Open the file.
      File file = new File(filename);
      Scanner inputFile = new Scanner(file);
	  String line;
	  int nl = 0;
	  int Qp = 0;
	  int Tn;
	  int s3 =0;
      // Read lines from the file until no more are left.
      while (inputFile.hasNext())
      {
		if ((nl % 3) == 0 && s3 !=0) {
			 System.out.print((char)s3);
			s3 =0;
		}
		nl++;
         // Read the next name.
         line = inputFile.nextLine();
		 Qp = Integer.parseInt(line);
		 Tn = (Qp * (Qp + 1))/2;
		 s3 = s3 + Tn;
         // Display the last name read.
         
      }
	  System.out.println((char)s3);
      // Close the file.
      inputFile.close();
   }
}
