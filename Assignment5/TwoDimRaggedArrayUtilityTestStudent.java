import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TwoDimRaggedArrayUtilityTestStudent {
	
	double[][] data = {{436, 853, 235, 437}, {375, 436}, {918, 327, 843, 345, 744}, {286, 234, 123, 12}, {843, 579, 385}};

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testReadFile() throws FileNotFoundException {
		double[][] data = TwoDimRaggedArrayUtility.readFile(new File("dataSet2.txt"));
		double[][] confirmData = {
			{7.0, 2.0, 9.0, 4.0},
			{5.0},
			{8.0, 1.0, 3.0},
			{11.0, 6.0, 7.0, 2.0}
		};
		
		for (int row=0; row<confirmData.length; row++) {
			for (int col=0; col<confirmData[row].length; col++) {
				assertEquals(data[row][col], confirmData[row][col], 0.001);
			}
		}
	}

	@Test
	void testWriteToFile() throws FileNotFoundException {
		double[][] confirmData = {
			{7.2, 2.5, 9.3, 4.8},
			{5.9},
			{8.1, 1.7, 3.3},
			{11.6, 6.9, 7.3, 2.7}
		};
		File writeFile = new File("CheckFile");
		TwoDimRaggedArrayUtility.writeToFile(confirmData, writeFile);
		double[][] data = TwoDimRaggedArrayUtility.readFile(writeFile);
		
		for (int row=0; row<confirmData.length; row++) {
			for (int col=0; col<confirmData[row].length; col++) {
				assertEquals(data[row][col], confirmData[row][col], 0.001);
			}
		}
	}

	@Test
	void testGetTotal() {
		assertEquals(8411.0, TwoDimRaggedArrayUtility.getTotal(data), 0.001);
	}

	@Test
	void testGetAverage() {
		assertEquals(467.2777, TwoDimRaggedArrayUtility.getAverage(data), 0.001);
	}

	@Test
	void testGetRowTotal() {
		assertEquals(1961.0, TwoDimRaggedArrayUtility.getRowTotal(data, 0), 0.001);
		assertEquals(811.0, TwoDimRaggedArrayUtility.getRowTotal(data, 1), 0.001);
		assertEquals(3177.0, TwoDimRaggedArrayUtility.getRowTotal(data, 2), 0.001);
		assertEquals(655.0, TwoDimRaggedArrayUtility.getRowTotal(data, 3), 0.001);
		assertEquals(1807.0, TwoDimRaggedArrayUtility.getRowTotal(data, 4), 0.001);
	}

	@Test
	void testGetColumnTotal() {
		assertEquals(2858.0, TwoDimRaggedArrayUtility.getColumnTotal(data, 0), 0.001);
		assertEquals(2429.0, TwoDimRaggedArrayUtility.getColumnTotal(data, 1), 0.001);
		assertEquals(1586.0, TwoDimRaggedArrayUtility.getColumnTotal(data, 2), 0.001);
		assertEquals(794.0, TwoDimRaggedArrayUtility.getColumnTotal(data, 3), 0.001);
		assertEquals(744.0, TwoDimRaggedArrayUtility.getColumnTotal(data, 4), 0.001);
	}

	@Test
	void testGetHighestInRow() {
		assertEquals(853.0, TwoDimRaggedArrayUtility.getHighestInRow(data, 0), 0.001);
		assertEquals(436.0, TwoDimRaggedArrayUtility.getHighestInRow(data, 1), 0.001);
		assertEquals(918.0, TwoDimRaggedArrayUtility.getHighestInRow(data, 2), 0.001);
		assertEquals(286.0, TwoDimRaggedArrayUtility.getHighestInRow(data, 3), 0.001);
		assertEquals(843.0, TwoDimRaggedArrayUtility.getHighestInRow(data, 4), 0.001);
	}

	@Test
	void testGetHighestInRowIndex() {
		assertEquals(1, TwoDimRaggedArrayUtility.getHighestInRowIndex(data, 0), 0.001);
		assertEquals(1, TwoDimRaggedArrayUtility.getHighestInRowIndex(data, 1), 0.001);
		assertEquals(0, TwoDimRaggedArrayUtility.getHighestInRowIndex(data, 2), 0.001);
		assertEquals(0, TwoDimRaggedArrayUtility.getHighestInRowIndex(data, 3), 0.001);
		assertEquals(0, TwoDimRaggedArrayUtility.getHighestInRowIndex(data, 4), 0.001);
	}

	@Test
	void testGetLowestInRow() {
		assertEquals(235.0, TwoDimRaggedArrayUtility.getLowestInRow(data, 0), 0.001);
		assertEquals(375.0, TwoDimRaggedArrayUtility.getLowestInRow(data, 1), 0.001);
		assertEquals(327.0, TwoDimRaggedArrayUtility.getLowestInRow(data, 2), 0.001);
		assertEquals(12.0, TwoDimRaggedArrayUtility.getLowestInRow(data, 3), 0.001);
		assertEquals(385.0, TwoDimRaggedArrayUtility.getLowestInRow(data, 4), 0.001);
	}

	@Test
	void testGetLowestInRowIndex() {
		assertEquals(2, TwoDimRaggedArrayUtility.getLowestInRowIndex(data, 0), 0.001);
		assertEquals(0, TwoDimRaggedArrayUtility.getLowestInRowIndex(data, 1), 0.001);
		assertEquals(1, TwoDimRaggedArrayUtility.getLowestInRowIndex(data, 2), 0.001);
		assertEquals(3, TwoDimRaggedArrayUtility.getLowestInRowIndex(data, 3), 0.001);
		assertEquals(2, TwoDimRaggedArrayUtility.getLowestInRowIndex(data, 4), 0.001);
	}

	@Test
	void testGetHighestInColumn() {
		assertEquals(918.0, TwoDimRaggedArrayUtility.getHighestInColumn(data, 0), 0.001);
		assertEquals(853.0, TwoDimRaggedArrayUtility.getHighestInColumn(data, 1), 0.001);
		assertEquals(843.0, TwoDimRaggedArrayUtility.getHighestInColumn(data, 2), 0.001);
		assertEquals(437.0, TwoDimRaggedArrayUtility.getHighestInColumn(data, 3), 0.001);
		assertEquals(744.0, TwoDimRaggedArrayUtility.getHighestInColumn(data, 4), 0.001);
	}

	@Test
	void testGetHighestInColumnIndex() {
		assertEquals(2, TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, 0), 0.001);
		assertEquals(0, TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, 1), 0.001);
		assertEquals(2, TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, 2), 0.001);
		assertEquals(0, TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, 3), 0.001);
		assertEquals(2, TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, 4), 0.001);
	}

	@Test
	void testGetLowestInColumn() {
		assertEquals(286.0, TwoDimRaggedArrayUtility.getLowestInColumn(data, 0), 0.001);
		assertEquals(234.0, TwoDimRaggedArrayUtility.getLowestInColumn(data, 1), 0.001);
		assertEquals(123.0, TwoDimRaggedArrayUtility.getLowestInColumn(data, 2), 0.001);
		assertEquals(12.0, TwoDimRaggedArrayUtility.getLowestInColumn(data, 3), 0.001);
		assertEquals(744.0, TwoDimRaggedArrayUtility.getLowestInColumn(data, 4), 0.001);
	}

	@Test
	void testGetLowestInColumnIndex() {
		assertEquals(3, TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, 0), 0.001);
		assertEquals(3, TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, 1), 0.001);
		assertEquals(3, TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, 2), 0.001);
		assertEquals(3, TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, 3), 0.001);
		assertEquals(2, TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, 4), 0.001);
	}

	@Test
	void testGetHighestInArray() {
		assertEquals(918.0, TwoDimRaggedArrayUtility.getHighestInArray(data), 0.001);
	}

	@Test
	void testGetLowestInArray() {
		assertEquals(12.0, TwoDimRaggedArrayUtility.getLowestInArray(data), 0.001);
	}

}
