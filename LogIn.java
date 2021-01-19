import java.io.IOException;
import java.util.Scanner;

public class LogIn {

	public static Scanner console = new Scanner(System.in);
	public static DriverData currentUser;

	public static void main(String[] args) throws IOException {

		System.out.println("---LOG IN---");
		System.out.println("Are you a manager or driver?");
		String userType = null;

		while (true) {

			String input = console.next();

			if (input.equals("manager") || input.equals("m")) {
				System.out.println("Please enter username.");
				input = console.next();

				for (int i = 0; i < DriverStart.drivers.size(); i++) {

					if (DriverStart.drivers.get(i).driverUsername.equals(input)
							&& DriverStart.drivers.get(i).driverManager.equals("y")) {
						System.out.println("Please enter password");
						input = console.next();

						if (DriverStart.drivers.get(i).driverPassword.equals(input)) {
							System.out.println("Success, logged in");
							userType = "m";
							currentUser = DriverStart.drivers.get(i);
						} else {
							System.out.println("Incorrect password");
							System.exit(0);
						}

					} else if (DriverStart.drivers.get(i).driverUsername.equals(input)
							&& !DriverStart.drivers.get(i).driverManager.equals("y")) {
						System.out.println("Not manager");
						System.exit(0);
					} else if (i == (DriverStart.drivers.size() -1)) {
						System.out.println("Incorrect username");
						System.exit(0);
					}
				}
				break;

			} else if (input.equals("driver") || input.equals("d")) {
				System.out.println("Please enter username.");
				input = console.next();

				for (int i = 0; i < DriverStart.drivers.size(); i++) {

					if (DriverStart.drivers.get(i).driverUsername.equals(input)) {
						System.out.println("Please enter password");
						input = console.next();

						if (DriverStart.drivers.get(i).driverPassword.equals(input)) {
							System.out.println("Success, logged in");
							userType = "d";
							currentUser = DriverStart.drivers.get(i);
						} else {
							System.out.println("Incorrect password");
							System.exit(0);
						}

					} else if (i == DriverStart.drivers.size()) {
						System.out.println("Incorrect username or not manager");
						System.exit(0);
					}

				}
				break;
			} else {
				System.out.println("Incorrect selection. Please try again.");
			}

		}
		MainMenu.main(userType);
	}
}
