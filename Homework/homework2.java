import javax.swing.JOptionPane;
//Immad was here!
public class homework2
{
  public static void main(String[] paramArrayOfString)
  {
      
    int i = 0;
    String str = JOptionPane.showInputDialog("// Marks the Begining of a _________");
    if (str.equalsIgnoreCase("comment")) 
	{
      JOptionPane.showMessageDialog(null, "That's Correct Good Job!");
      i = 100;
    }
    else {
      JOptionPane.showMessageDialog(null, "I'm Sorry but the answer you provided was " +
                                	  "incorrect. Please refer to page 31!");
      i = 0;
    }

    str = JOptionPane.showInputDialog("The showInputDialog method always returns " +
	                                  "the users input as _________");
    if (str.equalsIgnoreCase("string")) {
      JOptionPane.showMessageDialog(null, "That's correct Keep Going!");
      i += 20;
    }
    else {
      JOptionPane.showMessageDialog(null, "I'm sorry but that answer is incorrect " +
                                      	  "please refer to page 95 & 96");
      i += 0;
    }

    str = JOptionPane.showInputDialog("Which operator connects two boolean " +
                                    	"expressions into one when both expressions are " +
	                                   "true which make the overall expression true?");
    if (str.equalsIgnoreCase("&&")) {
      JOptionPane.showMessageDialog(null, "That's Right 3 questions down 2 to go!");
      i += 20;
    }
    else {
      JOptionPane.showMessageDialog(null, "Sorry please refer to the chart on page 135");
      i += 0;
    }

    str = JOptionPane.showInputDialog("True or False The scope of a variable is " + 
	                                   "limited to the block in which it is declared.");
    if (str.equalsIgnoreCase("True")) {
      JOptionPane.showMessageDialog(null, "Correct 4 and of 5 Almost Done!");
      i += 20;
    }
    else {
      JOptionPane.showMessageDialog(null, "I'm sorry but please refer to the textbook ");
      i += 0;
    }

    str = JOptionPane.showInputDialog("True or false The println method allows you " +
                                     	"to format output in a variety of ways!");
    if (str.equalsIgnoreCase("False")) {
      JOptionPane.showMessageDialog(null, "Correct and That Concludes our test!");
      i += 20;
    }
    else {
      JOptionPane.showMessageDialog(null, "Sorry please refer to page 164 but at " +
                                   	  "least you finished!");
      i += 0;
    }
    JOptionPane.showMessageDialog(null, "Your score is " + i + ".");
    System.exit(0);
  }
}
