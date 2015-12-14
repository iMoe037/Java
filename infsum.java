import javax.swing.JOptionPane;

public class infsum
{
   public static void main(String[] args)
   {
	int n = 0;
	String str;
	str = JOptionPane.showInputDialog("Enter an Integer:");
	n = Integer.parseInt(str);
	
	double ans= 0;
	for (int i = 1;i<= n; i++) {
		ans = ans + Math.pow((1/3),i);
		System.out.println(i + " " + ans + " ");
	}
	double ans2 = 1/(1-(1/3));
		if ((ans - ans2) < 0.000001)
		JOptionPane.showMessageDialog(null, "Gauss was Right!");
		else
		JOptionPane.showMessageDialog(null, "Gauss was Wrong!");
		
		System.out.print(ans + " ");
	
	System.exit(0);
   }
}
