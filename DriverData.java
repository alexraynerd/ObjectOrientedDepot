
public class DriverData {
	public String driverFirstName, driverLastName, driverUsername, driverPassword, driverManager;
	public int driverNumber;

	public DriverData(String values) {
		String[] split = values.split(",");
		try {
			driverNumber = Integer.parseInt(split[0]);
		} catch (NumberFormatException e) {
		}
		driverFirstName = split[1];
		driverLastName = split[2];
		driverUsername = split[3];
		driverPassword = split[4];
		driverManager = split[5];
	}
}
