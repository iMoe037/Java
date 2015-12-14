
public class mymath
	{
		public static int myadd (int a, int b)
		{
			int ans;
			boolean outofbound = false;
			if (outofbound) {
				
				ans = -1;
			}
			else
				ans = a + b;
			
			return ans;
		}
		public static int mymultiply (int a, int b)
		{
			int ans;
			boolean outofbound = false;
			if (outofbound) {
				System.out.println("out of bound");
				ans = -1;
			}
			else
				ans = a * b;
			
			return ans;
		}
		public static double mydiv (double a, double b)
		{
			double ans;
			ans = a / b;
			return ans;	
			
		}
		public static int mymod (int a, int b)
		{
			int ans;
			ans = a % b;	
			return ans;
		}
		public static boolean isPrime(int n) {
		    for(int i=2;i<n;i++) {
		        if(n%i==0)
		            return false;
		    }
		    return true;
		}
		public static int mygcd (int a, int b ) {
			int t;

		while (b > 0) {
			t = a;
			a = b;
			b = t%b;
		}
		return a;
		}
		public static boolean isrelativeprime (int a, int b){
			if (mygcd (a,b) == 1)
				return true;
			else
				return false;
			
			
		}
		public static int mypow (int a, int b)
		{
			int p = 1;
			for (int i = 1; i <= b; i++)
			p = p * a;
			return p;
		}
		public static int mylog (int a, int b){
		int h = 0;
		while (a >= b) {
		a = a / b;
		h++;
		}
		return h;
	}
		public static int myfact (int a)
		{
			int nf = 1;
			for (int b = 1; b <= a; b++)
			nf = nf * b;
			return nf;
		}
		public static int myfloor (double a){
			
		int b = (int) a;	
			
			return b;
		}
		public static int myround (double a)
		{
			
			int b = (int) (a + 0.5);	
				
				return b;
			}		
		public static int myceil (double a)
		{
			
			int b = (int) (a + 1);	
				
				return b;
			}
		public static int mysqrt (int a)
		{
			int b = 0;
			while (b*b < a){
				b++;}
				return b;
		}
		public static int mynroot (int a, int n)
		{
			int b = 0;
			while (mypow(b,n) < a){
				b++;}
				return b;
		}
		public static void main (String[] args){
		
			System.out.println("Add 2 + 3 = " + myadd(2,3));
			System.out.println("Multiply 2 * 3 = " +mymultiply(2,3));
			System.out.println("Divide 7/2 = " +mydiv(7,2));
			System.out.println("Mod 7%2 = " +mymod(7,2));
			System.out.println("Prime 9? " +isPrime(9));
			System.out.println("GCD 56 & 32 = " +mygcd(56,32));
			System.out.println("Relative Prime 9 & 16 = " +isrelativeprime (9,16));
			System.out.println("Power 2^5 = " +mypow(2,5));
			System.out.println("Factorial 6 = " +myfact(6));
			System.out.println("log  = " +mylog(256,2));
			System.out.println("Root 81 = " +mysqrt(81));
			System.out.println("Floor 6.5  = " +myfloor(6.5));
			System.out.println("Round 6.5  = " +myround(6.5));
			System.out.println("Ceil 6.5  = " +myceil(6.5));
			System.out.println("NRoot  = " +mynroot(32,5));
		}
	}
		
