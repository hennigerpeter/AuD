public class Hae {
	public static long hae(long x, long y) {
	long z = 0;
		

		while (x>0)
		{
			if (x%y == 0)
			{
				x = x/y;
				z++;
			}
			else
			{
				x--;
			}
		}
	
		return z;
	}
}