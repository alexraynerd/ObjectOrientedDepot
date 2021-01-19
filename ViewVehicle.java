import java.io.IOException;
import java.util.Scanner;

public class ViewVehicle {

	public static void main(String userType) throws IOException {
		if (userType.equals("d")) {
			System.out.println("Access denied. You are but a simple driver peasant.");
			MainMenu.main(userType);
		}

		System.out.println("Please enter a vehicle number.");
		Scanner console = new Scanner(System.in);
		int answer = console.nextInt();

		for (VehicleData i : DriverStart.vehicles) {
			if (i.vehicleNumber == answer) {
				if (i.tankerLiquidType == null) {
					System.out.println("Vehicle Type: Truck");
				} else {
					System.out.println("Vehicle Type: Tanker");
				}
				System.out.println("Vehicle Number: " + i.vehicleNumber + "\nVehicle Make: " + i.vehicleMake
						+ "\nVehicle Model: " + i.vehicleModel + "\nVehicle Weight: " + i.vehicleWeight
						+ "tonnes\nReg. Number: " + i.vehicleReg);
				if (i.tankerLiquidType == null) {
					System.out.println("Cargo Capacity: " + i.capacityAttribute + " tonnes");
				} else {
					System.out.println("Cargo Capacity: " + i.capacityAttribute + " litres");
					System.out.println("Liquid Type: " + i.tankerLiquidType);
				}
				System.out.println("Depot Location: " + i.depotLoc);
			}
		}
		MainMenu.main(userType);

	}
}
