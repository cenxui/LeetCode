package twosum;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TwoSumTest {
	int[] NumberUpSupported = {2, 7, 11, 15};
	int Target = 9;
	TwoSum twoSum;
	int[] Expect = {0,1};

	@Before
	public void setUp() throws Exception {
		twoSum = new TwoSum();
	}

	@Test
	public void test() {
		int[] result = twoSum.twoSum(NumberUpSupported, Target);
		assertArrayEquals(Expect, result);
	}

}
