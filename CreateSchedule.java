import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class CreateSchedule {

	public static Scanner console = new Scanner(System.in);

	public static void main(String userType) throws IOException {

		if (userType.equals("d")) {
			System.out.println("Access denied.");
			MainMenu.main(userType);
		}

		System.out.println("Enter client name");
		String clientName = console.nextLine();
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		System.out.println("Enter start date. dd/MM/yyyy HH:mm");

		Date startDate = null;
		String startDateStr = null;

		while (true) {
			try {
				startDateStr = console.nextLine();
				startDate = df.parse(startDateStr);
			} catch (ParseException e) {
				System.out.println("Incorrect format. Exiting");
				System.exit(0);
			}
			long MILLIS = 48 * 60 * 60 * 1000L;
			boolean moreThan2Day = Math.abs(startDate.getTime() - new Date().getTime()) > MILLIS;
			if (moreThan2Day == true) {
				startDateStr = df.format(startDate);
				break;
			} else {
				System.out.println("Start date must be at least 48 hours from now.");
			}
		}
		System.out.println("Enter end date. dd/MM/yyyy HH:mm");

		Date endDate = null;
		String endDateStr = null;

		while (true) {
			try {
				endDateStr = console.nextLine();
				endDate = df.parse(endDateStr);
			} catch (ParseException e) {
				System.out.println("Incorrect format. Exiting");
				System.exit(0);
			}
			long MILLIS = 72 * 60 * 60 * 1000L;
			boolean moreThan2Day = Math.abs(endDate.getTime() - startDate.getTime()) >= MILLIS;
			if (moreThan2Day == true) {
				endDateStr = df.format(endDate);
				break;
			} else {
				System.out.println("End date must be at least 72 hours from the start date.");
			}
		}
		System.out.println("Enter driver number");
		String driverNoStr = null;

		try {
			int driverNo = console.nextInt();
			driverNoStr = Integer.toString(driverNo);
		} catch (NumberFormatException e) {
			System.out.println("Incorrect format. Exiting");
			System.exit(0);
		}

		System.out.println("Enter vehicle number");
		String vehicleNoStr = null;

		try {
			int vehicleNo = console.nextInt();
			vehicleNoStr = Integer.toString(vehicleNo);
		} catch (NumberFormatException e) {
			System.out.println("Incorrect format. Exiting");
			System.exit(0);
		}

		FileWriter write = new FileWriter(
				"C:\\Users\\Ted\\eclipse-workspace\\CourseworkGroupUpdatedTed\\datafiles\\jobs.csv", true);

		write.append(clientName);
		write.append(",");
		write.append(startDateStr);
		write.append(",");
		write.append(endDateStr);
		write.append(",");
		write.append(driverNoStr);
		write.append(",");
		write.append(vehicleNoStr);
		write.append(",");

		write.flush();
		write.close();

		System.out.println("Schedule Created");
		MainMenu.main(userType);
	}
}
