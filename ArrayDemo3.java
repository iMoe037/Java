public class ArrayDemo3
{
	public static int findtotal(int[]A) {
		int tot = 0;
		for (int i = 0; i < A.length; i++){
			tot=tot + A[i];
		}
		return tot;
	}
	public static float  findavg(int[]A) {
		int tot = 0;
		for (int i = 0; i < A.length; i++){
			tot=tot + A[i];
		}
		return (float)(tot)/(float)(A.length);
	}
	public static int findmax(int[]A) {
		int tmax = -1;
		for (int i = 0; i < A.length; i++){
			if(tmax < A[i])
				tmax = A[i];

		}
		return tmax;
	}
	public static int findmin(int[]A) {
		int tmax = -1;
		int tinx = -1;
		for (int i = 0; i < A.length; i++){
			if(tmax < A[i])
				tmax = A[i];
				tinx = i;

		}
		return tinx;
	}
	public static int findminstud(int[]A, int b) {
		int nstu = 0;
		for (int i = 0; i < A.length; i++){
			if(A[i] >= b)
			nstu++;

		}
		return nstu;
	}
	
	public static void main(String[] args)
	{
		int[] hours ={8,7,23,2,1,4,24};  // Array of hours

		System.out.println("The total time studied was: " + findtotal(hours));
		System.out.println("The average time was " + findavg(hours));
		System.out.println("The maximum time studied was: " + findmax(hours));
		System.out.println("The minimum time studied was: " + findmin(hours));
		System.out.println("The number of students who studied more then 7 hrs : " + findminstud(hours,7));
	}

}
