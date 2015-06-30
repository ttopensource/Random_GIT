import java.util.Random;

/* This class to generate random number */

public class RandomGen {
	
	public static void main(String... aArgs) {
	System.out.println(" Generating 10 random number from 100");
	Random generator = new Random();
	for ( int i=1; i<=10; ++i) {
		int RandomInt = generator.nextInt(100);
		System.out.println("Generated : " + RandomInt);
	}
	   System.out.println("Done.");
	}
}

