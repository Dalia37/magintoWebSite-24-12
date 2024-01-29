package MyTestCases;

import java.util.Random;

public class Parameters {

	
	Random rand = new Random();
	int randomindex = rand.nextInt(10);
	int randomEmailId= rand.nextInt(9999);
	String[] firstNames = {"Alice", "Bob", "Charlie", "David", "Eva", "Frank", "Grace", "Hank", "Ivy", "Jack"};
	String[] lastNames = {"Smith", "Johnson", "Williams", "Jones", "Brown", "Davis", "Miller", "Wilson", "Moore", "Taylor"};
	String commonPassword = "Asd123!@#$";
	String emailID = firstNames[randomindex]+lastNames[randomindex]+randomEmailId+"@"+"gmail.com";
}
