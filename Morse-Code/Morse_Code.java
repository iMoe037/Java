//Immad Mohamed
//Assignment 2
import javax.swing.JOptionPane;
public class Morse_Code {

	public static void main(String[] args) {

		String [] Letters ={"b" , ".-b","-...b","-.-.b","-..b",".b","..-.b","--.b","....b","..b",".---b","-.-b",".-..b",
				"--b","-.b","---b",".--.b","--.-b",".-.b","...b","-b","..-b","...-b",".--b","-..-b","-.--b","--..b","","Terminating Good Bye!"};// Characters " ",A - Z in Morse code

		int place = 0;
		while (place!=28) {
			String text ="";
			String str = JOptionPane.showInputDialog("Please enter a phrase. (A '$' entered anywhere will terminate the program)").toLowerCase();// User inputs a string that is converted to lower case for ASCII

			
			char[] Array = str.toCharArray();// Stores the string into a char array.
			for(int i = 0, n = str.length() ; i < n ; i++) // Loops for char array 
			{ 
				char ASCII= Array[i];
				place = (ASCII -96);// Subtract the lowercase ASCII letters -96 to get the value in the "letters" array.
				
				if (place==-64)// 64 is a " " in ASCII, in letters it is defined by array 0
					place += 64;
		
				if (place!=-60&&place<0||place>28)//-60=$ in ASCII if place is anything but an alphabetic character it is assigned nothing.
					place=27;
				
				if (place==-60)// -60=$ so 88 is added to make it view the termination message.
					place+=88;

				text+=Letters[place];// string text is assigned all the morse code values.


			}
			JOptionPane.showMessageDialog(null,text);// prints the morse code.
			
		}
	}
}

