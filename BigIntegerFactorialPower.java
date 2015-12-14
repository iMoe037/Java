import java.math.BigInteger;
public class BigIntegerFactorialPower
{
	public static BigInteger factorial(int n)
	{
		BigInteger o =BigInteger.ONE;
		for(int i = n; i>0; i--)
			o = o.multiply(BigInteger.valueOf(i));
			return o;		
	}

	public static BigInteger power(int a,int b)
	{
		{
			BigInteger ba = BigInteger.valueOf(a);
			return ba.pow(b);
		}
	}
}
