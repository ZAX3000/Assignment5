

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TwoDimRaggedArrayUtilitySTUDENT_Test {
	//STUDENT fill in dataSetSTUDENT with values, it must be a ragged array
	private double[][] dataSetSTUDENT1 = {	{30002,6078054,304,603},
											{704,500,400},
											{5340.60,60640.60,503,604}};
	
	private double[][] dataSetSTUDENT2 = {	{-50 ,304,603},
											{704,500,-78},
											{5360.80,60680.90,503,0}};

	//dataSet3 has fewer elements in first row than in other rows
	private double[][] dataSetSTUDENT3 = {	{300,60754,3,9, 80, 50},
											{704,500},
											{5340.90,640.45,503,-8}};

	//dataSet4 has negative elements as well as positive
	
	private File outputFile;

	@Before
	public void setUp() throws Exception {
		outputFile = new File("TestOut.txt");
	}

	@After
	public void tearDown() throws Exception {
		dataSetSTUDENT1 = dataSetSTUDENT2 = dataSetSTUDENT3 = null;
		outputFile = null;
	}

	/**
	 * Student Test getTotal method
	 * Return the total of all the elements in the two dimensional array
	 */
	@Test
	public void testGetTotal() 
	{
		assertEquals(6177655.2,TwoDimRaggedArrayUtility.getTotal(dataSetSTUDENT1),.001);
		assertEquals(68527.7,TwoDimRaggedArrayUtility.getTotal(dataSetSTUDENT2),.001);
		assertEquals(68876.35,TwoDimRaggedArrayUtility.getTotal(dataSetSTUDENT3),.001);
	}

	/**
	 * Student Test getAverage method
	 * Return the average of all the elements in the two dimensional array
	 */
	@Test
	public void testGetAverage() 
	{
		assertEquals(561605.0181818182,TwoDimRaggedArrayUtility.getAverage(dataSetSTUDENT1),.001);
		assertEquals(6852.7699999999995,TwoDimRaggedArrayUtility.getAverage(dataSetSTUDENT2),.001);
		assertEquals(5739.695833333334,TwoDimRaggedArrayUtility.getAverage(dataSetSTUDENT3),.001);
	}

	/**
	 * Student Test getRowTotal method
	 * Return the total of all the elements of the row.
	 * Row 0 refers to the first row in the two dimensional array
	 */
	@Test
	public void testGetRowTotal() 
	{
		assertEquals(6108963.0,TwoDimRaggedArrayUtility.getRowTotal(dataSetSTUDENT1,0),.001);
		assertEquals(66544.7,TwoDimRaggedArrayUtility.getRowTotal(dataSetSTUDENT2,2),.001);
		assertEquals(1204,TwoDimRaggedArrayUtility.getRowTotal(dataSetSTUDENT3,1),.001);
	}


	/**
	 * Student Test getColumnTotal method
	 * Return the total of all the elements in the column. If a row in the two dimensional array
	 * doesn't have this column index, it is not an error, it doesn't participate in this method.
	 * Column 0 refers to the first column in the two dimensional array
	 */
	@Test
	public void testGetColumnTotal() 
	{
		assertEquals(36046.6,TwoDimRaggedArrayUtility.getColumnTotal(dataSetSTUDENT1,0),.001);
		assertEquals(61484.9,TwoDimRaggedArrayUtility.getColumnTotal(dataSetSTUDENT2,1),.001);
		assertEquals(506,TwoDimRaggedArrayUtility.getColumnTotal(dataSetSTUDENT3,2),.001);

	}


	/**
	 * Student Test getHighestInArray method
	 * Return the largest of all the elements in the two dimensional array.
	 */
	@Test
	public void testGetHighestInArray() 
	{
		assertEquals(6078054,TwoDimRaggedArrayUtility.getHighestInArray(dataSetSTUDENT1),.001);
		assertEquals(60680.90,TwoDimRaggedArrayUtility.getHighestInArray(dataSetSTUDENT2),.001);
		assertEquals(60754,TwoDimRaggedArrayUtility.getHighestInArray(dataSetSTUDENT3),.001);
	}
	

	/**
	 * Test the writeToFile method
	 * write the array to the outputFile File
	 * then read it back to make sure formatted correctly to read
	 * 
	 */
	@Test
	public void testWriteToFile() throws FileNotFoundException 
	{
		double[][] array=null;
		try {
			TwoDimRaggedArrayUtility.writeToFile(dataSetSTUDENT2, outputFile);
		} catch (Exception e) {
			fail("This should not have caused an Exception");
		}
		array = TwoDimRaggedArrayUtility.readFile(outputFile);
		assertEquals(-50, array[0][0],.001);
		assertEquals(304, array[0][1],.001);
		assertEquals(603, array[0][2],.001);
		assertEquals(704, array[1][0],.001);
		assertEquals(500, array[1][1],.001);
		assertEquals(-78, array[1][2],.001);
		assertEquals(5360.80, array[2][0],.001);
		assertEquals(60680.90, array[2][1],.001);
		assertEquals(503, array[2][2],.001);
		assertEquals(0, array[2][3],.001);	
	}

}
