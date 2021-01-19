import java.io.IOException;
import java.util.Scanner;

public class MainMenu {

	public static void main(String userType) throws IOException {

		Scanner console = new Scanner(System.in);
		String choice;

		while (true) {
			System.out.println("---MAIN MENU---");
			System.out.println("Please select an option:\n" + "1: View Work Schedules\n" + "2: Create Work Schedule\n"
					+ "3: Get Vehicle\n" + "4: Get Driver\n" + "5: Reassign Vehicle" + "\n6: Log Out" + "\n7: Exit");

			choice = console.next();
			switch (choice) {
			case "1":
				ViewSchedule.main(null);
				break;
			case "2":
				CreateSchedule.main(userType);
				break;
			case "3":
				ViewVehicle.main(userType);
				break;
			case "4":
				ViewDriver.main(userType);
				break;
			case "5":
				DepotManager.main(userType);
				MainMenu.main(userType);
			case "6":
				LogIn.currentUser = null;
				LogIn.main(null);
			case "7":
				System.exit(0);
			}

		}
	}
}
