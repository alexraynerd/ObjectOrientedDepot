import java.io.IOException;
import java.util.Scanner;

public class ViewDriver {

	public static void main(String userType) throws IOException {
		if (userType.equals("d")) {
			System.out.println("Access denied. You are but a simple driver peasant.");
			MainMenu.main(userType);
		}

		System.out.println("Please enter a driver number.");
		Scanner console = new Scanner(System.in);
		int answer = console.nextInt();

		for (DriverData i : DriverStart.drivers) {
			if (i.driverNumber == answer) {
				System.out.println("Driver Number: " + i.driverNumber + "\nFirst Name: " + i.driverFirstName
						+ "\nLast Name: " + i.driverLastName + "\nIs Manager: " + i.driverManager);
			}
		}
		MainMenu.main(userType);
	}
}
