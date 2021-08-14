import java.time.LocalDate;

public class CarPriceEstimator {
	public double getSalePrice(String makeAndModel, int yearManufactured, double milesDriven, 
			int airbagCount, boolean hasAbs, boolean hasEbd, boolean hasRearViewCamera, 
			boolean hasSunRoof, boolean hasAutoAC, boolean hasAccidentHistory) {
		
		double salePrice = getPrice(makeAndModel, yearManufactured);
		
		int currentYear = LocalDate.now().getYear();
		
		int ageOfCar = currentYear - yearManufactured+1;
		
		System.out.println("Age of Car: "+ ageOfCar);
		
//		1. compute based on yearly description value

			if(ageOfCar <= 10) {
				salePrice -= (0.05 * salePrice * ageOfCar);
			}else {
				return salePrice * 0.1;
			}
			
			System.out.println("Sale Price after depreciation: "+ salePrice);
			
//		2. Security Features
			if(!((airbagCount >= 2) && hasAbs && hasEbd)) {
				salePrice -= 1000.0;
			}
			System.out.println("Sale price after accounting for security features: "+ salePrice);
			
//			3. Comfort Features:
			if(hasRearViewCamera && (hasAutoAC || hasSunRoof)) {
				salePrice += 500.0;
			}
			System.out.println("Sale price after accounting for comfort features: "+ salePrice);
			
//			4. past accident
			if(hasAccidentHistory) {salePrice -= 500.0;};
			System.out.println("Sale price after accounting for accident history: "+ salePrice);
//			5. Based on additional miles driven
				double expectedMilesDriven = ageOfCar * 10000.0;
				double additionalMiles = milesDriven - expectedMilesDriven;
				
//				a)
					if(additionalMiles > 1000 && additionalMiles <= 10000) {
						salePrice -= 500.0;
					}
//				b)
					else if(additionalMiles > 10000 && additionalMiles <= 30000) {
						salePrice -= 1000.0;
						
					}
//				c)	
					else if(additionalMiles > 30000) {
						salePrice -= 1500.0;
					}
			System.out.println("Sale price after accounting for miles driven: "+ salePrice);
			return salePrice;
					
					
	}
	
	private double getPrice(String makeAndModel, int yearManufactured) {
		if(makeAndModel.equalsIgnoreCase("ford ecosport")) {
			return 20000.0;
		}
		else if(makeAndModel.equalsIgnoreCase("honda city")) {
			return 25000.0;
		}else if(makeAndModel.equalsIgnoreCase("toyota camry hybird")) {
			return 30000.0;
		}
		return 20000.0;
	}
	
	public static void main(String[] args) {
		CarPriceEstimator carPriceEstimator = new CarPriceEstimator();
		double salesPrice = carPriceEstimator.getSalePrice("ford ecosport", 2020, 60000.0, 2, true, false, true, false, false, true);
		
	}
}
