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
 * This is the HolidayBonus class for the 2D Ragged Array we are processing; the holiday bonus is calculated here
 * @author Matthew McNey
 */

public class HolidayBonus extends TwoDimRaggedArrayUtility 
{
	/**
	 * This is the constructor for the HolidayBonus class
	 */
	public HolidayBonus() 
	{
		
	}

	/**
	 * pass in a 2D ragged array of doubles, the bonus for highest sales, bonus amount for lowest sales and bonus for all other stores. 
	 * Return an array of doubles representing holiday bonuses for stores in the district.
	 * @param data
	 * @param high
	 * @param low
	 * @param other
	 * @return holidayBonusArray
	 */
	public static double[] calculateHolidayBonus(double[][] data, double high, double low, double other) 
	{
		// declare holiday bonus array
		double holidayBonusArray[] = new double[data.length];
		
			// run through the rows; also represents the stores
			for (int row = 0; row < data.length; row++)
			{
				// run through the columns; also represents th categories
				for (int col = 0; col < data[row].length; col++)
	        	{
					// make sure our values are greater than 0; you should not get a bonus if you haven't made any money!
					if(data[row][col] > 0)
					{
						// if the store is doing well in that category; they get the high bonus
						if(data[row][col] == getHighestInColumn(data, col))
						{
							holidayBonusArray[row] += high;
						}
						// if the store is doing badly in that category; they get the low bonus
						else if(data[row][col] == getLowestInColumn(data, col))
						{
							holidayBonusArray[row] += low;
						}
						// if the store is neither doing well or badly in that category; they get the "other" bonus
						else
						{
							holidayBonusArray[row] += other;
						}
					}
				}
			}
		// return the array of bonuses	
		return holidayBonusArray;
	}
	
	/**
	 * pass in a 2D ragged array of doubles, and the bonus for store with highest sales, bonus for lowest and bonus amount for all other stores. 
	 * Return double representing the total of all Holiday Bonuses for the District.
	 * @param data
	 * @param high
	 * @param low
	 * @param other
	 * @return holidayBonusTotal
	 */
	public static double calculateTotalHolidayBonus(double[][] data, double high, double low, double other) 
	{
		// declare the accumulator
		double holidayBonusTotal = 0;
		
		// run through the row
		for (int row = 0; row < data.length; row++)
		{
			// run through the columns
			for (int col = 0; col < data[row].length; col++)
        	{
				// make sure greater than 0
				if(data[row][col] > 0)
				{
					// total up the highest
					if(data[row][col] == getHighestInColumn(data, col))
					{
						holidayBonusTotal += high;
					}
					
					// total up the lowest
					else if(data[row][col] == getLowestInColumn(data, col))
					{
						holidayBonusTotal += low;
					}
			
					// total up the others
					else
					{
						holidayBonusTotal += other;
					}
				}
			}
		}
		// return the sum
		return holidayBonusTotal;
	}

}
