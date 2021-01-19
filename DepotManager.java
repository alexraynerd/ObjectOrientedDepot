import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DepotManager {
	public static int vehicleNumber = 0;
	public static Scanner console = new Scanner(System.in);
	public static Date relocEndDate = null;
	public static Date relocStartDate = null;
	public static String vehicleModel, vehicleMake, depotLoc, newDepotLoc, relocStartString, relocEndString,
			vehicleNumberString;

	public static void main(String userType) throws IOException {
		if (userType.equals("d")) {
			System.out.println("Access denied.");
			MainMenu.main(userType);
		}
		vehicleIdent();
	}

	public static void vehicleIdent() throws IOException {
		System.out.println("Please enter the vehicle number of the vehicle you want to move: ");
		vehicleNumberString = console.nextLine();
		vehicleNumber = Integer.parseInt(vehicleNumberString);
		for (VehicleData i : DriverStart.vehicles) {
			if (i.vehicleNumber == vehicleNumber) {
				System.out.println("Vehicle Number: " + i.vehicleNumber + "\nVehicle Make: " + i.vehicleMake
						+ "\nVehicle Model: " + i.vehicleModel + "\nVehicle Weight: " + i.vehicleWeight
						+ "tonnes\nReg. Number: " + i.vehicleReg);
				vehicleMake = i.vehicleMake;
				vehicleModel = i.vehicleModel;
				depotLoc = i.depotLoc;
			}
		}

		System.out.println("Is this Correct? (Y|N)");
		String vehicleCheck = console.nextLine();
		if (vehicleCheck.equalsIgnoreCase("y")) {
			availabilityCheck();
		} else if (vehicleCheck.equalsIgnoreCase("n")) {
			vehicleIdent();
		} else {
			System.out.println("Error : Incorrect Response");
			vehicleIdent();
		}

	}

	public static void availabilityCheck() throws IOException {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		System.out.println("Enter the start date and time for the relocation [dd/MM/yyyy HH:mm]: ");
		int y = 0;
		while (y < 1) {
			y++;
			try {
				String relocStartString = console.nextLine();
				relocStartDate = df.parse(relocStartString);
			} catch (ParseException e) {
				System.out.println("Incorrect Formatting, Try Again");
				y = 0;
			}
			relocStartString = df.format(relocStartDate);

		}

		System.out.println("Enter the end date and time for the relocation [dd/MM/yyyy]: ");
		int x = 0;
		while (x < 1) {
			x++;
			try {
				String relocEndString = console.nextLine();
				relocEndDate = df.parse(relocEndString);
			} catch (ParseException e) {
				System.out.println("Incorrect Formatting, Try Again");
				x = 0;
			}
			relocEndString = df.format(relocEndDate);

		}

		for (ViewSchedule i : DriverStart.jobs) {
			if (vehicleNumber == i.vehicle) {
				if (relocStartDate.after(i.startDate) && relocEndDate.before(i.endDate)
						|| relocStartDate.equals(i.startDate) || relocEndDate.equals(i.endDate)) {
					System.out.println("Date Conflict: Desired Relocation Date During Pending or Active Job");
					availabilityCheck();
				} else {
					System.out.println("Relocation Date Available");
					relocationBooking();
				}
			}

		}

	}

	public static void relocationBooking() throws IOException {

		System.out.println("Please Enter The Depot The Vehicle Will Be Relocated To: ");
		newDepotLoc = console.next();

		FileWriter write = new FileWriter(
				"C:\\Users\\Ted\\eclipse-workspace\\CourseworkGroupUpdatedTed\\datafiles\\relocationBookings.csv", true);
		write.append(vehicleNumberString);
		write.append(",");
		write.append(vehicleMake);
		write.append(",");
		write.append(vehicleModel);
		write.append(",");
		write.append(depotLoc);
		write.append(",");
		write.append(newDepotLoc);
		write.append(",");
		write.append(relocStartString);
		write.append(",");
		write.append(relocEndString);
		write.append(",");

		write.flush();
		write.close();

		System.out.println("Booking Created");
	}
}
