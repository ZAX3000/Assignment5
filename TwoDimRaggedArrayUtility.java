import java.io.*;
import java.util.*;

/** 
 * Class: CMSC203 22297 
 * Instructor: Prof. Grigoriy Grinberg 
 * Description: Create a sales report from a 2D Ragged Array
 * Assignment: #5
 * Due: 11/15/2021
 * Platform/compiler: Eclipse JDK 16.0.2
 * I pledge that I have completed the programming assignment independently. I have not copied
 * the code from a student or any source. I have not given my code to any student. 
 * 
 * This is the utility class for the 2D Ragged Array we are processing
 * @author Matthew McNey
 */

public class TwoDimRaggedArrayUtility 
{
	
	/**
	 * This is the constructor
	 */
	
	public TwoDimRaggedArrayUtility() 
	{
		
	}

	/**
	 * Let's get the average for the total sum of columns and rows
	 * @param data
	 * @return average
	 */
	
	public static double getAverage(double[][] data) 
	{
		// create average variable
		double average = 0;
        int count = 0;
        
     // let's first run over the row based on the total number of rows in the array
        for (int row = 0; row < data.length; row++)
        {
        	// now let's run through each column in the row
        	for (int column = 0; column < data[row].length; column++)
			{
        		// let's count them all
    			count += 1;        			
			}
        }
		
		// average calculation grab the total divided by the dataset count
		average = getTotal(data) / count; 
		
		return average;
	}
	
	/**
	 * Let's get the total amount of a column
	 * @param data
	 * @param col
	 * @return total
	 */
	public static double getColumnTotal(double[][] data, int col) 
	{
		double total = 0;  // Accumulator
		
		// let's first run over the row based on the total number of rows in the array
        for (int row = 0; row < data.length; row++)
        {
        	// now let's run through each column in the row
        	for (int column = 0; column <= col && column < data[row].length; column++)
			{
        		// however, we only want one column we've passed in
        		if (column == col)
        		{	
        			// sum it all up
    				total += data[row][col];        			
        		}
			}
        }
		
		return total;
	}

	
	/**
	 * Find the highest element in the entire array; store the value of the element in highest and return it
	 * @param data
	 * @return highest
	 */
	
	public static double getHighestInArray(double[][] data) 
	{
		// this variable holds the highest maximum value
		double highest = 0;
		
		// runs through the rows
		for (int row = 0; row < data.length; row++)
		{
			// runs through the columns
			for (int col = 0; col < data[row].length; col++)
			{
				// is it the highest value at this element?
				if (data[row][col] > highest)
				{
					highest = data[row][col];
				}
			}
		}
		
		return highest;
	}

	/**
	 * Get the highest value in a specified column
	 * @param data
	 * @param col
	 * @return highest
	 */
	
	public static double getHighestInColumn(double[][] data, int col) 
	{
		// this variable holds the highest maximum value
		double highest = 0;
		
		// let's first run over the row based on the total number of rows in the array
        for (int row = 0; row < data.length; row++)
        {
        	// now let's run through each column in the row
        	for (int column = 0; column <= col && column < data[row].length; column++)
			{
        		// however, we only want one column we've passed in
        		if (column == col)
        		{	
        			// do we have the highest value in this column?
        			if (data[row][column] > highest)
        			{
        				highest = data[row][col];
        			}
        		}
			}
        }
		return highest;
	}

	/**
	 * Find the index of the element with the highest value
	 * @param data
	 * @param col
	 * @return highestIndex
	 */
	
	public static int getHighestInColumnIndex(double[][] data, int col) 
	{
		// this variable holds the highest maximum value
		int highestIndex = 0;
		
		// runs through the rows
		for (int row = 0; row < data.length; row++) 
		{
			// runs through the columns; here column is held based on passed in value
			for (int column = 0; column < data[row].length; column++)
			{
        		// however, we only want one column we've passed in
        		if (column == col)
        		{
        			// let's look for the lowest index in that column
        			if (data[row][column] > data[highestIndex][column])
        			{
        				highestIndex = row;
        			}
        		}
			}
		}
		
		return highestIndex;
	}

	/**
	 * Get the highest value in a row
	 * @param data
	 * @param row
	 * @return highest
	 */
	public static double getHighestInRow(double[][] data, int row) 
	{
		// this variable holds the highest maximum value
		double highest = 0;
		
		// runs through the columns
			for (int col = 0; col < data[row].length; col++)
			{
				// is it the highest value at this element?
				if (data[row][col] > highest)
				{
					highest = data[row][col];
				}
			}
		
		return highest;
	}
	
	/**
	 * Get the index of the element with the highest value in a specified row
	 * @param data
	 * @param row
	 * @return highestIndex
	 */

	public static int getHighestInRowIndex(double[][] data, int row) 
	{
		// this variable holds the highest maximum value
		int highestIndex = 0;

			// runs through the columns
			for (int col = 0; col < data[row].length; col++)
			{
				// what is the highest index at this element?
				if (data[row][col] > data[row][highestIndex])
				{
					highestIndex = col;
				}
			}
		
		return highestIndex;
	}
	
	/**
	 * Get the lowest value in the entire array
	 * @param data
	 * @return lowest
	 */

	public static double getLowestInArray(double[][] data) 
	{
		// this variable holds the lowest minimum value
		double lowest = data[0][0];
		
		// this runs through the rows
		for (int row = 0; row < data.length; row++)
		{
			// runs through the columns
			for (int col = 0; col < data[row].length; col++)
			{
				// checks if it is the lowest value
				if (data[row][col] < lowest)
				{
					lowest = data[row][col];
				}
			}
		}
		return lowest;
	}

