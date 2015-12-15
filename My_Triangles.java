import javax.swing.JOptionPane;
public class My_Triangles
{
  public static void main(String[] paramArrayOfString)
  {
	  
    String x1 = JOptionPane.showInputDialog("What is the X value of the Point P?");//Asks user for the X value of point P
    String y1 = JOptionPane.showInputDialog("What is the Y value of the Point P?");//Asks user for the Y value of point P
    String x2 = JOptionPane.showInputDialog("What is the X value of the Point Q?");//Asks user for the X value of point Q
    String y2 = JOptionPane.showInputDialog("What is the Y value of the Point Q?");//Asks user for the Y value of point Q
    String x3 = JOptionPane.showInputDialog("What is the X value of the Point R?");//Asks user for the X value of point R
    String y3 = JOptionPane.showInputDialog("What is the Y value of the Point R?");//Asks user for the Y value of point R
    
    double xp = Double.parseDouble(x1);//Changes the X value of Point P to a Double.
    double yp = Double.parseDouble(y1);//Changes the Y value of Point P to a Double.
    double xq = Double.parseDouble(x2);//Changes the X value of Point Q to a Double.
    double yq = Double.parseDouble(y2);//Changes the Y value of Point Q to a Double.
    double xr = Double.parseDouble(x3);//Changes the X value of Point R to a Double.
    double yr = Double.parseDouble(y3);//Changes the Y value of Point R to a Double.
    
    double pq = (Math.pow((yq-yp),2)) + (Math.pow((xq-xp),2));//Used to determine exact equality of floating points.
    double pr = (Math.pow((yr-yp),2)) + (Math.pow((xr-xp),2));//Used to determine exact equality of floating points.
    double qr = (Math.pow((yr-yq),2)) + (Math.pow((xr-xq),2));//Used to determine exact equality of floating points.
    
    double pqsqrt = Math.sqrt((Math.pow((yq-yp),2)) + (Math.pow((xq-xp),2)));//Finds the length of side pq
    double prsqrt = Math.sqrt((Math.pow((yr-yp),2)) + (Math.pow((xr-xp),2)));//Finds the length of side pr
    double qrsqrt = Math.sqrt((Math.pow((yr-yq),2)) + (Math.pow((xr-xq),2)));//Finds the length of side qr
    
    double circum = pqsqrt+prsqrt+qrsqrt;//Finds the circumference of the triangle.
    double semiperimeter= Math.abs(circum) /2.0;//Finds the semiperimeter, so you can use it for the area.
    double area= Math.sqrt(((pqsqrt+prsqrt+qrsqrt)*(-pqsqrt+prsqrt+qrsqrt)*(pqsqrt-prsqrt+qrsqrt)*(pqsqrt+prsqrt-qrsqrt)/16));//Finds the Area of the Triangle
    
    
    	if ((xp*yq-xp*yr+xq*yr-xq*yp+xr*yp-xr*yq)==0) //Checks if the points are collinear.
    		
    		{
    	      JOptionPane.showMessageDialog(null, "Congratulations they are collinear"); // Prints this message to the user if it's collinear.
    	      
    	    }
    	
    	    else 
    	    	
    	    {
    	      JOptionPane.showMessageDialog(null, "I'm sorry but they are not collinear");//If it's not collinear it displays this message.
    	    }
    	
    	if ((Math.abs(Math.sqrt(pq)) - Math.pow(pq, 2) < .01))
    		{
    			JOptionPane.showMessageDialog(null, "The Length of side PQ is " + pqsqrt);
    		}
    	
    	else
    		{
    			JOptionPane.showMessageDialog(null, "Calculation Error");
    		}
    	
    	if ((Math.abs(Math.sqrt(pr)) - Math.pow(pr, 2) < .01))
    		{
    			JOptionPane.showMessageDialog(null, "The Length of side PR is " + prsqrt);
    		}
    	
    	else
    		{
    			JOptionPane.showMessageDialog(null, "Calculation Error");
    		}
    	
    	if ((Math.abs(Math.sqrt(qr)) - Math.pow(qr, 2) < .01))
    		{
    			JOptionPane.showMessageDialog(null, "The Length of side QR is "+ qrsqrt);
    		}
    	
    	else
    		{
    			JOptionPane.showMessageDialog(null, "Calculation Error");
    		}
    	
    	JOptionPane.showMessageDialog(null, "The circumference of the triangle is " + circum);
    	JOptionPane.showMessageDialog(null, "The area of the triangle is " + area);

    System.exit(0);
  }
}
