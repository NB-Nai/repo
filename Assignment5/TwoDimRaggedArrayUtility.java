/*
 * Class: CMSC203 
 * Instructor: Huseyin Aygun
 * Description: Allow for getting specific data from given 2D-double array, and reading from and writing data into the given file.
 * Due: 11/17/25
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: Natdanai Boonyaleephan
*/

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class TwoDimRaggedArrayUtility {
	
	// Read value from the file and return result in 2D double array.
	public static double[][] readFile(File file) throws FileNotFoundException {
		Scanner inputFile = new Scanner(file);
		var data = new ArrayList<double[]>();
		
		// Check if there are still remaining content in the file.
		while (inputFile.hasNextLine()) {
			String[] tokens = inputFile.nextLine().split(" ");
			double[] rowData = new double[tokens.length];
			
			// Parse each value into double and insert into data array for returning result.
			for (int index=0; index<tokens.length; index++) {
				rowData[index] = Double.parseDouble(tokens[index]);
			}
			data.add(rowData);
		}
		
		inputFile.close();
		return data.toArray(new double[data.size()][]);
	}
	
	// Write value from data into the given file.
	public static void writeToFile(double[][] data, File file) throws FileNotFoundException {
		PrintWriter outputFile = new PrintWriter(file);
		for (int row=0; row<data.length; row++) {
			String line = "";
			
			// Include each value into the line and spacebar character for each row of the data.
			for (int col=0; col<data[row].length; col++) {
				line += String.format("%s ", data[row][col]);
			}
			
			// Append the line into the file and then go to the next line.
			outputFile.println(line);
		}
		outputFile.close();
	}
	
	// Return the sum of all values inside data array.
	public static double getTotal(double[][] data) {
		double total = 0;
		for (int row=0; row<data.length; row++) {
			for (int col=0; col<data[row].length; col++) {
				total += data[row][col];
			}
		}
		return total;
	}
	
	// Return the average value of data array.
	public static double getAverage(double[][] data) {
		double total = 0, elements = 0;
		for (int row=0; row<data.length; row++) {
			for (int col=0; col<data[row].length; col++) {
				total += data[row][col];
				elements++;
			}
		}
		return total / elements;
	}
	
	// Return the sum of all values within the given row from data array.
	public static double getRowTotal(double[][] data, int rowIndex) {
		double total = 0;
		for (int col=0; col<data[rowIndex].length; col++) {
			total += data[rowIndex][col];
		}
		return total;
	}
	
	// Return the sum of all values within the given column from data array.
	public static double getColumnTotal(double[][] data, int colIndex) {
		double total = 0;
		for (int row=0; row<data.length; row++) {
			// If the element from the column index of the row does not exist, then skip to next iteration.
			if (data[row].length <= colIndex)
				continue;
			total += data[row][colIndex];
		}
		return total;
	}
	
	// Return the highest value of the given row from data array.
	public static double getHighestInRow(double[][] data, int rowIndex) {
		double highest = Double.NEGATIVE_INFINITY;
		for (int col=0; col<data[rowIndex].length; col++) {
			if (data[rowIndex][col] > highest)
				highest = data[rowIndex][col];
		}
		return highest;
	}
	
	// Return the index of the highest value of the given row from data array.
	public static int getHighestInRowIndex(double[][] data, int rowIndex) {
		double highest = Double.NEGATIVE_INFINITY;
		int index = 0;
		for (int col=0; col<data[rowIndex].length; col++) {
			if (data[rowIndex][col] > highest) {
				highest = data[rowIndex][col];
				index = col;
			}
		}
		return index;
	}
	
	// Return the lowest value of the given row from data array.
	public static double getLowestInRow(double[][] data, int rowIndex) {
		double lowest = Double.POSITIVE_INFINITY;
		for (int col=0; col<data[rowIndex].length; col++) {
			if (data[rowIndex][col] < lowest)
				lowest = data[rowIndex][col];
		}
		return lowest;
	}
	
	// Return the index of the lowest value of the given row from data array.
	public static int getLowestInRowIndex(double[][] data, int rowIndex) {
		double lowest = Double.POSITIVE_INFINITY;
		int index = 0;
		for (int col=0; col<data[rowIndex].length; col++) {
			if (data[rowIndex][col] < lowest) {
				lowest = data[rowIndex][col];
				index = col;
			}
		}
		return index;
	}
	
	// Return the highest value of the given column from data array.
	public static double getHighestInColumn(double[][] data, int colIndex) {
		double highest = Double.NEGATIVE_INFINITY;
		for (int row=0; row<data.length; row++) {
			// If the element from the column index of the row does not exist, then skip to next iteration.
			if (data[row].length <= colIndex)
				continue;
			if (data[row][colIndex] > highest)
				highest = data[row][colIndex];
		}
		return highest;
	}
	
	// Return the index of the highest value of the given column from data array.
	public static int getHighestInColumnIndex(double[][] data, int colIndex) {
		double highest = Double.NEGATIVE_INFINITY;
		int index = 0;
		for (int row=0; row<data.length; row++) {
			// If the element from the column index of the row does not exist, then skip to next iteration.
			if (data[row].length <= colIndex)
				continue;
			if (data[row][colIndex] > highest) {
				highest = data[row][colIndex];
				index = row;
			}
		}
		return index;
	}
	
	// Return the lowest value of the given column from data array.
	public static double getLowestInColumn(double[][] data, int colIndex) {
		double lowest = Double.POSITIVE_INFINITY;
		for (int row=0; row<data.length; row++) {
			// If the element from the column index of the row does not exist, then skip to next iteration.
			if (data[row].length <= colIndex)
				continue;
			if (data[row][colIndex] < lowest)
				lowest = data[row][colIndex];
		}
		return lowest;
	}
	
	// Return the index of the lowest value of the given column from data array.
	public static int getLowestInColumnIndex(double[][] data, int colIndex) {
		double lowest = Double.POSITIVE_INFINITY;
		int index = 0;
		for (int row=0; row<data.length; row++) {
			// If the element from the column index of the row does not exist, then skip to next iteration.
			if (data[row].length <= colIndex)
				continue;
			if (data[row][colIndex] < lowest) {
				lowest = data[row][colIndex];
				index = row;
			}
		}
		return index;
	}
	
	// Return the highest value from data array.
	public static double getHighestInArray(double[][] data) {
		double highest = Double.NEGATIVE_INFINITY;
		for (int row=0; row<data.length; row++) {
			for (int col=0; col<data[row].length; col++) {
				if (data[row][col] > highest)
					highest = data[row][col];
			}
		}
		return highest;
	}
	
	// Return the lowest value from data array.
	public static double getLowestInArray(double[][] data) {
		double lowest = Double.POSITIVE_INFINITY;
		for (int row=0; row<data.length; row++) {
			for (int col=0; col<data[row].length; col++) {
				if (data[row][col] < lowest)
					lowest = data[row][col];
			}
		}
		return lowest;
	}
}
