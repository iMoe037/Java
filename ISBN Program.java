// This is a simple Java program.

public class ISBN Program

{
   public static void main(String[] args)
   {	
	int a= 0;
	int b= 1;
	int c= 3;
	int d= 6;
	int e= 0;
	int f= 8;	
	int g= 0;	
	int h= 2;
	int i= 0;
	int j= 0;
	int t= 10*a + 9*b + 8*c + 7*d + 6*e + 5*f + 4*g +3*h + 2*i + j;
	int s= t%11;
      System.out.println("ISBN mod 11=" + s);
   }
}
