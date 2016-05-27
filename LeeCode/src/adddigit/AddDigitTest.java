package adddigit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AddDigitTest {
	AddDigit add;
	int Number = 9;
	@Before
	public void setUp() throws Exception {
		add = new AddDigit();
	}

	@Test
	public void test() {
		assertEquals(9, add.addDigits(Number),0);
	}

}
