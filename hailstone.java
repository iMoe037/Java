import javax.swing.JOptionPane;

public class hailstone
{
   public static void main(String[] args)
   {
	int n = 0;
	String str;
	str = JOptionPane.showInputDialog("Enter an Integer:");
	n = Integer.parseInt(str);
	System.out.print(n + " ");
	while (n != 1) {
		if(n%2 == 0)
			n=n/2;
		else
			n= 3*n +1;
		System.out.print(n + " ");
	} while (n !=1);
		System.out.print(" ");
	JOptionPane.showMessageDialog(null, "You are out of the Loop! ");
	System.exit(0);
   }
}