	/**
	 * Get the lowest value in a column
	 * @param data
	 * @param col
	 * @return lowest
	 */
	
	public static double getLowestInColumn(double[][] data, int col) 
	{
		// this variable holds the lowest minimum value
		double lowest = data[0][col];
		
        // let's first run over the row based on the total number of rows in the array
        for (int row = 0; row < data.length; row++) 
        {
        	// now let's run through each column in the row
        	for (int column = 0; column <= col && column < data[row].length; column++)
        	{
        		// however, we only want one column we've passed in
        		if (column == col)
        		{
        			// let's look for the lowest value in that column
        			if (data[row][column] < lowest)
        			{
        				lowest = data[row][col];
        			}
        		}
        	}
        }
		
		return lowest;
	}

	/**
	 * Get the index of the lowest value in a column
	 * @param data
	 * @param col
	 * @return lowestIndex
	 */
	
	public static int getLowestInColumnIndex(double[][] data, int col) 
	{
        int lowestIndex = 0; // lowest index
        
        // let's first run over the row based on the total number of rows in the array
        for (int row = 0; row < data.length; row++) 
        {
        	// now let's run through each column in the row
        	for (int column = 0; column < data[row].length; column++)
        	{
        		// however, we only want one column we've passed in
        		if (column == col)
        		{
        			// let's look for the lowest index in that column
        			if (data[row][column] < data[lowestIndex][column])
        			{
        				lowestIndex = row;
        			}
        		}
        	}
        }
		
		return lowestIndex;
	}

	/**
	 * Get the lowest value in a specified row
	 * @param data
	 * @param row
	 * @return lowest
	 */
	
	public static double getLowestInRow(double[][] data, int row) 
	{
		// this variable holds the lowest minimum value
		double lowest = data[row][0];
		
		// runs through the columns
		for (int col = 0; col < data[row].length; col++)
		{
			// is it the lowest value at this element?
			if (data[row][col] < lowest)
			{
				lowest = data[row][col];
			}
		}
		
		return lowest;
	}
	
	/**
	 * Get the index of the lowest value in a row
	 * @param data
	 * @param row
	 * @return lowestIndex
	 */

	public static int getLowestInRowIndex(double[][] data, int row) 
	{
		// this variable holds the lowest minimum value
		int lowestIndex = 0;
		// runs through the columns
		for (int col = 0; col < data[row].length; col++)
		{
			// is it the lowest value at this element?
			if (data[row][col] < data[row][lowestIndex])
			{
				lowestIndex = col;
			}
		}
		
		return lowestIndex;
	}

	/**
	 * Get the total values of a specified row
	 * @param data
	 * @param row
	 * @return total
	 */
	
	public static double getRowTotal(double[][] data, int row) 
	{
		double total = 0; // Accumulator
			
			// Sum the columns up
			for (int col = 0; col < data[row].length; col++)
			{	
				total += data[row][col];
			}
		
			return total;
	}
	
	/**
	 * Get the total of all the values in the array
	 * @param data
	 * @return total
	 */

	public static double getTotal(double[][] data) 
	{
		double total = 0; // Accumulator, set to 0
		
		// Sum the array elements.
		for (int row = 0; row < data.length; row++)
		{
			for (int col = 0; col < data[row].length; col++)
			{
				total += data[row][col];
			}
		}
		
		return total;
	}
	
	/**
	 * Reads from a file and returns a ragged array of doubles
	 * 
	 * @param file
	 * @return tempArray
	 * @throws java.io.FileNotFoundException
	 */
	
	public static double[][] readFile(java.io.File file) throws java.io.FileNotFoundException
	{
		// create a scanner class for the passed in file object
	    Scanner inputFile = new Scanner(file);

	    // create a counter; this will count the rows to be used as a limit for each array we create
	    int rowCounter = 0;
	    
	    // check to make sure there is something there
	    while (inputFile.hasNextLine())
	    {
	    	// creating the row limit
	    	rowCounter++;
	    	inputFile.nextLine();
	    }
	    
	    // close the input file
	    inputFile.close();
	    
	    // create the temp array
	    double[][] tempArray = new double[rowCounter][];
	    inputFile = new Scanner(file);

	    // creates a line counter
	    int lineCount = 0;
	    while (inputFile.hasNextLine()) 
	    {
	    // creates an array to store the Strings
	      String[] currentLine = inputFile.nextLine().trim().split("\\s+");
	      // take the length of the String passed and use it to initialize the temp array with a row dimension
	      tempArray[lineCount] = new double[currentLine.length];
	      // run through the strings in the tempArray and turn them into double values   
	      	for (int i = 0; i < currentLine.length; i++) 
	         {
	            tempArray[lineCount][i] = Double.parseDouble(currentLine[i]);    
	         }
	         //increment the counter
	      lineCount++;
	     }
	    
	    // close the inputFile
	    inputFile.close();
		
	    // return the temp array
		return tempArray;
	}
	
	/**
	 * Writes the ragged array of doubles into the file.
	 * @param data
	 * @param outputFile
	 * @throws java.io.FileNotFoundException
	 */
	
	public static void writeToFile(double[][] data, java.io.File outputFile) throws java.io.FileNotFoundException
	{
			// create a Printwriter class for the passed in outputFile
			PrintWriter outputFileInside = new PrintWriter(outputFile);
		    
			// run through the rows
			for (int row = 0; row < data.length; row++)
		    {
				// then the columns
		    	for (int col = 0; col < data[row].length; col++)
		    	{
		    		// add the data separated by a space
		    		outputFileInside.print(data[row][col] + " ");
		    	}outputFileInside.println(); // jump a line once you finish a whole line of values
		    }
		    
		    // Close the file.
		    outputFileInside.close();
	}

}
