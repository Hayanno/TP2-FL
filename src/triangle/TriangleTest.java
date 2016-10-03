package triangle;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class TriangleTest {
	private Triangle triangle;
	
	@Test
	public void testTriangle() {
		triangle = new Triangle(1, 1, 1);
		assertNotNull(triangle);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTriangleAnySideIsNotPositive() {
		triangle = new Triangle(0, 1, 2);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTriangleSidesViolatesTriangleInequality() {
		triangle = new Triangle(1, 2, 4);
	}
}
