import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.*;

public class ViewSchedule {
	public String client, startDateString, endDateString;
	public Date startDate, endDate;
	public int driver, vehicle;

	public ViewSchedule(String values) {
		String[] split = values.split(",");
		client = split[0];
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		startDateString = split[1];
		try {
			startDate = df.parse(startDateString);
			String StartDateString = df.format(startDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		endDateString = split[2];
		try {
			endDate = df.parse(endDateString);
			String EndDateString = df.format(endDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		try {
			driver = Integer.parseInt(split[3]);
		} catch (NumberFormatException e) {
		}
		try {
			vehicle = Integer.parseInt(split[4]);
		} catch (NumberFormatException e) {
		}
	}

	public static void main(String args[]) throws FileNotFoundException {
		int j = 0, x = 0;
		if (LogIn.currentUser.driverManager.equals("y")) {
			System.out.println("Would you like to view:");
			System.out.println("1: Only your pending schedule.");
			System.out.println("2: The entire company's pending schedule.");
			System.out.println("3: Only your active schedule.");
			System.out.println("4: The entire company's active schedule.");
			System.out.println("5: An archived schedule");
			String choice;
			Scanner console = new Scanner(System.in);
			choice = console.next();
			switch (choice) {
			case "1":
				while (j < DriverStart.jobs.size()) {
					if (LogIn.currentUser.driverNumber == (DriverStart.jobs.get(j).driver)) {
						if (DriverStart.jobs.get(j).startDate.after(new Date())) {
							System.out.println(
									DriverStart.jobs.get(j).client + " " + DriverStart.jobs.get(j).startDateString + " "
											+ DriverStart.jobs.get(j).endDateString + " "
											+ DriverStart.jobs.get(j).driver + " " + DriverStart.jobs.get(j).vehicle);
						}
					}
					j = j + 1;
				}
			case "2":
				while (j < DriverStart.jobs.size()) {
					if (DriverStart.jobs.get(j).startDate.after(new Date())) {
						System.out.println(DriverStart.jobs.get(j).client + " "
								+ DriverStart.jobs.get(j).startDateString + " " + DriverStart.jobs.get(j).endDateString
								+ " " + DriverStart.jobs.get(j).driver + " " + DriverStart.jobs.get(j).vehicle);
					}
					j = j + 1;
				}
			case "3":
				while (j < DriverStart.jobs.size()) {
					if (LogIn.currentUser.driverNumber == (DriverStart.jobs.get(j).driver)) {
						if (new Date().after(DriverStart.jobs.get(j).startDate)) {
							if (new Date().before(DriverStart.jobs.get(j).endDate)) {
								System.out.println(DriverStart.jobs.get(j).client + " "
										+ DriverStart.jobs.get(j).startDateString + " "
										+ DriverStart.jobs.get(j).endDateString + " " + DriverStart.jobs.get(j).driver
										+ " " + DriverStart.jobs.get(j).vehicle);
							}
						}
					}
					j = j + 1;
				}
			case "4":
				while (j < DriverStart.jobs.size()) {
					if (new Date().after(DriverStart.jobs.get(j).startDate)) {
						if (new Date().before(DriverStart.jobs.get(j).endDate)) {
							System.out.println(
									DriverStart.jobs.get(j).client + " " + DriverStart.jobs.get(j).startDateString + " "
											+ DriverStart.jobs.get(j).endDateString + " "
											+ DriverStart.jobs.get(j).driver + " " + DriverStart.jobs.get(j).vehicle);
						}
					}
					j = j + 1;
				}
			case "5":
				while (j < DriverStart.jobs.size()) {
					if (new Date().after(DriverStart.jobs.get(j).endDate)) {
						System.out.println(DriverStart.jobs.get(j).client + " "
								+ DriverStart.jobs.get(j).startDateString + " " + DriverStart.jobs.get(j).endDateString
								+ " " + DriverStart.jobs.get(j).driver + " " + DriverStart.jobs.get(j).vehicle);
					}
					j = j + 1;
				}
			}
		}
		if (LogIn.currentUser.driverManager.equals("n")) {
			while (j < DriverStart.jobs.size()) {
				if (LogIn.currentUser.driverNumber == (DriverStart.jobs.get(j).driver)) {
					System.out.println(DriverStart.jobs.get(j).client + " " + DriverStart.jobs.get(j).startDateString
							+ " " + DriverStart.jobs.get(j).endDateString + " " + DriverStart.jobs.get(j).driver + " "
							+ DriverStart.jobs.get(j).vehicle);
				}
				j = j + 1;
			}
		}
	}
}