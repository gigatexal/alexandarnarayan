package testing;


public class varTrace {
	
	public static void main(String[] args)
	{
		SimpleLocation loc1 = new SimpleLocation(-12.04,-77.0);
		SimpleLocation loc2 = new SimpleLocation(-12.05,-77.0);
		loc1 = loc2;
		loc1.lat = 18;
		System.out.println(loc2.lat + " " + loc2.lon);
	}
}
	

