import java.math.BigInteger;

public class Combc
{
   public static BigInteger fact(int n)
   {
		BigInteger o = BigInteger.ONE;
		for (int i = 1; i <= n; i++)
		    o = o.multiply(BigInteger.valueOf(i));
		return o;
   }
   public static BigInteger choose(int n, int k)
   {
        BigInteger o = permute(n,k);
		o = o.divide(fact(k));	
		return o;
   }
   public static BigInteger permute(int n, int k)
   {
//        BigInteger o = fact(n);
//		o = o.divide(fact(n-k));
		
		BigInteger o = BigInteger.ONE;
		for (int i = (n-k+1); i <= n; i++)
		    o = o.multiply(BigInteger.valueOf(i));
		return o;
   }
   
   public static BigInteger pow(int n, int k)
   {
		BigInteger o = BigInteger.ONE;
		for (int i = 1; i <= k; i++)
		    o = o.multiply(BigInteger.valueOf(n));
		return o;
   }
}
