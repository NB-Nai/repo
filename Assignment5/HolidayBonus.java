/*
 * Class: CMSC203 
 * Instructor: Huseyin Aygun
 * Description: Allow for calculating the bonuses for each row from given 2D-double array and the sum of the bonuses.
 * Due: 11/17/25
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: Natdanai Boonyaleephan
*/

public class HolidayBonus {
	private final static double HIGHEST_BONUS = 5000.0;
	private final static double LOWEST_BONUS = 1000.0;
	private final static double OTHER_BONUS = 2000.0;
	
	public static double[] calculateHolidayBonus(double[][] data) {
		double[] bonuses = new double[data.length];
		
		for (int row=0; row<data.length; row++) {
			double totalBonus = 0.0;
			
			for (int col=0; col<data[row].length; col++) {
				double highest = TwoDimRaggedArrayUtility.getHighestInColumn(data, col);
				double lowest = TwoDimRaggedArrayUtility.getLowestInColumn(data, col);
				
				double value = data[row][col];
				if (value <= 0)
					continue;
				else if (value == highest)
					totalBonus += HIGHEST_BONUS;
				else if (value == lowest)
					totalBonus += LOWEST_BONUS;
				else
					totalBonus += OTHER_BONUS;
			}
			bonuses[row] = totalBonus;
		}
		
		return bonuses;
	}
	
	public static double calculateTotalHolidayBonus(double[][] data) {
		double[] bonuses = calculateHolidayBonus(data);
		double total = 0;
		
		for (int index=0; index<bonuses.length; index++) {
			total += bonuses[index];
		}
		
		return total;
	}
}
