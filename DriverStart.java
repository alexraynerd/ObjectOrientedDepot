import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DriverStart {

	public static ArrayList<DriverData> drivers = new ArrayList<>();
	public static ArrayList<VehicleData> vehicles = new ArrayList<>();
	public static ArrayList<ViewSchedule> jobs = new ArrayList<>();
	public static DriverData currentDriver;
	public static VehicleData currentVehicle;
	public static ViewSchedule currentJob;

	public static void main(String[] args) throws IOException {

		File driverFile = new File(
				"C:\\Users\\Ted\\eclipse-workspace\\CourseworkGroupUpdatedTed\\datafiles\\drivers.csv");
		Scanner scan = new Scanner(driverFile);
		String line = null;

		while (scan.hasNextLine()) {
			line = scan.nextLine();
			currentDriver = new DriverData(line);
			drivers.add(currentDriver);
		}

		File truckFile = new File(
				"C:\\Users\\Ted\\eclipse-workspace\\CourseworkGroupUpdatedTed\\datafiles\\trucks.csv");
		Scanner scan2 = new Scanner(truckFile);
		line = null;
		while (scan2.hasNextLine()) {
			line = scan2.nextLine();
			currentVehicle = new VehicleData(line);
			vehicles.add(currentVehicle);
		}

		File tankerFile = new File(
				"C:\\Users\\Ted\\eclipse-workspace\\CourseworkGroupUpdatedTed\\datafiles\\tankers.csv");
		Scanner scan3 = new Scanner(tankerFile);
		line = null;
		while (scan3.hasNextLine()) {
			line = scan3.nextLine();
			currentVehicle = new VehicleData(line);
			vehicles.add(currentVehicle);
		}

		File jobFile = new File("C:\\Users\\Ted\\eclipse-workspace\\CourseworkGroupUpdatedTed\\datafiles\\jobs.csv");
		Scanner scan4 = new Scanner(jobFile);
		line = null;
		while (scan4.hasNextLine()) {
			line = scan4.nextLine();
			currentJob = new ViewSchedule(line);
			jobs.add(currentJob);
		}

		LogIn.main(args);
	}

}
