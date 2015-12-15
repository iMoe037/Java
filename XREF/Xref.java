//Immad Mohamed
import java.io.BufferedWriter;
import java.io.IOException;

public class Xref {
	//This is where tokens are passed, checked against keywords, alphabetized, and written to file

	final int MAX_IDs = 1000; //the maximum amount of identifiers
	String[] ids = new String [MAX_IDs]; //Array where strings of the Xref are stored
	int counter; //this is a counter to make sure the lines are incremented correctly
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	public void alphabetize() {
		int n = counter;
		while (n > 0) {
			int alpha = 0;
			for (int i = 1; i < counter; i++) {
				if ((ids[i-1].compareToIgnoreCase(ids[i])) > -1) {
					String temp = ids[i-1];
					ids[i-1] = ids[i];
					ids[i] = temp;
					alpha = i;
				}
			}
			n = alpha;	
		}
	}
// Bubble sort that puts everything in alphabetical order
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	public void output(BufferedWriter outputFile) throws IOException {
		
		outputFile.newLine(); //space
		for (int i = 0; i < counter; i++) { //writes the code line by line
			outputFile.write(ids[i]);
			outputFile.newLine();
		}
	}
// this outputs the newly created and sorted cross-reference listings to file
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	public void add(String token, int lineNumber) { //Checks the token against the listed keywords
		String[] javaReservedWord={"abstract","assert","boolean","break","byte","case","catch","char","class","const","continue",
				"default","do","double","else","enum","extends","false","final","finally","float","for",
				"goto","if","implements","import","instanceof","int","interface","long","native","new","null",
				"package","private","protected","public","return","short","static","strictfp","super","switch","synchronized",
				"this","throw","throws","transient","true","try","void","volatile","while"};
		int i;
		for (i = 0; i < javaReservedWord.length; i++)
			if (token.equals(javaReservedWord[i]))
				return; //does not add anything to the listing

		for (int j = 0; j < MAX_IDs; j++) //checks if the token already exists
			if (ids[j] != null && (ids[j].substring(0, ids[j].indexOf(" - ")).equals(token))) { //checks to see if a value exists that matches the token before the " - " delimiter
				String tester = ids[j].substring(ids[j].indexOf(" - ") + 3); //uses substring to check the line number
				if (tester.startsWith(Integer.toString(lineNumber))) //if it's the first number after the token, it doesn't add anything
					return;
				int k;
				while ((k = tester.indexOf(" , ")) > -1) { //checking all identical numbers, delimited by a comma
					if (tester.substring(k+3).startsWith(Integer.toString(lineNumber))) //if the number exists, nothing is added
						return;
					tester = tester.substring(k+3); //It creates a new substring without the last comma delimiter
				}
				ids[j] = ids[j] + " , " + lineNumber; //If the number is not listed, it is added to the string
				return; //and returned
			}
		ids[counter] = token + " - " + lineNumber; //If the token does not exist, it is added, along with the line number
		counter++; //the counter is incremented to the next element in the array only after a new token is added
	}
}
