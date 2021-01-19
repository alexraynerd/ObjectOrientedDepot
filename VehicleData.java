
public class VehicleData {

	public Integer vehicleNumber;
	public Double capacityAttribute, vehicleWeight;
	public String vehicleMake, vehicleModel, vehicleReg, depotLoc, tankerLiquidType;

	public VehicleData(String values) {
		String[] split = values.split(",");
		try {
			vehicleNumber = Integer.parseInt(split[0]);
		} catch (NumberFormatException e) {
		}
		vehicleMake = (split[1]);
		vehicleModel = (split[2]);
		try {
			vehicleWeight = Double.parseDouble(split[3]);
		} catch (NumberFormatException e) {
		}
		vehicleReg = (split[4]);
		try {
			capacityAttribute = Double.parseDouble(split[5]);
		} catch (NumberFormatException e) {
		}
		depotLoc = (split[6]);
		try {
			tankerLiquidType = (split[7]);
		} catch (IndexOutOfBoundsException e) {
			tankerLiquidType = null;
		}
	}

}
