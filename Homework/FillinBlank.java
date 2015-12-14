import javax.swing.JOptionPane;

/**
   
   Homework 5 By: Immad Mohamed
*/

public class FillinBlank
{
   private String ques;
   private String tans; 
   
   
   public FillinBlank(String q, String a)
   {
	ques = q;
	tans = a;
	}
   public FillinBlank() {
	   ques = "";
	   tans = "";
}


   public void setQuestion(String q)
   {
      ques = q;
   }

   /**
      Sets The Question
   */

   public void setans(String a)
   {
      tans = a;
   }

   /**
      Sets True Answer
   */

   public String getQuestion()
   {
      return ques;
   }

   /**
      Gets The Question
   */
   
   public String getans()
   {
      return tans;
   }
   
   public boolean attemp (String gans)
   {
	   	if(gans.equals(tans))
	   		return true;
	   		JOptionPane.showMessageDialog(null,"That's Correct Good Job!");
	   		else
	   		return false;
	   		JOptionPane.showMessageDialog(null,"I'm Sorry but that's incorrect!");
	   		
	/**
      Checks if the Given Answer is the same as the True Answer
   */
   }

   }
    
   

