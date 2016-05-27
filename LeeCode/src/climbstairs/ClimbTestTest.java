package climbstairs;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ClimbTestTest {
	ClimbStairs mClimStairs;

	@Before
	public void setUp() throws Exception {
		mClimStairs = new ClimbStairs();
	}

	@Test
	public void test() {
		assertEquals(8, mClimStairs.climbStairs(5),0);
	}
}
