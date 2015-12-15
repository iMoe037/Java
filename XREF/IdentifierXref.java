//Immad Mohamed
import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class IdentifierXref {
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------	
	public static void main(String[] args) throws java.io.IOException { 
		// A file is created with arguments, line numbers and a crossref. occurs than it terminates
		Scanner inputFile = new Scanner (new File (args[0] + ".java")); //file is taken as input
		BufferedWriter outputFile = new BufferedWriter(new FileWriter(args[args.length-1] + ".xref")); //.Xref is created with the same or different name
		Xref xref = new Xref(); //Creates a new Xref
		for (int lineNumber = 1; inputFile.hasNextLine(); lineNumber++) {
			String line = inputFile.nextLine();
			outputFile.write((String)(lineNumber + "   " + line)); //writes the line numbers
			outputFile.newLine();
			StringTokenizer words = new StringTokenizer(simplify(line)); //the line is simplified, and tokenized
			while (words.hasMoreTokens()) //tokens are sent to be added to the cross-reference
				xref.add(words.nextToken(), lineNumber);
		}
		xref.alphabetize(); //Alphabetical order
		xref.output(outputFile); //the output for the cross-reference is added to the writer
		outputFile.close(); //closes the file
	}
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

	private static String simplify(String line) { 
		line = deleteComments(line);
		line = deleteLiteralStrings(line);
		line = deleteCharacterConstants(line);
		line = deleteNumericConstants(line);
		return line;
	}
// This simplifies the line leaving just tokens, the keywords are removed in the xref
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

	private static String deleteNumericConstants(String line) {
		final int NOTID = 0; //switches state from not an identifier, or identifier and vice versa
		final int ID = NOTID + 1;
		String output = "";
		int state = NOTID; //Initial State is not an identifier
		for (int i = 0; i < line.length(); i++) {
			char c = line.charAt(i); //line is read by character
			if (!Character.isLetterOrDigit(c) && c != '$' && c != '_') //removes operators and punctuation
				c = ' ';
			switch (state) {
				case NOTID:	output += Character.isDigit(c)? " ": Character.toString(c); //if not an identifier, numbers are removed, and everything is outputed
							if (Character.isLetter(c) || c == '$' || c == '_') //if an identifier appears, the state is changed, nothing is outputed
								state = ID;
							break;
				case ID:	output += Character.toString(c); //all characters are outputed
							if (c == ' ') //when a blank is found, the state is changed to not an identifier, nothing output
								state = NOTID;
			}
		}
		return output; 
	}
// This method uses a machine in two states to remove punctuation operators and numeric constants.
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

	private static String deleteCharacterConstants(String line) {
		int i;
		while ((i = line.indexOf("\'")) > -1) { //finds by the ' delimiter
			line = line.substring(0, i) + " " + line.substring(i + 3); //The substring is 3 characters long
		}
		return line;
	}
// This method deletes Character Constants after the comments and literal strings have been removed.
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

	private static String deleteLiteralStrings(String line) {
		int i;
		while ((i = line.indexOf("\"")) > -1) { //finds by the " delimiter
			String start = line.substring(0, i); //the part of the line up to the string is here
			String end = line.substring(i + 1); //this is the rest of the line with the string
			line = start + " " + end.substring(end.indexOf("\"") + 1); //Concatenates before and after the string
		}
		return line;
	}
// This method deletes the literal Strings after the comments have been deleted.
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	private static String deleteComments(String line) {
		int i;
		while ((i = line.indexOf("/*")) > -1) { //the delimiter /* is found
			line = line.substring(0, i) + " " + line.substring(line.indexOf("*/")); // Deletes comments that start with /*
		}
		if ((i = line.indexOf("//")) > -1) //deletes these comments "//"
			line = line.substring(0, i);
		return line;
	}
// This method is the first step in the simplification process. It deletes comments.
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
}
