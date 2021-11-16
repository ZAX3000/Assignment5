import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HolidayBonusTestSTUDENT {
	private double[][] dataSetSTUDENT1 = {	{30002,6078054,304,603},
			{704,500,400},
			{5340.60,60640.60,503,604}};

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	public void testCalculateHolidayBonus() {
		try{
		double[] result = HolidayBonus.calculateHolidayBonus(dataSetSTUDENT1,5000,1000,2000);
		assertEquals(12000.0,result[0],.001);
		}
		catch (Exception e) {
			fail("This should not have caused an Exception");
		} 
	}

}
